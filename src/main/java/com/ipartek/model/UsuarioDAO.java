package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.ipartek.model.ConnectionManager;
import com.ipartek.model.UsuarioDAO;
import com.ipartek.examen.pojo.Consulta;
import com.ipartek.examen.pojo.Usuario;


public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

	private UsuarioDAO() {
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 * Buscamos un usuario por nombre y password
	 * 
	 * @param nombre
	 *            String nombre del Usuario
	 * @param pass
	 *            String password del Usuario
	 * @return Usuario si existe, null si no lo encuentra
	 */
	public Usuario check(String nombre, String pass) {
		Usuario resul = null;
		String sql = "SELECT id, nombre, password FROM usuario WHERE nombre=? and password = ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, nombre);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					resul = mapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setPass(rs.getString("password"));

		return u;
	}
	public boolean crear(Consulta pojo) {
		boolean resul = false;
		String sql = "INSERT INTO guardarConsultas( nombre,busqueda) values(?,?);";  
				
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getCode());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				
						resul = true;
					}
				
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

}
