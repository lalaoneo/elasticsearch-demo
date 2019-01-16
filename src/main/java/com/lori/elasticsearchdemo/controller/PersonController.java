package com.lori.elasticsearchdemo.controller;

import com.lori.elasticsearchdemo.domain.Person;
import com.lori.elasticsearchdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public String save(){
        List<Person> personList = createPersonList();
        personRepository.saveAll(personList);
        return "save success";
    }

    private List<Person> createPersonList() {
        List<Person> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<100; i++){
            Person person = new Person();
            person.setName("lori"+random.nextInt(50000));
            person.setAge(random.nextInt(50)+10);
            person.setHeight(new BigDecimal(random.nextInt(20)+170));
            person.setSex(random.nextInt(1));
            person.setWeight(new BigDecimal(random.nextInt(90)+90));
            list.add(person);
        }
        return list;
    }

    @RequestMapping("/get/all")
    public List<Person> getAll(){
        List<Person> personList = new ArrayList<>();
        Iterable<Person> iterable = personRepository.findAll();
        iterable.forEach((person)-> personList.add(person));
        return personList;
    }

    @RequestMapping("/delete")
    public String delete(){
        Iterable<Person> iterable = personRepository.findAll();
        iterable.forEach((person)-> personRepository.deleteById(person.getId()));
        return "delete success";
    }
}
