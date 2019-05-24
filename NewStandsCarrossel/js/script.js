(function () {
    //https://kenwheeler.github.io/slick/
    $(document).ready(function () {
        $('.first').slick({
            infinite: true,
            slidesToShow: 6,
            slidesToScroll: 5
            
        });
        $('.second').slick({
            infinite: true,
            slidesToShow: 6,
            slidesToScroll: 5
        });
    });

    var livros = [{
        nome: 'livro1',
        desc:'oierpoi',
        imagem: 'img/imagem.jpg'
    },{
        nome: 'livro2',
        desc:'oierpoi',
        imagem: 'img/imagem.jpg'
    }, {
        nome: 'livro3',
        desc:'oierpoi',
        imagem: 'iuyrutbiutnomiuk,oçipli-080p90'
    }]

    function base64toImage(base64){
        var novaImagem = new Image();
        novaImagem.src = base64;       
        return novaImagem
    }

    //faz o loop na resposta da api com a lista de livros
    for(var i =0; i < livros.length; i++){
        //para cada livro, precisamos coverter o código base64 que vira, para uma imagem que consiga ser renderizada no browser
        //para isso, criamos a função 'base64toImage' que faz a conversão que precisamos, e atribui a imagem a variaval 'imagemConvertida'
        var imagemConvertida = base64toImage(livros[i].imagem)
        //criamos nossa estrutura HTML do item do carrossel com 'template string', e usamos as propriedades de cada objeto, como conteudo da nossa estrutura. Atribuimos essa estrutura 
        //a variavel 'item' para posteriormente, adicionarmos ao nosso carrossel
        var item = `<div class="item"><p>${livros[i].nome}</p><p>${livros[i].desc}</p> <img class="slider-single-image" src=${imagemConvertida} alt="2" /></div>`
        //usamor o seletor getelementbyid para pegarmmos o carrossel ao qual vamos adicionar os itens, e atribuimos ele a variavel 'carrossel'
        var carrossel = document.getElementById('livros1')
        //em seguida, escrevemos o html da nossa estrutura (item), dentro do nosso carrossel. Usamos += para sempre pegar o conteudo existente, adicionar o novo
        carrossel.innerHTML += item
    }

})();





{/* <div class="item"> <img class="slider-single-image" src={} alt="2" /></div> */}
