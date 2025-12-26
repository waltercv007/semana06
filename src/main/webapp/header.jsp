<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary mb-4">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">
	    	<img src="img/logo.png" alt="" width="30px"> Cesta Fresca    	
	    </a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <!--  INICIO DEL MENU DE OPCIONES -->
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="inicio.jsp">Inicio</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="<%= request.getContextPath() %>/ProductoController?accion=listar">Productos</a>
	        </li>
<!--  
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Productos
	          </a>
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/ProductoController?accion=listar">Listar</a></li>
	            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/ProductoController?accion=agregar">Agregar</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
-->        
	        <li class="nav-item">
	          <a class="nav-link" href="#">Categoria</a>
	        </li>
	        
	      </ul>
		
	    </div>
	    <!--  FIN DEL MENU DE OPCIONES -->
	  </div>
	</nav>
</header>