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
		<form:form>
			<form:select path="datafolders">
				<form:options items = "${Folder.foldernames}"/>	
			</form:select>
			<form:button type = "submit" name="action" value="add"/>
			<form:button type = "submit" name="action" value="delete"/>
			<form:button type = "submit" name="action" value="get"/>
		</form:form>		
	</div>
	<div class="map">
		<h3>gafasfsafas</h3>	
	</div>
</div>
</body>
</html>