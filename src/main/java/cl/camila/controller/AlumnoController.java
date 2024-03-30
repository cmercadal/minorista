package cl.camila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.camila.model.Alumno;
import cl.camila.service.AlumnoService;

@RestController  
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Alumno alumno){
		alumnoService.save(alumno);
	}
	
	@GetMapping("/rut/{rut}")
	@ResponseStatus(HttpStatus.FOUND)
	Alumno findByRut(@PathVariable String rut){
		return alumnoService.findByRut(rut);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<Alumno> findAll(){
		return alumnoService.findAll();
	}
	
	
}
