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
		}, 
		error: function() {
			alert('Algo não está certo...')
		}
	});
	
function booksUser(current_id) {
	$.ajax({
		 url: 'http://localhost:8082/book/action/doado/user/'+current_id,
		 headers: {
		      'Content-Type':'application/json'
		    },
		 type: 'get',
	     contentType: 'application/json',
	     success: function(data){
	    	 bookBox(data)
			}, 
			error: function() {
				alert('Algo não está certo...')
			}
		});
	}
});

	function bookBox(json){
		let idBox = $("#book-box")
		json.forEach(function(item){
			idBox.append(
				"<li class='grid-4'>"
				 + "<div class='livro book-info'>"
		         + "<img src='img/notebook.png' alt='livros' style='width: 100%'>"
		         + "<center><p>" + item.title + "</p><br>"
		         + "<p> " + item.author + "</p><br>"
		         + "<p> " + item.publisher + "</p><br>"
		         + "<p> Doou para " + item.emailFriend + "</p><br>"
		         + "<p> Status: " + item.available + "</p><br></center>"
		         + "</div><br><br>"
		         + "</li>"
		        );
		}); 
	 }	

