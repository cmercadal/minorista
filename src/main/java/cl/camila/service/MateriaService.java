package cl.camila.service;

import java.util.List;
import java.util.Optional;

import cl.camila.model.Materia;

public interface MateriaService {
	
	void save(Materia materia);
	List<Materia> findAll();
	Optional<Materia> findById(Long id);

}
