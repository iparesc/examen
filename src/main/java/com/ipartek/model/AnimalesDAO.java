package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.model.ConnectionManager;
import com.ipartek.examen.pojo.Animal;


public class AnimalesDAO {
	private static AnimalesDAO INSTANCE = null;

	// Private constructor NO se pueda hacer new y crear N instancias
	private AnimalesDAO() {
	}

	// creador synchronized para protegerse de posibles problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AnimalesDAO();
		}
	}

	public static AnimalesDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	public ArrayList<Animal> getAll() {
		ArrayList<Animal> lis = new ArrayList<Animal>();
		String sql = "SELECT pprueba.id, pprueba.nombre FROM `pprueba` ORDER BY pprueba.id DESC LIMIT 500";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Animal m = null;
			while (rs.next()) {
				m = mapper(rs);
				lis.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	public Animal mapper(ResultSet rs) throws SQLException {
		Animal m = null;
		if (rs != null) {
			m = new Animal();
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			
		}
		return m;
	}
}
