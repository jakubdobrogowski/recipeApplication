package guru.springframework.spring5recipeapp.model;

import javax.persistence.*;

@Entity
public class UniteOfMesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

//    @OneToOne
//    private Ingredient ingredient; tego nie robimy

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}