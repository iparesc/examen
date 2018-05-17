package com.ipartek.examen.pojo;

public class Animal {
	
	private int id;
	private String nombre;
	private String password;
	
	public Animal() {
		super();
		this.id=-1;
		this.nombre="";
		this.password="";
		// TODO Auto-generated constructor stub
	}

	public int getId() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ExamenPojo [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}

}
