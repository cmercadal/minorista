package cl.camila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.camila.model.Materia;
import cl.camila.repository.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Transactional(readOnly = false)
	@Override
	public void save(Materia materia) {
		materiaRepository.save(materia);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Materia> findAll() {
		// TODO Auto-generated method stub
		return materiaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Materia> findById(Long id) {
		// TODO Auto-generated method stub
		return materiaRepository.findById(id);
	}

}
