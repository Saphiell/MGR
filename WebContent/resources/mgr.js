var obtainedModel = {data:[], modelName:""};

$(document).ready(function(){
	$("#GetDataset").click(function(){
			
			var select = document.getElementById("id");
			var iReflectance = document.getElementById("iReflectance").value;
			var jReflectance = document.getElementById("jReflectance").value;
			var selectedValue = select.options[select.selectedIndex].value;
			debugger;
			
			if(iReflectance=== undefined || isNaN(iReflectance))
			{
				iReflectance = "0";
			}
			if(jReflectance=== undefined || isNaN(jReflectance))
			{
				jReflectance = "0";
			}
			
			
			var obtainedModelsArray = new Array();
			if(selectedValue!=="0"){
				var selectedValueString= "id="+selectedValue+"&iReflectance="+iReflectance+"&jReflectance="+jReflectance;
				$.ajax({
					dataType:'json',
					url:'getModels.html',
					
					data: selectedValueString,
					contentType: "application/json",
					success:function(response){
						var model = obtainedModel;
						var responseObject = JSON.parse(response);
						for(var i = 0; i<responseObject.length;i++){
							model = responseObject[i];
							obtainedModelsArray.push(model);
							var ctx = document.getElementById("scatterChart"+i);
							
							displayChart(ctx, model.data,model.modelName)
						}		
					},
					error:function(error){
						console.log(error);
					}
					
				});	
			}
			
	});
});
var displayChart = function(ctx, modeldataset, modelLabel){
	var scatterChart = new Chart(ctx,{
		type:'scatter',
		data:{			
			label:modelLabel,
			data: modeldataset,
			pointColor: '#F16220'
			
		},
		options:{
			title: {
				display: true,
				text: modelLabel
			},
			scales:{
				xAxes:[{
					type:'linear',
					position:'bottom',
					scaleLabel: {
						labelString: 'Depth by SBE soundings',
						display: true
					}
						
				}],
				yAxes:[{
					type:'linear',
					position:'left',
					scaleLabel: {
						labelString: 'SDB obtained by model',
						display: true,
					}
				}]
			},
			elements:{
				line:{
					tension:0
				}
			},
			showlines: false,
			showScale: true,
			scaleLineColor: "rgba(0,0,0,.1)",
			pointDot: true,
			pointDotStrokeWidth:1,
			pointDotRadius:3,
			pointHitDetectionRadius:2,
			emptyDataMessage:"Chart has no data available"			
		}
	});
}




