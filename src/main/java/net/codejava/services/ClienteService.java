package net.codejava.services;

import net.codejava.entity.RegistroCliente;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.RegistroClienteRepository;

@Service
@Transactional
public class ClienteService {

	@Autowired
	private RegistroClienteRepository repo;
	
	public List<RegistroCliente> listAll() {
		return repo.findAll();
	}
	
	public void save(RegistroCliente registro) {
		repo.save(registro);
	}
	
	public RegistroCliente get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
        
}
