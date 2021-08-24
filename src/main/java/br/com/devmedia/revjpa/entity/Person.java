package br.com.devmedia.revjpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSONS",
    indexes = {@Index(columnList = "FRIST_NAME, LAST_NAME", name = "IDX_PERSON_NAME",unique = true)}
)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Long id;

    @Column(name = "FRIST_NAME", nullable = false, length = 30)
    private String fristName;

    @Column(name = "LAST_NAME", nullable = false, length = 60)
    private String lastName;

    @Column(name = "AGE", nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="DOCUMENTE_ID")
    private Document document;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones ;



    public  void addPhone(Phone phone){
        if (phones == null){
            phones = new ArrayList<Phone>();
        }
        phone.setPerson(this);
        phones.add(phone);
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setDocument(Document document) {
        this.document = document;
    }


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFristName() {return fristName;}

    public void setFristName(String fristName) {this.fristName = fristName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public Integer getAge() {return age;}

    public void setAge(Integer age) {this.age = age;}

    public Document getDocument() { return document;}

    public List<Phone> getPhones() { return phones; }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", document=" + document +
                '}';
    }
}
