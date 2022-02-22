package br.com.Pokedex.springdata.service;


import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.orm.TipoDoPokemon;
import br.com.Pokedex.springdata.repository.PokemonRepository;
import br.com.Pokedex.springdata.repository.TipoDoPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final TipoDoPokemonRepository tipoDoPokemonRepository;


    private Boolean abaAberta = true;

    public PokemonService(PokemonRepository pokemonRepository, TipoDoPokemonRepository tipoDoPokemonRepository, TipoDoPokemonRepository tipoDoPokemonRepository1) {
        this.pokemonRepository = pokemonRepository;

        this.tipoDoPokemonRepository = tipoDoPokemonRepository1;
    }

    public void inicial(Scanner inserido){

        while(abaAberta){
            System.out.println("---Pokédex---");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - visualizar");
            System.out.println("4 - deletar");
            System.out.println("-------------");

            int acao = inserido.nextInt();


            switch (acao) {
                case 1:
                    salvar(inserido);
                    break;
                case 2:
                    atualizar(inserido);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(inserido);
                    break;
                case 0:
                    abaAberta = false;
                    break;
                default:
                    abaAberta = true;
                    break;
            }


      }


    }

    public void salvar(Scanner inserido){
        System.out.println("nome do Pokemon");
        String nome = inserido.next();
        Pokemon pokemon = new Pokemon();
        pokemon.setName(nome);

        System.out.println("Tipos Possiveis: ->"+ tipoDoPokemonRepository.findAll());
        System.out.println("Caso não tenha encontrado o tipo procurado digite 1 para retornar e cadastrar um tipo, caso contrario digite o tipo de sua preferencia");

        Integer Tipoinserido = inserido.nextInt();


        switch (Tipoinserido) {
            case 1:
                abaAberta = false;
                break;
            default:
                Optional<TipoDoPokemon> tipo = tipoDoPokemonRepository.findById(Tipoinserido);

                pokemon.setTipo(tipo.get());


                pokemonRepository.save(pokemon);

                System.out.println("Salvo");
                break;
        }

    }

    public void atualizar(Scanner inserido){
        System.out.println("ID a ser alterdo");
        int id = inserido.nextInt();
        System.out.println("digite o nome correto");
        String novoNome = inserido.next();
        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setName(novoNome);
        pokemonRepository.save(pokemon);
        System.out.println("Atualizado");
    }

    public void visualizar(){
        System.out.println(pokemonRepository.findAll());

    }

    public void deletar(Scanner inserido){
        System.out.println("Pokemons: ");
        System.out.println(pokemonRepository.findAll());
        System.out.println("---DELETAR---");
        System.out.println("Digite o ID");
        int id = inserido.nextInt();
        pokemonRepository.deleteById(id);
        System.out.println("deletado");
    }

}
