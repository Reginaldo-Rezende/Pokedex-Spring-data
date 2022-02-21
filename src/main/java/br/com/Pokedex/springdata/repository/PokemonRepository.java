package br.com.Pokedex.springdata.repository;

import br.com.Pokedex.springdata.orm.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {


}
