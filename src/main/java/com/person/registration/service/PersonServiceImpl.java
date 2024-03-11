package com.person.registration.service;

import com.person.registration.entity.Person;
import com.person.registration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository _repository;

    @Override
    public Person save(Person person) {
        return _repository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return _repository.findAll();
    }
}
