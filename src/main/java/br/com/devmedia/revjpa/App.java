package br.com.devmedia.revjpa;

import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.entity.Person;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        System.out.println( "Hello World!" );
        //insertPerson();
        //findPersonById();
         //findByAll();
        //cauntPersosn();
        //findByLastName();
        //findByAge();
        //findByFullName();
        //updatePerson();
        deletePerson();

    }

    private static void deletePerson() {
        new PersonDAO().delete(2L);

    }

    private static void updatePerson() {
        Person p1 = new PersonDAO().findById(2L);

        System.out.println(p1.toString());
        p1.setLastName("Camargo");
        new PersonDAO().update(p1);

        Person p2 = new PersonDAO().findById(2L);

        System.out.println(p2.toString());
    }

    private static void findByFullName() {
        Person person = new PersonDAO().findByFullName("Robson","Oliveira");
        System.out.println(person.toString());
    }

    private static void findByAge() {
        List<Person> persons = new PersonDAO().findAgeIsBetween(27,39);

        for (Person person : persons){
            System.out.println(person.toString());
        }
    }

    private static void findByLastName() {
        List<Person> persons = new PersonDAO().findByLastName("Camargo");

        for (Person person : persons){
            System.out.println(person.toString());
        }
    }

    private static void cauntPersosn(){

        long total = new PersonDAO().count();

        System.out.println("Total person: " + total);

    }
    private static  void findByAll(){
        List<Person> persons = new PersonDAO().findAll();
        for (Person p : persons){
            System.out.println(p.toString());
        }
    }

    private static void findPersonById(){
        Person p1 = new PersonDAO().findById(2l);

        Person p2 = new PersonDAO().findById(4l);


        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }

    private static  void insertPerson(){
        Person p1 = new Person();
        p1.setFristName("alessanda");
        p1.setLastName("godoi");
        p1.setAge(29);

        new PersonDAO().save(p1);
        System.out.println(p1.toString());


        Person p2 = new Person();
        p2.setFristName("Robson");
        p2.setLastName("Oliveira");
        p2.setAge(38);

        new PersonDAO().save(p2);
        System.out.println(p2.toString());


        Person p3 = new Person();
        p3.setFristName("Valeria sousa");
        p3.setLastName("Camargo");
        p3.setAge(51);

        new PersonDAO().save(p3);
        System.out.println(p3.toString());

    }
}
