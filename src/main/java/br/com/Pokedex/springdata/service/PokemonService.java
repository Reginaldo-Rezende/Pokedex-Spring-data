package br.com.Pokedex.springdata.service;


import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    private Boolean abaAberta = true;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public void inicial(Scanner inserido){

        while(abaAberta){

            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");

            int acao = inserido.nextInt();

            if (acao ==1){
                salvar(inserido);
            }if(acao == 2){
                atualizar(inserido);
            }else{
                abaAberta = false;
            }


      }


    }

    public void salvar(Scanner inserido){
        System.out.println("nome do Pokemon");
        String nome = inserido.next();
        Pokemon pokemon = new Pokemon();
        pokemon.setName(nome);
        pokemonRepository.save(pokemon);
        System.out.println("Salvo");

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

}
