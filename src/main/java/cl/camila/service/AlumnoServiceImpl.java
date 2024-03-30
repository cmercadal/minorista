package cl.camila.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.camila.model.Alumno;
import cl.camila.repository.AlumnoReppository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	private final AlumnoReppository alumnoRepository;;
	//Constructor con repo para tests
	@Autowired
	public AlumnoServiceImpl(AlumnoReppository repository) {
		this.alumnoRepository = repository;
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Alumno alumno) {
		alumnoRepository.save(alumno);	
	}

	@Transactional(readOnly = true)
	@Override
	public Alumno findByRut(String rut) {
		return alumnoRepository.findByRut(rut);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

}
