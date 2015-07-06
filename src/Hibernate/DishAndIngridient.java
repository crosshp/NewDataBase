package Hibernate;

import javax.persistence.*;

/**
 * Created by Andrew on 26.06.2015.
 */
@Entity
//@Embeddable
@Table(name = "dishingridient")
public class DishAndIngridient {
      @Id
    @Column(name = "idDish")
    private long idDish;
    //   @Id
    @Column(name = "idIngridient")
    private long idIngridient;

    public DishAndIngridient(long idDish, long idIngridient) {
        this.idDish = idDish;
        this.idIngridient = idIngridient;
    }

    public long getIdIngridient() {
        return idIngridient;
    }

    public void setIdIngridient(long idIngridient) {
        this.idIngridient = idIngridient;
    }

    public long getIdDish() {
        return idDish;
    }

    public void setIdDish(long idDish) {
        this.idDish = idDish;
    }
}
