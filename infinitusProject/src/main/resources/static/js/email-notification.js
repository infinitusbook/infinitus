function sendEmail(email_owner, email_person_interested, id_book){
		$.ajax({
			 url: 'http://localhost:8081/email-send/',
			 headers: {
			      'Content-Type':'application/json'
			    },
			 type: 'post',
		     contentType: 'application/json',
			 data: JSON.stringify({emailOwner:email_owner, emailPersonInterested: email_person_interested, idBook:id_book}), 
			 error:	function () {
			        alert("Erro ao enviar e-mail. Por gentileza verifique as configurações do antivírus.");
			    },
			 success: function (response) {
			       alert(response);
			    } 
			});
    }
