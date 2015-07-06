package Hibernate;

import javax.persistence.*;

/**
 * Created by Andrew on 26.06.2015.
 */
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long idDish;

    @Column(name = "name")
    private String name = "";


    @Column(name = "href")
    private String href = "";
    public Dish(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdDish() {
        return idDish;
    }

    public void setIdDish(long idDish) {
        this.idDish = idDish;
    }


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
