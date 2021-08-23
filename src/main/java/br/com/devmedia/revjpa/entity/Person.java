package br.com.devmedia.revjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

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

    public Document getDocument() {
        return document;
    }

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

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="DOCUMENTE_ID")
    private Document document;

    //TODO ver se tem necesidade de gera os rest code equals

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFristName() {return fristName;}

    public void setFristName(String fristName) {this.fristName = fristName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public Integer getAge() {return age;}

    public void setAge(Integer age) {this.age = age;}
}
