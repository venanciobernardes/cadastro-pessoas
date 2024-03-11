package com.person.registration.service;

import com.person.registration.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);
    List<Person> getAll();
}
