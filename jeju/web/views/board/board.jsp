<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<%@ page import="com.semi.board.model.vo.Board" %>
<%@ page import="java.util.List" %>

<%
	List<Board> boardList = (List<Board>)request.getAttribute("boardList");
	String searchs = (String)request.getParameter("search");
	String searchType = (String)request.getParameter("searchType");
	System.out.println("검색 내용 boardJsp : "+searchs);
	System.out.println("검색 타입 boardJsp : "+searchType);
	
%>
<section>

<div class="container">
 		<div class="float-right">
        <nav class="navbar navbar-light bg-withe">
            <form action="<%=request.getContextPath() %>/board/search" class="form-inline">
 			<select class="form-control" name="searchType">
 				<option value="BOARD_TITLE"<%if(searchType==null){ %>selected<%} %><%if(searchType!=null&&searchType.equals("BOARD_TITLE")){%> selected<%} %>>제목 </option>
 				<option value="USER_ID"<%if(searchType!=null&&searchType.equals("USER_ID")){ %>selected<%} %>>아이디</option>
 			</select>
              <input name="search" class="form-control mr-sm-2" type="search" aria-label="Search" <%if(searchs!=null){ %>placeholder="<%=searchs %>"<%} %>>
              <button class="btn btn btn-outline-secondary my-2 my-sm-0" type="submit">검색</button>
            </form>
        </nav>
        </div>
        <table class="table table-hover"style="height:800px;">
            <thead class="thead-dark">
                <tr class="row">
                    <th class="col-sm-1">Number</th>
                    <th class="col-sm-6 text-center">제목</th>
                    <th class="col-sm-1 text-center">작성자</th>
                    <th class="col-sm-2 text-center">작성일</th>
                    <th class="col-sm-1 text-center">조회</th>
                    <th class="col-sm-1 text-center">추천</th>
                </tr>
            </thead>
            <tbody>
                <%for(Board b : boardList){ %>
                <tr class="row clickTableRows">
                	<td class="col-sm-1 text-center tableFirstRow"><%=b.getBoardNo() %></td>
                	<td class="col-sm-6 text-center"><%=b.getBoardTitle() %></td>
                	<td class="col-sm-1 text-center"><%=b.getUserId() %></td>
                	<td class="col-sm-2 text-center"><%=b.getBoardDate() %></td>
                	<td class="col-sm-1 text-center"><%=b.getBoardRecommend() %></td>
                	<td class="col-sm-1 text-center"><%=b.getBoardHits() %></td>
                </tr>
                <%} %>
            </tbody>
        </table>
        <div>
            <button onclick="writeBoard();" type="button" class="btn btn-outline-secondary float-right">글쓰기</button>
            <nav aria-label="Page navigation example" style="margin-bottom: 20px;">
                <ul id="pageNavUl" class="pagination justify-content-center">
                    <%=request.getAttribute("pageBar") %>
                </ul>
            </nav>
        </div>
    </div>
    <script>
    	$(".clickTableRows").click(function(e){
    		let boardNo = $(this).children().first().html();
    		let url = "<%=request.getContextPath()%>/boardView?boardNo="+boardNo;
    		console.log(boardNo);
    		console.log(url);
    		location.href=url;
    	});
    	function writeBoard(){
    		let url = "<%=request.getContextPath()%>/board/write";
    		location.href=url;
    	};
    </script>
</section>
<%@ include file="/views/common/footer.jsp" %>
