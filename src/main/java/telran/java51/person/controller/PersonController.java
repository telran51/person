package telran.java51.person.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java51.person.dto.AddressDto;
import telran.java51.person.dto.CityPopulationDto;
import telran.java51.person.dto.PersonDto;
import telran.java51.person.service.PersonService;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
	final PersonService personService;

	@PostMapping
	public Boolean addPesron(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}

	@GetMapping("/{id}")
	public PersonDto findPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}

	@DeleteMapping("/{id}")
	public PersonDto removePerson(@PathVariable Integer id) {
		return personService.removePerson(id);
	}

	@PutMapping("/{id}/name/{name}")
	public PersonDto updatePersonName(@PathVariable Integer id, @PathVariable String name) {
		return personService.updatePersonName(id, name);
	}

	@PutMapping("/{id}/address")
	public PersonDto updatePersonAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
		return personService.updatePersonAddress(id, addressDto);
	}

	@GetMapping("/name/{name}")
	public Iterable<PersonDto> findByName(@PathVariable String name) {
		return personService.findPersonsByName(name);
	}

	@GetMapping("/city/{city}")
	public Iterable<PersonDto> findByCity(@PathVariable String city) {
		return personService.findPersonsByCity(city);
	}

	@GetMapping("/ages/{min}/{max}")
	public Iterable<PersonDto> findPersonsBetweenAge(@PathVariable Integer min, @PathVariable Integer max) {
		return personService.findPersonsBetweenAge(min, max);
	}

	@GetMapping("/population/city")
	public Iterable<CityPopulationDto> getCitiesPopulation() {
		return personService.getCitiesPopulation();
	}
	
	@GetMapping("/salary/{min}/{max}")
	public Iterable<PersonDto> findEmployeeBySalary(@PathVariable Integer min, @PathVariable Integer max) {
		return personService.findEmployeeBySalary(min, max);
	}
	
	@GetMapping("/children")
	public Iterable<PersonDto> findAllChildren() {
		return personService.getChildren();
	}
}
