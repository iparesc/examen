package com.ipartek.examen.pojo;

public class Usuario {

	private static int id;
	public static String nombre;
	public static String pass;
	
	public Usuario() {
		super();
		this.id = -1;
		this.pass = "";
		this.nombre = "";
	}

	

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + "]";
	}
}
