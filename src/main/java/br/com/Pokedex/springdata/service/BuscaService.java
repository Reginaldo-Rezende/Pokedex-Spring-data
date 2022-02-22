package br.com.Pokedex.springdata.service;

import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.orm.TipoDoPokemon;
import br.com.Pokedex.springdata.repository.PokemonRepository;
import br.com.Pokedex.springdata.repository.TipoDoPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BuscaService {

    private final PokemonRepository pokemonRepository;
    private final TipoDoPokemonRepository tipoDoPokemonRepository;


    public BuscaService(PokemonRepository pokemonRepository, TipoDoPokemonRepository tipoDoPokemonRepository) {
        this.pokemonRepository = pokemonRepository;
        this.tipoDoPokemonRepository = tipoDoPokemonRepository;
    }

    private Boolean abaAberta = true;

    public void inicialBusca(Scanner inserido){

        while(abaAberta){

            System.out.println("---Buscas---");
            System.out.println("0 - Sair");
            System.out.println("1 - buscar por tipo");
            System.out.println("------------");

            int acao = inserido.nextInt();

            if (acao ==1){
                buscarPorTipo(inserido);
            }
            else{
                abaAberta = false;
            }
        }
    }



    private void buscarPorTipo(Scanner inserido) {

        System.out.println("Qual tipo deseja filtrar?");
        System.out.println("tipos existentes: ");
        System.out.println(tipoDoPokemonRepository.findAll());

       Integer tipo = inserido.nextInt();
        Optional<TipoDoPokemon> tipoPokemons = tipoDoPokemonRepository.findById(tipo);

        List<Pokemon> lista = pokemonRepository.findByTipo(tipoPokemons.get());
        lista.forEach(System.out::println);
    }


}
