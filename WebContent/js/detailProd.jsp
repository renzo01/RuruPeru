$('.btn-cant-add-shop-down').on('click', function() {
			var input = $("input[name='k']");
			var cant = $("input[name='k']").val();
			cant--;
			if(cant <= 0) {
				cant = 1;
			}
			input.val(cant);
		});