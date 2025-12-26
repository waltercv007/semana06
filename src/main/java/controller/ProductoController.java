package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ProductoController")

public class ProductoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	Producto objPro = new Producto();
		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				processRequest(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				processRequest(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, ClassNotFoundException, SQLException {

			String accion = request.getParameter("accion");					
			
				switch (accion) {
					case "listar":
						listarProductos(request, response);
						break;
					case "guardar":
						//response.getWriter().append("Estoy listo para guardar");
						guardarProducto(request, response);
						break;
					case "eliminar":
						eliminarProducto(request, response);
						break;
					case "editar":						
						mostrarFormularioEditar(request, response);
						break;
					case "actualizar":						
						actualizarProducto(request, response);
				}

		}
		
	// --- MÉTODOS DEL CONTROLADOR ---
	
		private void listarProductos(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 1. Llama al Modelo para obtener los datos
			List<Producto> listaProductos = objPro.obtenerTodosLosProductos();
	
			// 2. Guarda los datos en el request para la Vista
			request.setAttribute("listaProductos", listaProductos);
	
			// 3. Redirige a la Vista (JSP)
			request.getRequestDispatcher("guiProducto.jsp").forward(request, response);
		}
   				
		private void guardarProducto(HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			// 1. Recoger datos del formulario
			String nombre = request.getParameter("txtNombre");
			double precio = Double.parseDouble(request.getParameter("txtPrecio"));
			int stock = Integer.parseInt(request.getParameter("txtStock"));

			// 2. Crear objeto Producto (Modelo) y asignar valores
			Producto nuevoProducto = new Producto();
			nuevoProducto.setNombreProducto(nombre);
			nuevoProducto.setPrecioProducto(precio);
			nuevoProducto.setStockProducto(stock);

			// 3. Llamar al método del Modelo para Guardar
			nuevoProducto.crearProducto();

			// 4. Redirigir a la lista (patrón Post-Redirect-Get)
			response.sendRedirect("ProductoController?accion=listar");
		}
				
		private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
				throws IOException {
			// 1. Obtener el ID del producto a eliminar
			int id = Integer.parseInt(request.getParameter("id"));

			// 2. Llamar al método del Modelo para Eliminar
			objPro.eliminarProducto(id);

			// 3. Redirigir a la lista
			response.sendRedirect("ProductoController?accion=listar");
		}
		
		private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
						
			// 1. Obtener el ID del producto a editar
				int id = Integer.parseInt(request.getParameter("id"));
				
			// 2. LLamar al modelo para obtener el producto
				Producto productoEditar =  objPro.obtenerProductoPorId(id);
				
			// 3. Guardar el Producto en el request
				request.setAttribute("producto", productoEditar);
				
			// 4. Redirigir al mismo formulario, pero ahora con datos
				request.getRequestDispatcher("guiProducto.jsp").forward(request, response);
			
		}
		
		private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
			
			// 1. Recoger todos lo datos (incluyendo el ID oculto)
			int id = Integer.parseInt(request.getParameter("idProducto"));
			String nombre = request.getParameter("txtNombre");
			double precio = Double.parseDouble(request.getParameter("txtPrecio"));
			int stock = Integer.parseInt(request.getParameter("txtStock"));
			
			// 2. Crear objeto Producto y asignarles valores
			objPro.setIdProducto(id);
			objPro.setNombreProducto(nombre);
			objPro.setPrecioProducto(precio);
			objPro.setStockProducto(stock);
			
			// 3. Llamar al método del MODELO
			objPro.actualizarProducto();
					
			// 4. Redirigir a la VISTA
			//response.getWriter().append("Estoy aqui");
			request.getRequestDispatcher("ProductoController?accion=listar").forward(request, response);
			
		}
		
}








