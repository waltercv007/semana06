<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>

	<jsp:include page="head.jsp"></jsp:include>
	
	<body class="container">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<main>
		<!-- Inicio del contenido -->
		
			<section class="container">
			
				<div class="row">
					
					<div class="col-lg-3 col-md-6 col-sm-12 mt-2">
						<!-- INICIO DEL FORMULARIO -->
						<%
							Producto producto = (Producto) request.getAttribute("producto");
							//Valores por defecto
							int id = 0;
							String nombre = "";
							double precio = 0.0;
							int stock = 0;
							String accionFormulario = "guardar";
							String tituloFormulario = "Crear Producto";
							String color = "primary";  
							String boton = "Agregar";
							
							if(producto !=null){
								id = producto.getIdProducto();
								nombre = producto.getNombreProducto();
								precio = producto.getPrecioProducto();
								stock = producto.getStockProducto();
								accionFormulario = "actualizar";
								tituloFormulario = "Editar Producto";
								color = "warning";
								boton = "Editar";
							}														
							
						%>
						<form class="needs-validation" action="ProductoController" method="POST" novalidate > 
						
							<h1 class="text-center text-<%= color %> mb-4"><%= tituloFormulario %></h1>
													
							<input type="hidden" name="accion" value="<%= accionFormulario %>">
										
							<input type="hidden" name="idProducto" value="<%= id %>">			
												
							<div class="form-floating mb-3">
							  <input type="text" name="txtNombre"  value="<%= nombre %>" class="form-control" placeholder="" required>
							  <label>Nombre</label>
							  <div class="invalid-feedback"> Ingrese el nombre</div>
							</div>	
		
							<div class="form-floating mb-3">
							  <input type="number" name="txtPrecio" value="<%= precio %>" min="0" step="0.01" class="form-control" placeholder="" required>
							  <label>Precio</label>
							  <div class="invalid-feedback"> Ingrese el precio</div>
							</div>						
		
							<div class="form-floating mb-3">
							  <input type="number" name="txtStock" value="<%= stock %>" min="0" step="1" class="form-control" placeholder="" required>
							  <label>Stock</label>
							  <div class="invalid-feedback"> Ingrese el stock</div>
							</div>
																																			
							<input class="btn btn-<%= color %> w-100" type="submit" value="<%= boton %>">
													
						</form>	
						<!-- FIN DEL FORMULARIO -->
					</div>
	
					<div class="col-lg-8 col-md-6 col-sm-12 mt-2">
					<!-- INICIO DE LA TABLA -->
					  <div class="table-responsive">
					  <%
						// Recuperar la lista enviada por el ControladorProducto
						List<Producto> lista = (List<Producto>) request.getAttribute("listaProductos");
		            	
		            	if(lista != null)
		            	{
					  %>
						<table class="table table-bordered">
						  <thead>
						    <tr class="text-center">
						      <th scope="col">ID</th>
						      <th scope="col">Nombre</th>
						      <th scope="col">Precio</th>
						      <th scope="col">Stock</th>
						      <th scope="col">Editar</th>
						      <th scope="col">Eliminar</th>
						    </tr>
						  </thead>
						  <tbody>
			            <% 
				            	for(Producto objPro : lista)
				            	{
			            %>
						    <tr class="text-center">
						      <th scope="row"><%= objPro.getIdProducto() %></th>
						      <td> <%= objPro.getNombreProducto() %> </td>
						      <td> <%= objPro.getPrecioProducto() %> </td>
						      <td> <%= objPro.getStockProducto() %> </td>
						      <td> 
						      	<a href="ProductoController?accion=editar&id=<%= objPro.getIdProducto() %>">
						      		<i class="bi bi-pencil-square text-warning"></i>
						      	</a> 
						      </td>
						      <td>
						      	<a href="ProductoController?accion=eliminar&id=<%= objPro.getIdProducto() %>"> 
						      		<i class="bi bi-trash-fill text-danger"></i>
						      	</a>  
						      </td>
						    </tr>
						<%
				            	}
			            	
						%>
						  </tbody>
						</table>
					  <%
	            		}
					  %>
					  </div>
					<!-- FIN DE LA TABLA -->
					</div>			
									
				</div>						
				
			</section>
			
		<!-- Fin del contenido -->			
		</main>
	
		<jsp:include page="footer.jsp"></jsp:include>
				
	</body>
</html>



