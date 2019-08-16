package com.en.ts.service;

import java.util.List;

import com.en.ts.entity.Alumno;
import com.en.ts.repository.AlumnoRepositoryImpl;

public class AlumnoServiceImpl implements AlumnoService {

	AlumnoRepositoryImpl ar;
	
	public Alumno findByDni(String dni) {
		return ar.findByDni(dni);
	}

	public List<Alumno> findAll() {
		return ar.findAll();
	}

	public Integer create(Alumno alumno) {
		return ar.create(alumno);
	}

	public Integer delete(String dni) {
		return ar.delete(dni);
	}

	public Integer update(String dni, String nombre, String apellidos, Integer edad) {
		return ar.update(dni, nombre, apellidos, edad);
	}

	public AlumnoServiceImpl() {
		ar = new AlumnoRepositoryImpl();
	}

}