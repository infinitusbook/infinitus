var current_email = "";
$(document).ready(function(){
	
	$.ajax({
		url: 'http://infinitus-stands.azurewebsites.net/email',
		headers: {
			'Content-Type': 'application/json'
		}, 
		type: 'get', 
		contentType: 'application/json', 
		data: null, 
		success: function(data){
			current_email = data
		}, 
		error: function() {
			alert('Algo não está certo...')
		}
	});
	
	$.ajax({
		url: 'http://localhost:8082/book/borrow',
		headers: {
			'Content-Type': 'application/json'
		}, 
		type: 'get', 
		contentType: 'application/json', 
		data: null, 
		success: function(data){
			bookBoxBorrow(data)
		}, 
		error: function() {
			alert('Algo não está certo...')
		}
	});			
}); 

function bookBoxBorrow(json){
	let idBox = $("#book-box-borrow")
	
	json.forEach(function(item){
		idBox.append(
			 "<div class='livro book-info'>"
		     + "<img src='img/notebook.png' class='slider-image' alt='livros'>"
	         + "<center><p>" + item.title + "</p><br>"
	         + "<p> " + item.author + "</p><br>"
	         + "<p> " + item.publisher + "</p><br>"
	         + "<p> " + item.plusInformation + "</p><br>"
	         + "<p> Status: " + item.available + "</p></center>"
	         + "<button class='querobtn123' onclick=\"sendEmail(\'"+item.email +"\',\'" + current_email + "\'," + item.id+")\">QUERO</button>" 
       		+"</div>"	         
	        );
	}); 
}