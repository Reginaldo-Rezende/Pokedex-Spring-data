package br.com.Pokedex.springdata.repository;

import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.orm.TipoDoPokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {

     List<Pokemon> findByTipo(TipoDoPokemon tipo);

}
