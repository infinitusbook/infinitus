$(document).ready(function(){
	
	$.ajax({
		url: 'http://localhost:8080/id',
		headers: {
			'Content-Type': 'application/json'
		}, 
		type: 'get', 
		contentType: 'application/json', 
		data: null, 
		success: function(data){
			booksUser(data)
			alert('1')
		}, 
		error: function() {
			alert('1_')
			alert('Algo não está certo...')
		}
	});
	
function booksUser(current_id) {
	$.ajax({
		 url: 'http://localhost:8082/book/booksUser/'+current_id,
		 headers: {
		      'Content-Type':'application/json'
		    },
		 type: 'get',
	     contentType: 'application/json',
	     success: function(data){
	    	 alert('2')	
	    	 bookBox(data)
			}, 
			error: function() {
				alert('2_')
				alert('Algo não está certo...' + current_id)
			}
		});
	}
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
		         + "</li>"
		        );
		}); 
	 }	

