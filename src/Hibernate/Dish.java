package Hibernate;

import javax.persistence.*;

/**
 * Created by Andrew on 26.06.2015.
 */
@Entity
@Table(name = "recept_30")
public class Dish {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long idDish;

    @Column(name = "name")
    private String name;

    @Column(name = "ingridients")
    private String ingridients;

    @Column(name = "steps")
    private String recept;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public long getIdDish() {
        return idDish;
    }

    public void setIdDish(long idDish) {
        this.idDish = idDish;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }


}
