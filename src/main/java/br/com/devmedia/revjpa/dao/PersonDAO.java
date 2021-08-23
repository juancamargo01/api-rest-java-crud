package br.com.devmedia.revjpa.dao;

import br.com.devmedia.revjpa.entity.Person;

import java.util.List;

public class PersonDAO extends GenericDAO<Person>{

    public PersonDAO(){
        super(Person.class);
    }


    public List<Person> findByLastName(String lastName) {
        String jpql = "from Person p where p.lastName like ?1";

        return find(jpql, lastName);
    }


    public List<Person> findAgeIsBetween(int min, int max){
        String jpql = "from Person p where p.age between ?1 and ?2 ";
        return find(jpql, min, max);
    }

    public Person findByFullName(String fristName, String lastName){

        String jpql = "from Person p where p.fristName like ?1 and p.lastName like ?2";

        return findOne(jpql, fristName, lastName);

    }
}
