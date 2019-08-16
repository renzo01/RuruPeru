$(document).ready(function () {

    /*----------------- INICIO: Para sección de redes sociales ---------------------- */
    /* Variable JSON para las 
    rutas de las redes sociales */
    var redes = {
        fb: {
            fb0: "images/content/rs/fb0.png",
            fb1: "images/content/rs/fb1.png",
            fb2: "images/content/rs/fb2.png"
        },
        tw: {
            tw0: "images/content/rs/tw0.png",
            tw1: "images/content/rs/tw1.png",
            tw2: "images/content/rs/tw2.png"
        },
        pt: {
            pt0: "images/content/rs/pt0.png",
            pt1: "images/content/rs/pt1.png",
            pt2: "images/content/rs/pt2.png"
        }
    }

    // Convertir en Array la variable cont_rs
    var cont_rs = Array.from($('.img-social'));

    // Inserta fondo blanco en los elemtnos de redes sociales
    addBackground(cont_rs, "var(--bg-white)");

    // Añade cada 1.5s una imagen
    var contador = 0;
    iterationSocial(contador);
    setInterval(function () {
        iterationSocial(contador);
        contador++;
        if (contador > 2) {
            contador = 0;
        }
    }, 1500);

    // Añade un background
    function addBackground(array, value) {
        array.forEach(element => {
            element.style.backgroundColor = value;
            element.style.background = value;
        });
    }

    // Alterna imágenes de redes sociales
    function iterationSocial(conta) {
        var cant = Object.keys(redes).length;
        for (let i = 0; i < cant; i++) {
            let tipo = Object.keys(redes)[i];
            cont_rs[i].src = redes[tipo][tipo + conta];
        }
    }
    /*----------------- FIN: Para sección de redes sociales ------------------------- */


    /*----------------- INICIO: Para barra de navegación ---------------------- */
    $(window).scroll(function () {
        if ($(this).scrollTop() > 120) {
            $('header').addClass('header-scroll');
            if ($(window).width() < 882) {
                $('nav').addClass('header-scroll');
            }
            else {
                $('nav').removeClass('header-scroll');
            }
        } else {
            $('header').removeClass('header-scroll');
            $('nav').removeClass('header-scroll');
        }
    });

    $(window).resize(function() {
        var tamanio = $(window).width();
        if (tamanio > 882)
            $('nav').fadeIn(0);
        if (tamanio < 884 &&  tamanio > 860)
            $('nav').fadeOut(0);
    });

    $('#btn-main').on('click', function(e) {
        $('nav').fadeToggle();
    });

    /*----------------- FIN: Para barra de navegación ------------------------- */
    
    /*---------------------------------------------------------------------*/
    var btn_adquirir = $('.btn-art-add-shop');
    var content_shop_sale = $('#cont-sale-shop-all');
    var cont_sale_shop = $('#cont-sale-shop');
    var span_contador = $('#cont-icon-shop span');
    
    var conta = 0;
    btn_adquirir.on('click', function() {
    	conta++;
        cont_sale_shop.css('right', '-22rem');
        span_contador.text(contador);
        console.log("hola", contador, cont_sale_shop);
    });
    
    var btn_shop_sale = $('#cont-icon-shop');
    var sino_shop_sale = true;
    
    btn_shop_sale.on('click', function() {
    	
    	if(sino_shop_sale) {
    		cont_sale_shop.css('right', '0rem');
    		content_shop_sale.css('height', '100vh');
    		content_shop_sale.css('background', 'rgba(0, 0, 0, 0.5)');
    		sino_shop_sale = false;
    	} else {
    		sino_shop_sale = true;
    		content_shop_sale.css('height', '0px');
    		cont_sale_shop.css('right', '-22rem');
    	}
    });
});