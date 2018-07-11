<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="/resources/">
<title>uploadAjax</title>
<style>
.fileDrop{
	width : 100%;
	height: 200px;
	border: 1px dotted blue;
	

}

small {
	margin-left: 3px;
	font-weight: bold;
	color:  red;
}


</style>

</head>
<body>

<h3>file upload</h3>
<div class="fileDrop"></div>
<div class="uploadedList"></div>


<script src="plugins/jquery/jquery.min.js"></script>

<script>

	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
		
	});
	
	$(".fileDrop").on("drop", function(e) {
		e.preventDefault();
		
		var file = e.originalEvent.dataTransfer.files;
		
		var file = file[0];
		
		console.log(file);
		
		var formData = new FormData();
		formData.append("file", file);
		
		$.ajax({
			url : '/display/uploadAjax',
			data : formData,
			dataType : 'text',
			processData : false,
			contentType : false,
			type : 'post',
			success : function(data) {
				alert(data);
			}
			
			
		})
		
		
	})
</script>

</body>
</html>