<footer>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
	
	<script>
	(() => {
		  'use strict'

		  // Fetch all the forms we want to apply custom Bootstrap validation styles to
		  const forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.from(forms).forEach(form => {
		    form.addEventListener('submit', event => {
		      if (!form.checkValidity()) {
		        event.preventDefault()
		        event.stopPropagation()
		      }

		      form.classList.add('was-validated')
		    }, false)
		  })
		})()						
	</script>

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
	<script>

	 	var mensaje = "${msj}";
	 
		if(mensaje === "create")
		{
	        Swal.fire({
	            title: "Se insertó correctamente!",
	            icon: "success",
	            draggable: true
	        });
		}

	</script>
	
</footer>