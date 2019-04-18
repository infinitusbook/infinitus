function($){
   $("#zipcode").change(function(){
      var cep_code = $(this).val();
      if(cep_code.length <= 0 ) return;
      $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep_code },
         function(result){
            if( result.status!=1 ){
               alert(result.message || "Houve um erro desconhecido");
               return;
            }
            $("input#zipcode").val( result.code );
            $("input#state").val( result.state );
            $("input#city").val( result.city );
            $("input#neighborhood").val( result.district );
            $("input#address").val( result.address );
            $("input#state").val( result.state );
         });
   });
};
