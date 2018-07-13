package guru.springframework.spring5recipeapp.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private UniteOfMesure uom;

    private String description; //ingridient Name
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {

    }

    public Ingredient(String description, BigDecimal amount, UniteOfMesure uom) {
        this.uom = uom;
        this.description = description;
        this.amount = amount;

    }

}
