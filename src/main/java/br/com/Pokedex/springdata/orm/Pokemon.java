package br.com.Pokedex.springdata.orm;

import javax.persistence.*;


@Entity
@Table(name="Pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "tipoDoPokemon_tipo")
    private TipoDoPokemon tipo;

    @Override
    public String toString() {
        return
                "["+ id +" "+
                  name + " " +
                 tipo.getTipo()+"]";

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoDoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoPokemon tipo) {
        this.tipo = tipo;
    }
}
