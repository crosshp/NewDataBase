package Hibernate;

import javax.persistence.*;

/**
 * Created by Andrew on 26.06.2015.
 */
@Entity
@Table(name = "ingridient_test")
public class Ingridient {
public Ingridient(String name){
    this.name = name;
}
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
