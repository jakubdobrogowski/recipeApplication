package guru.springframework.spring5recipeapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UniteOfMesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

//    @OneToOne
//    private Ingredient ingredient; tego nie robimy

}