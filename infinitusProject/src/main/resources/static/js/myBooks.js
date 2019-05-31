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
		 url: 'http://localhost:8082/book/booksUser/'+current_id,
		 headers: {
		      'Content-Type':'application/json'
		    },
		 type: 'get',
	     contentType: 'application/json',
	     success: function(data){
	    	 bookBox(data)
			}, 
			error: function() {
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
				 + "<form autocomplete='off' action='#' th:action='@{/bookAction} th:object=${book} method='post' role='form'>"
		         + "<img src='img/a%20culpa%20e%20das%20estrelas.jpg' alt='livros'>"
		         + "<p class='book-info'> " + item.title + "</p>"
		         + "<p class='book-info'> " + item.author + "</p>"
		         + "<p class='book-info'> " + item.publisher + "</p>"
		         + "<p class='book-info'> " + item.plusInformation + "</p>"
		         + "<p class='book-info'> Status: " + item.available + "</p>"
		         + "<select  class='book-update-info' th:field='action' th:id='readlike'>"
		         + "<option value='doar'>Doado</option>"
		         + "<option value='trocar'>Trocado</option>"
		         + "<option value='emprestar'>Emprestado</option>"
		         + "</select>"
		         + "<input class='book-update-info'  th:field='email' placeholder='email'/>"
		         + "<button class='book-update-info' type='submit'>Atualizar Status </button>"
		         + "</form>"
		         + "</div>"
		         + "</li>"
		        );
		}); 
	 }	

