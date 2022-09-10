package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
class DemoApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void contextLoads() {
		personRepository.save(new Person(null, "FooBar"));

		assertEquals(1, personRepository.findAll().spliterator().estimateSize());
	}

}
