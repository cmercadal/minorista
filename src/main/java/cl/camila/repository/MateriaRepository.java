package cl.camila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.camila.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

	
}
