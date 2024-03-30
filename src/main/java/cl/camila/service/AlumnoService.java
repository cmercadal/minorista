package cl.camila.service;

import java.util.List;

import cl.camila.model.Alumno;

public interface AlumnoService {
	
	public void save(Alumno alumno);
	Alumno findByRut(String rut);
	List<Alumno> findAll();

}
