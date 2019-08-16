package com.en.ts.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.en.ts.entity.Alumno;

public class AlumnoRepositoryImpl implements AlumnoRepository {

	/**
	 * Open connection
	 * @return Connection
	 */
	private Connection openConnection() {
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/alumnos?serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "1234";
		
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

	/**
	 * Find alumno by dni
	 * @param dni
	 * @return alumno
	 */
	public Alumno findByDni(String dni) {
		
		Connection conn = openConnection();
		Alumno alumno = null;
		String sql = "select * from alumno where alumno_dni like ?";
		
		// Query
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, dni);
			ResultSet result = pst.executeQuery();
			if (result.next()) {
				alumno = new Alumno(result.getString("alumno_dni"), result.getString("alumno_nombre"), result.getString("alumno_apellido"), result.getInt("alumno_edad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Close connection
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alumno;
		
	}

	/**
	 * Find all alumns in database
	 * @return alumns list
	 */
	public List<Alumno> findAll() {

		Connection conn = openConnection();
		List<Alumno> alumnosList = new ArrayList<Alumno>();
		Alumno alumno = null;
		String sql = "select * from alumno";
		
		// Query
		try {
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				alumno = new Alumno(result.getString("alumno_dni"), result.getString("alumno_nombre"), result.getString("alumno_apellido"), result.getInt("alumno_edad"));
				alumnosList.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Connection
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alumnosList;
	}

	/**
	 * Creates a new alumn
	 * @param alumn
	 * @return creation success
	 */
	public Integer create(Alumno alumno) {

		Integer result = 0;
		Connection conn = openConnection();
		String sql = "insert into alumno values (?,?,?,?)";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getApellidos());
			pst.setInt(4, alumno.getEdad());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * Deletes an alum parsing dni
	 * @param dni
	 * @return creation success
	 */
	public Integer delete(String dni) {

		Integer result = 0;
		Connection conn = openConnection();
		String sql = "delete from alumno where alumno_dni like ?";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, dni);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	/**
	 * Updates an alum
	 * @param dni
	 * @param name
	 * @param surname
	 * @return update success
	 */
	public Integer update(String dni, String nombre, String apellidos, Integer edad) {

		Integer result = 0;
		Connection conn = openConnection();
		String sql = "update alumno set alumno_nombre=?, alumno_apellido=?, alumno_edad=? where alumno_dni=?";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, nombre);
			pst.setString(2, apellidos);
			pst.setInt(3, edad);
			pst.setString(4, dni);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
