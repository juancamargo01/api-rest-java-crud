package br.com.devmedia.revjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = " PHONES")
public class Phone implements Serializable {

    public  enum TypePhone {

        RESIDENCIAL, CELULAR, COMERCIAL
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PHONE")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name= "TYPE_PHONE")
    private TypePhone type;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public Phone(){
        super();
    }
    public Phone(TypePhone type, String number){
        this.type = type;
        this.number = number;
    }


    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public TypePhone getType() {return type;}

    public void setType(TypePhone type) {this.type = type;}

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", person=" + person +
                '}';
    }

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public Person getPerson() {return person;}

    public void setPerson(Person person) {this.person = person;}


}
