 $(document).ready(function(){

	$("#myUL").on('click','span',function(){
			
		let item = $(this).parent().text();
		item = item.substr(0,item.length-1);
		let payload = {item:item};
		console.log(item);
		
		$.ajax({
			
			url:"/delete",
			type:'POST',
			contentType: "application/json; charset=utf-8",	
			data : JSON.stringify(payload), 	
			success: function(result)
					{
						console.log(result);
						//div.style.display = "none";
					}	
		});
	});
	
	
	
	$(".addBtn").on('click',function(){
			
		
		let item = $("#myInput").val();
		console.log(item);
		document.getElementById("myInput").value = "";
		
		let payload = {item: item , status:0};
		
		$.ajax({
			
			url:"/add",
			type:"POST",
			contentType: "application/json; charset=utf-8",	
			data : JSON.stringify(payload), 	
			success: function(result)
					{
						console.log(result);
					}
			
		});
	});
	
	
	$.ajax({
		
		url:'/get',
		type:'GET',
		success: function (result)
				{
					console.log(result);
					result.forEach( (item)=>{
						
						newElement(item);
					});
					
				}
		
		
	});
	
	
	
	
	function newElement(item) {
		var li = document.createElement("li");
		var inputValue = item
		var t = document.createTextNode(inputValue);
		li.appendChild(t);
		if (inputValue === '') {
			//alert("You must write something!");
		} else {
			document.getElementById("myUL").appendChild(li);
		}
		document.getElementById("myInput").value = "";

		var span = document.createElement("SPAN");
		var txt = document.createTextNode("\u00D7");
		span.className = "close";
		span.appendChild(txt);
		li.appendChild(span);

		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;
				div.style.display = "none";
			}
		}
	}
	
	
	

});