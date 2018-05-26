package com.ipartek.examen.pojo;

public class Consulta {
	
	private String nombre="";
	private String code="";
	public Consulta() {
		super();
		this.nombre="";
		this.code="";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Consulta [nombre=" + nombre + ", code=" + code + "]";
	}

}
