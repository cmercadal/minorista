package cl.camila.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.camila.model.Materia;
import cl.camila.repository.MateriaRepository;

@RestController
@RequestMapping("/api/v1/materias")
public class MateriaController {
	
	@Autowired	
	private MateriaRepository materiaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Materia materia) {
		materiaRepository.save(materia);	
	}
	
	@GetMapping("/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	Optional<Materia> findById(@PathVariable Long id){ 
		return materiaRepository.findById(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<Materia> findAll(){
		return materiaRepository.findAll();
	}
	
	

}
