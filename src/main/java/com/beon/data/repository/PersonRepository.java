package com.beon.data.repository;


import com.beon.data.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by leo on 14-4-6.
 */

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();

    List<Person> findByName(String name);

    List<Person> findByAge(int age);
}
