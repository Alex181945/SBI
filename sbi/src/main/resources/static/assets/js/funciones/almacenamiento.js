/**
 * 
 */


function submit(){
	$('#form').submit();
}

function eliminar(iTipo,ID){
	
	var urlLocal = '';
	
	switch (iTipo) {
	case 1:
		urlLocal = '/config/catalogos/edificio/elimina';
		break;

	default:
		break;
	}
	
	$("#Listas").on('click', '#btnEliminar', function() {
		var row = $(this).closest('tr');
		swal({
			title : 'Eliminar',
			text : "¿Desea eliminar el registro seleccionado?",
			type : 'warning',
			showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'SI',
			  cancelButtonText:  'NO', 
			  closeOnConfirm : false	  
		},function() {

			$.ajax({
				url : urlLocal,
				data : {
					ID : ID
				},
				type : 'POST',
				success : function(data) {

					if (data == "success") {
						row.remove();
						swal.close();
					} else {
						swal('Error!', data, 'error');
					}
				},
				error : function(xhr, status) {
					swal('Disculpe, existió un problema');
				},
				// código a ejecutar sin importar si la petición
				// falló o no
				complete : function(xhr, status) {
					//alert('Petición realizada');
				}
			});

		});

	});
	
}