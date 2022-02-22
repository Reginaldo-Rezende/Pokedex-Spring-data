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

    @Override
    public String toString() {
        return
                 "[" + id +" "+
                tipo +"]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
