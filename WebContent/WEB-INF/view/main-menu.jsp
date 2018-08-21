<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
	.left1{
		width: 10%;
		float:left;
		background-color: gray;
		height: 100%;
	}
	.map{
		width: 90%;
		float:right;
		background-color: green;
		height:100%;
	
	}
	.body{
		width:1000px;
		height:1000px;
		
	
	}


</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Demo</title>
</head>
<body>


<hr>

<div class="body">
	<div class="left1" >
		<h3> Badkasldsak</h3>
			<form:form action = "getFolders" modelAttribute = "folders"  method="POST">
				<form:select path="folderName">
						<form:option value="0" label="Select an Option" />
						<form:options items = "${Folder.foldernames}"/>
				</form:select>
			</form:form>
			<br><br>
			<form action="buttonForm" method="GET">	
				
				<input type = "submit" name="button" value="Add"/>
				<br><br>
				<input type = "submit" name="button" value="Delete"/>
				<br><br>
				<input type = "submit" name="button" value="Get"/>
			</form>		
	</div>
	<div class="map">
		<h3>gafasfsafas</h3>	
	</div>
</div>
</body>
</html>