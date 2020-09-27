<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>
<section>
	<div class="container">
		<form id="formWriteBoard" action ="<%=request.getContextPath()%>/board/writeEnd" method="post" enctype="multipart/form-data">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
				</div>
				<input type="text" class="form-control" name="title"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
				<input type="hidden" name="userId" value="<%=logginedMember.getUserId() %>">
			</div>
			<div style="border: 1px lightgray solid; border-radius:5px;  margin-bottom: 10px;">
                <input type="file" name="upfile" style="width: 100%;" placeholder="이미지 첨부">
            </div>
			<textarea name="content" class="form-control" style="resize: none;" rows="30"></textarea>
		</form>
		<div style="height: 55px;">
			<button type="button" onclick="boardList();" style="margin-top: 10px;"
				class="btn btn-outline-secondary float-left">뒤로가기</button>
			<button type="button" onclick="sumitBd();" style="margin-top: 10px;"
				class="btn btn-outline-secondary float-right">작성</button>
		</div>
	</div>
	<script>
		function boardList(){
			let url = "<%=request.getContextPath()%>/board";
			location.href = url;
		}
		function sumitBd(){
			$("#formWriteBoard").submit();
		}
	
	</script>
	
	
</section>
<%@ include file="/views/common/footer.jsp"%>