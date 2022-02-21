package br.com.Pokedex.springdata.orm;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TiposDosPokemons")
public class TipoDoPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    @OneToMany(mappedBy = "tipo")
    private List<Pokemon> pokemon;

}
