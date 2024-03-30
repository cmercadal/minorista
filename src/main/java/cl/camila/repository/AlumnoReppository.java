package cl.camila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.camila.model.Alumno;

@Repository
public interface AlumnoReppository extends JpaRepository<Alumno, Long> {

	//save
	//findAll
	//findById
	//delete
	
	Alumno findByRut(String rut);

	Alumno save(Alumno alumno);
}
