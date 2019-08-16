package com.en.ts.app;

import com.en.ts.service.AlumnoService;
import com.en.ts.service.AlumnoServiceImpl;

public class Main {

	public static void main(String[] args) {

		AlumnoService service = new AlumnoServiceImpl();
		
		//repo.create(new Alumno("1", "FRANCISCO", "PEREZ", 0));
		
		System.out.println(service.findByDni("1"));
		
		System.out.println(service.delete("1"));
		
		System.out.println(service.findAll());
		
		System.out.println(service.update("1", "FRANCISCO", "MARTINEZ", 79));

	}

}
