package br.com.devmedia.revjpa;

import br.com.devmedia.revjpa.entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        System.out.println( "Hello World!" );
        insertPerson();
    }

    private static  void insertPerson(){
        Person p1 = new Person();
        p1.setFristName("Ana Maria");
        p1.setLastName("da Silva");
        p1.setAge(29);

        new PersonDAO().save(p1);
        System.out.println(p1.toString());


        Person p2 = new Person();
        p2.setFristName("Juan Victor");
        p2.setLastName("Oliveira Camargo");
        p2.setAge(33);

        new PersonDAO().save(p2);
        System.out.println(p2.toString());


        Person p3 = new Person();
        p3.setFristName("Valeria sousa");
        p3.setLastName("Camargo");
        p3.setAge(24);

        new PersonDAO().save(p3);
        System.out.println(p3.toString());

    }
}
