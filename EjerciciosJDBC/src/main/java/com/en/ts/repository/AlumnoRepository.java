package com.en.ts.repository;

import java.util.List;

import com.en.ts.entity.Alumno;

public interface AlumnoRepository {
	
	public Alumno findByDni(String dni);
	public List<Alumno> findAll();
	public Integer create(Alumno alumno);
	public Integer delete(String dni);
	public Integer update(String dni, String nombre, String apellidos, Integer edad);

}
