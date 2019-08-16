$(document).ready(function() {
	
    // Varibale del botón de cerrar formulario de login
    var close_log_reg = $('.btn_close_log_reg');
    var cont_log_reg_reset = $('#cont-log-reg-reset');

    // Variables de botones registrar, loguearse y reset_password
    var btn_login_user = $('.form_login_user');
    var btn_register_user = $('.form_reg_user');
    var btn_reset_user = $('.form_reset_user');

    // Variables de los formularios registrar, loguearse y reset_password
    var form_login = $('#container-log-reg-1');
    var form_register = $('#container-log-reg-2');
    var form_reset = $('#container-log-reg-3');

    close_log_reg.on('click', function() {
        cont_log_reg_reset.fadeToggle();
        cont_log_reg_reset.css('display', 'flex');
    });

    btn_register_user.on('click', function() {
        showFormRegister();
    });
    btn_reset_user.on('click', function() {
        showFormResetPassword();
    });
    btn_login_user.on('click', function() {
        showFormLogin();
    });

    function showFormRegister() {
        form_login.css('display', 'none');
        form_reset.css('display', 'none');
        form_register.fadeIn();
        console.log(form_register);
    }
    function showFormLogin() {
        form_register.css('display', 'none');
        form_reset.css('display', 'none');
        form_login.fadeIn();
        console.log(form_login);
    }
    function showFormResetPassword() {
        form_login.css('display', 'none');
        form_register.css('display', 'none');
        form_reset.fadeIn();
        console.log(form_reset);
    }

});

