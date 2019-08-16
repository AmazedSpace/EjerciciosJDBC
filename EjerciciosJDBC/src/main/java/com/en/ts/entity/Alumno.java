package com.en.ts.entity;

public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private Integer edad;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return String.format("Alumno [dni=%s, nombre=%s, apellidos=%s, edad=%s]", dni, nombre, apellidos, edad);
	}
	
	public Alumno(String dni, String nombre, String apellidos, Integer edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
}
