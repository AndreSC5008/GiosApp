
package net.codejava.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.codejava.entity.RegistroCliente;
import net.codejava.entity.CalculadoraPrecio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.RegistroClienteRepository;
import net.codejava.repositories.CotizacionRepository;


@Service
@Transactional
public class CotizacionService {

        @Autowired
	private CotizacionRepository repo;
	
	public List<CalculadoraPrecio> listAll() {
		return repo.findAll();
	}
	
	public void save(CalculadoraPrecio cotizacion) {
		repo.save(cotizacion);
	}
	
	public CalculadoraPrecio get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
