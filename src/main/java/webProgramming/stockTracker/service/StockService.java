package webProgramming.stockTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webProgramming.stockTracker.dao.App5Repository;
import webProgramming.stockTracker.model.Person;

@Service
public class StockService {

	@Autowired
	private App5Repository repository;

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findById(long id) {
		return repository.findById(id);
	}

	public void create(Person person) {
		repository.create(person);
	}

	public void delete(long id) {
		repository.delete(id);
	}

}
