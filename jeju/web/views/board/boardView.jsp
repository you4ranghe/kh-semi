<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.semi.board.model.vo.Board"%>
<%@ page import="com.semi.board.model.vo.Comment"%>
<%@ page import="java.util.List"%>
<%
	Board b = (Board) request.getAttribute("board");
List<Comment> commentList = (List<Comment>) request.getAttribute("comment");
int commentPosition = 0;
int replyPosition = 0;
%>

<section>
	<div class="container">
		<table style="margin-top: 10px;" class="table">
			<tbody>
				<tr>
					<th class="text-center"><%=b.getBoardTitle()%></th>
				</tr>
				<tr style="border: 1px lightgray solid; border-radius: 10px;">
					<td>
						<div style="margin: 10px;">
							<br>
							<p>
								<%=b.getBoardContent()%>
							</p>
							<br>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="row" style="height: 25px; margin-bottom: 20px;">
			<label style="margin-top: 5px;" class="col-sm-11 text-right"
				for="jh-recommendation"><%=b.getBoardHits()%></label>
			<div class="col-sm-1">
				<button type="button" onclick="hits();" id="jh-recommendation"
					name="jh-recommendation" class="btn btn-primary">추천</button>
			</div>
		</div>
		<%if(b.getOriginalFN()!=null){ %>
		<hr>
		<div class="text-center">
			
			<p style="font-size: 20px">[사진]</p>
			<img src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameFN() %>">
			
		</div>
		<%} %>
		<hr>
		<div class="row">
			<p class="col-sm-12 text-center">댓글</p>
		</div>
		<%
			if (commentList != null) {
				
		%>
			<div id="comment-conteiner">
		<%	
				if(commentPosition==0){
		%>
			<div class="divInC">
		<%	
				}
			for (Comment c : commentList) {
					%>
					<% 
				if(c.getReplyPosition()<1){
		%>
			<%	
				if(commentPosition!=0){
		%>
				</div>
				<div class="divInC">
		<%} %>
			<hr>
			<form class="hiddened" action="<%=request.getContextPath()%>/boardView/addReply" method="post">
				<div id="addreplydiv" style="margin-left: 30px;">
					<p><%=c.getUserId()%></p>
					<p><%=c.getCommentContent()%></p>
					<input type="hidden" name="commentPosition" value="<%=c.getCommentPosition()%>">
					<input type="hidden" name="userId" value="<%=logginedMember.getUserId()%>">
					<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
				</div>
				<div id="hiddened"></div>
			</form>
		<%}else{ %>
				<div style="margin-left: 70px;">
					<p><%=c.getUserId()%></p>
					<p><%=c.getCommentContent()%></p>
					<hr>
					<input type="hidden" name="replyposition-in-reply" value="<%=c.getReplyPosition() %>">
				</div>
		<%}
		%>
		<%
			replyPosition = c.getReplyPosition();
			commentPosition = c.getCommentPosition();
		%>
		<%
			}
		%>
		</div>
		</div>
		<%
		}
		%>
		<hr>
		<form id="formAddComment"
			action="<%=request.getContextPath()%>/boardView/addComment"
			method="post">
			<div class="row">
				<textarea id="textaread" name="comment" class="form-control"
					style="width: 89%; resize: none; margin-left: 15px;" rows="4"></textarea>
				<button onclick="addComment();" style="margin-left: 5px;"
					type="button"
					class="col-sm-1 btn btn-outline-secondary float-right">댓글작성</button>
			</div>
			<input type="hidden" name="boardNo" value="<%=b.getBoardNo()%>">
			<input type="hidden" name="userId"
				value="<%=logginedMember.getUserId()%>">
			<%
				if (commentList != null) {
			%>
			<input type="hidden" name="commentPosition"
				value="<%=commentPosition + 1%>">
			<%
				} else {
			%>
			<input type="hidden" name="commentPosition" value="1">
			<%
				}
			%>
			<input type="hidden" name="replyPosition" value="0">
		</form>
		<div style="height: 63px;">
			<hr>
			<button onclick="boardList();" type="button"
				class="btn btn-outline-secondary float-left">뒤로가기</button>
		</div>
	</div>
	<script>
		let el = null;
    	function boardList(){
    		let url = "<%=request.getContextPath()%>/board";
			location.href = url;
		}

		function addComment() {
			$("#formAddComment").submit();
		}
		function hits() {
			let url = "<%=request.getContextPath()%>/addHits?boardNo="+<%=b.getBoardNo()%>+"&userId="+"<%=logginedMember.getUserId()%>";
			<%-- let url = "<%=request.getContextPath()%>" --%>
			location.href = url;
		}
		
		$("form.hiddened").on("mouseenter",function(){
			let hiddened = "<div style='height: 30px;'><button id='clicke' type='button' onclick='replywrite(event);' class='btn btn-outline-secondary float-right'>답글 작성</button></div>"
				$(this).children("#hiddened").html(hiddened);
			el=$(this);
		});
		$("form.hiddened").on("mouseleave",function(){
			let hiddeneds = "";
			$(this).children("#hiddened").html(hiddeneds);
			el=null;
		});
		
		function replywrite(e){
			$("#clicke").parent().parent().parent().append("<textarea class='form-control' style='width: 100%; resize: none;'  name='replyComment' cols='30' rows='4'></textarea><div style='width: 100%; height:25px;'><button onclick='addReplySend();' class='qjxms btn btn-outline-secondary float-right' type='button'>작성</button><div>");
			console.log($("form.hiddened"));
			$("form.hiddened").off("mouseleave");
			$("form.hiddened").off("mouseleave");
						
		}
		
		function addReplySend(){
			let replyPo = $(".qjxms").parent().parent().parent().children().last().children().last().val();
			let commentvalue = $(".qjxms").parent().parent().children().eq(2).val();
			console.log($(".qjxms").parent().parent().parent().children().last().children().last().val());
			console.log($(".qjxms").parent().parent().children().eq(2).val());
			console.log(replyPo);
			console.log(commentvalue);
			$(".qjxms").parent().parent().children().first().append("<input type='hidden' name='replyPosition' value='"+replyPo+"'>");
			$(".qjxms").parent().parent().children().first().append("<input type='hidden' name='comment' value='"+commentvalue+"'>");
			$(".qjxms").parent().parent().submit(); 
			
		}
		
		
	</script>
</section>


<%@ include file="/views/common/footer.jsp"%>