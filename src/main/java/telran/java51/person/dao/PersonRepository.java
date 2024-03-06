package telran.java51.person.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import telran.java51.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	List<Person> findByName(String name);
}
