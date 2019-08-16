$(document).ready(function() {
	
	var headElement1 = $('.head-element-1');
    var headElement2 = $('.head-element-2');
    var headElement3 = $('.head-element-3');

    var bodyElement1 = $('.body-element-1');
    var bodyElement2 = $('.body-element-2');
    var bodyElement3 = $('.body-element-3');
    
    function hideBodyElement(element) {
        $(element).hide();
    }

    function activeBodyElement(element, body) {
        $(element).click(function() {
            $(body).slideToggle();
        });
    }

    hideBodyElement(bodyElement1);
    hideBodyElement(bodyElement2);
    hideBodyElement(bodyElement3);

    activeBodyElement(headElement1, bodyElement1);
    activeBodyElement(headElement2, bodyElement2);
    activeBodyElement(headElement3, bodyElement3);

});