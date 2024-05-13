package webProgramming.stockTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webProgramming.stockTracker.dao.StockRepository;
import webProgramming.stockTracker.model.Product;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(long id) {
		return repository.findById(id);
	}

	public void create(Product person) {
		repository.create(person);
	}

	public void delete(long id) {
		repository.delete(id);
	}

}
