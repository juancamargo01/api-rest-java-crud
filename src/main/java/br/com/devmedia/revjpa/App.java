package br.com.devmedia.revjpa;

import br.com.devmedia.revjpa.dao.DocumentDAO;
import br.com.devmedia.revjpa.dao.PersonDAO;

import br.com.devmedia.revjpa.dao.PhoneDAO;
import br.com.devmedia.revjpa.entity.Document;
import br.com.devmedia.revjpa.entity.Person;
import br.com.devmedia.revjpa.entity.Phone;

import java.util.Arrays;
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
        //deletePerson();

        //insertDocument();
        //updateDocument();
        //findPersonByCpf();

        //insertPhone();
        //insertPhoneByPerson();
        updatePhone();

    }

    private static void updatePhone() {
        Person person = new PersonDAO().findById(3L);

        PhoneDAO  dao = new PhoneDAO();

        Phone phone = dao.findById(4L);

        phone.setPerson(person);

        dao.update(phone);

        phone = dao.findById(phone.getId());

        System.out.println(phone.toString());

    }

    private static void insertPhoneByPerson() {

        Phone ph1 = new Phone(Phone.TypePhone.CELULAR,"95633334");
        Phone ph2 = new Phone(Phone.TypePhone.COMERCIAL,"923224584");

        Person person = new Person();

        person.setFristName("Eduardo");
        person.setLastName("yhivi");
        person.setAge(41);
        person.setDocument(new Document("486.786.422-22", 12123));

        //ph1.setPerson(person);
        //ph2.setPerson(person);
        //person.setPhones(Arrays.asList(ph1,ph2));

        person.addPhone(ph1);
        person.addPhone(ph2);
        new PersonDAO().save(person);
    }

    private static void insertPhone() {
        Person person = new Person();
        person.setFristName("Mariza");
        person.setLastName("Souza");
        person.setAge(48);
        person.setDocument(new Document("456.456.456-88", 1546871));

        Phone phone = new Phone(Phone.TypePhone.CELULAR, "921546484");
        phone.setPerson(person);
        PhoneDAO dao = new PhoneDAO();

        dao.save(phone);

        phone = dao.findById(phone.getId());

        System.out.println(phone.toString());
    }

    private static void findPersonByCpf() {
        Person p =new PersonDAO().findByCpf("123.456.789-99");
        System.out.println(p.toString());
    }

    private static void updateDocument() {
        Document doc = new DocumentDAO().findById(1L);
        System.out.println(doc.toString());
        doc.setCpf("321.654.987-11");

        System.out.println(new DocumentDAO().findById(1L).toString());

    }

    private static void insertDocument() {

        Person p1 = new Person();
        p1.setFristName("Aline");
        p1.setLastName("de Souza");
        p1.setAge(24);
        p1.setDocument(new Document("123.456.789-99", 123456789));


        new PersonDAO().save(p1);

        System.out.println(p1.toString());

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
