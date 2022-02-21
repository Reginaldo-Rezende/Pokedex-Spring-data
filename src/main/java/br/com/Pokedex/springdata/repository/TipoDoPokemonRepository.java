package br.com.Pokedex.springdata.repository;


import br.com.Pokedex.springdata.orm.TipoDoPokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDoPokemonRepository  extends CrudRepository<TipoDoPokemon,Integer> {

    
}
