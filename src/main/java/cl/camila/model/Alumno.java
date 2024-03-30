package cl.camila.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rut;
	private String nombre;

	//objeto q será constituido a partir de un json
	@JsonManagedReference
	@ManyToMany
	private Set<Materia> materiaList;

	public Alumno(String nombre, String rut){
		this.nombre = nombre;
		this.rut = rut;
	}
}		
