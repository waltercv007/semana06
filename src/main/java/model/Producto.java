package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexionMySQL;

public class Producto {
	// Atributos
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;
	private int stockProducto;
	
	// Metodos
	

	public boolean crearProducto() {
				String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
				try (Connection con = ConexionMySQL.obtenerConexion();
					 PreparedStatement ps = con.prepareStatement(sql)) {
		
					ps.setString(1, this.nombreProducto);
					ps.setDouble(2, this.precioProducto);
					ps.setInt(3, this.stockProducto);
		
					int filasAfectadas = ps.executeUpdate();
					return filasAfectadas > 0;
		
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					return false;
				}
	}
						
	public List<Producto> obtenerTodosLosProductos() {
			List<Producto> lista = new ArrayList<>();
			String sql = "SELECT id_producto, nombre, precio, stock FROM productos ";
	
			try (Connection con = ConexionMySQL.obtenerConexion();
				 PreparedStatement ps = con.prepareStatement(sql);
				 ResultSet rs = ps.executeQuery()) {
	
				while (rs.next()) {
					Producto p = new Producto();
					p.setIdProducto(rs.getInt("id_producto"));
					p.setNombreProducto(rs.getString("nombre"));
					p.setPrecioProducto(rs.getDouble("precio"));
					p.setStockProducto(rs.getInt("stock"));
					lista.add(p);
				}
	
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return lista;
	}

	public boolean eliminarProducto(int id) {
		String sql = "DELETE FROM productos WHERE id_producto = ?";
		try (Connection con = ConexionMySQL.obtenerConexion();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			int filasAfectadas = ps.executeUpdate();
			return filasAfectadas > 0;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
	public Producto obtenerProductoPorId(int id) throws ClassNotFoundException, SQLException {
				
		Connection con = ConexionMySQL.obtenerConexion();
		Producto objPro = null;
		
		String sql = "SELECT id_producto,nombre,precio,stock FROM productos WHERE id_producto = ?";
		
		PreparedStatement pstsmt =  con.prepareStatement(sql);
		pstsmt.setInt(1, id);
		
		ResultSet rs = pstsmt.executeQuery();
		
		if(rs.next()) {
			objPro = new Producto();
			
			objPro.setIdProducto(rs.getInt("id_producto"));
			objPro.setNombreProducto(rs.getString("nombre"));
			objPro.setPrecioProducto(rs.getDouble("precio"));
			objPro.setStockProducto(rs.getInt("stock"));
			
		}
				
		return objPro;
	}
	
	public boolean actualizarProducto() throws ClassNotFoundException, SQLException {
		
		Connection con = ConexionMySQL.obtenerConexion();
		String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id_producto = ?";
		PreparedStatement pstsmt =  con.prepareStatement(sql);
		pstsmt.setString(1,nombreProducto);
		pstsmt.setDouble(2, precioProducto);
		pstsmt.setInt(3, stockProducto);
		pstsmt.setInt(4, idProducto);
		
		int filasAfectaron = pstsmt.executeUpdate();
		
		if(filasAfectaron > 0) {
			return true;
		}
		
		return false;
	}
	
	
	// Get y Set
    public Producto() {
    	
    }
    
	public Producto(int idProducto, String nombreProducto, double precioProducto, int stockProducto) {
		
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.stockProducto = stockProducto;
	}
    
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
		
}
