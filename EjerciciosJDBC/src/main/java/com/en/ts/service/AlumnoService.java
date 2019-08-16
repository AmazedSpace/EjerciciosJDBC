package com.en.ts.service;

import java.util.List;

import com.en.ts.entity.Alumno;

public interface AlumnoService {
	
	public Alumno findByDni(String dni);
	public List<Alumno> findAll();
	public Integer create(Alumno alumno);
	public Integer delete(String dni);
	public Integer update(String dni, String nombre, String apellidos, Integer edad);

}
