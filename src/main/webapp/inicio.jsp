<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Connection" %>
<%@ page import="connection.ConexionMySQL" %>

<!DOCTYPE html>
<html>

	<jsp:include page="head.jsp"></jsp:include>
	
	<body class="container">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<main>
		<!-- Inicio del contenido -->
		
			<section class="container">
			
				<div class="row">
					
					<h1 class="text-center mt-4">Bienvenidos</h1>
					
					<div class="d-flex align-items-center justify-content-center">
						
						<img src="img/logo.png" class="img-fluid" width="400px">
						
					</div>
					
					<%
						Connection con = ConexionMySQL.obtenerConexion();
						
						if(con != null ){
					%>
					
						<p class="text-success">Conexión a MSQL establecida</p>
					
					<%
						}
					%>
								
				</div>	
								
				
			</section>
			
		<!-- Fin del contenido -->			
		</main>
	
		<jsp:include page="footer.jsp"></jsp:include>
				
	</body>
</html>


