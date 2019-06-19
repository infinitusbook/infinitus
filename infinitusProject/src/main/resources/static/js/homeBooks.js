var current_email = "";
$(document).ready(function(){
	
	$.ajax({
		url: 'http://localhost:8080/email',
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
		url: 'http://localhost:8082/book/',
		headers: {
			'Content-Type': 'application/json'
		}, 
		type: 'get', 
		contentType: 'application/json', 
		data: null, 
		success: function(data){
			bookBox(data)
		}, 
		error: function() {
			alert('Algo não está certo...')
		}
	});			
}); 

function bookBox(json){
	let idBox = $("#book-box")
	json.forEach(function(item){
		idBox.append(
			"<li class='grid-4'>"
			 + "<div class='livros_icone'>"
	         + "<img src='img/a%20culpa%20e%20das%20estrelas.jpg' alt='livros'>"
	         + "<p class='book-info'> " + item.title + "</p>"
	         + "<p class='book-info'> " + item.author + "</p>"
	         + "<p class='book-info'> " + item.publisher + "</p>"
	         + "<p class='book-info'> " + item.plusInformation + "</p>"
	         + "<p class='book-info'> Status: " + item.available + "</p>"
	         + "</div>"
	         + "<button class='querobtn123' onclick=\"sendEmail(\'"+item.email +"\',\'" + current_email + "\'," + item.id+")\>QUERO</button></div>"
	         + "</li>"
	        );
	}); 
}