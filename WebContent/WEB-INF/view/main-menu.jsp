<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

<link href="resources/style.css" type ="text/css" rel ="stylesheet"/>
<script src="resources/mgr.js" type="text/javascript" ></script>


<title>Spring MVC Demo</title>
</head>
<body>


<hr>
	<div class="mainPage">
		<div id="main-menu" class="menu" >
			<label class="label">Menu</label>
			<div>
			
				<form:form modelAttribute="folderForm" action="getfoldernames" method = "get">
					<form:select path= "id" >
						
						<form:option value="0" label="Select an Option" />
						<form:options items ="${folders}" multiple="true" itemLabel="name" itemValue="id" />
						
					</form:select>
					
					<div class="btn-group-vertical" style="margin:1%;">								
						<input type = "submit" class="btn btn-primary" name="Add" value="Add Folder"/>
						<input type = "submit" class="btn btn-primary" name="Delete" value="Delete Folder"/>
						<input type = "button" class="btn btn-primary" value="Get Data" id="GetDataset"/>
						<input type = "hidden" name="folder" value=""/>
					</div>
										
				</form:form>
				
				<div style="display:flex; flex-direction:column;">
					<label class="label">Options</label>
					<fieldset style="flex-direction:column;">
						<label class="OptionLabel">Reflectance for green band</label>
						<input type="text" id="iReflectance" value="0"/>
					</fieldset>
					<fieldset>
						<label class="OptionLabel">Reflectance for blue band</label>
						<input type="text" id="jReflectance" value="0"/>
					</fieldset>
					
				</div>
					
			</div>		
		</div>

		<div class="col-8" id="app-graphs" class="graphPages">\
			<div class="chart"> 
				<canvas id="scatterChart0" width="inherit" height="inherit"></canvas>
			</div>
			<div class="chart">
				<canvas id="scatterChart1" width="inherit" height="inherit"></canvas>
			</div>
		
		
			asd
		</div>
		<div id="app-description">
			<div class="descriptionPage">
			    <label class="label">Add thoughts </label>
			    <div class="container">
			        <form:form action="getDescription" class="description" >           
			            <textarea class="" rows="30" cols="50" name="descriptionField" type="text"> </textarea>
			            <input type="submit" name="Save" class="btn btn-primary" value="Save" style="width:fit-content;"/>
			        </form:form>
			    </div>
			</div>		
		</div>			
	</div>

</body>
</html>