<!--função para ativar animação do menu-->
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
    
    /*a função abaixo faz com que a pagina va para o lado quando abrir o menu*/
 /* document.getElementById("main").style.marginLeft = "250px";*/
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}