package br.com.Pokedex.springdata.service;


import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.orm.TipoDoPokemon;
import br.com.Pokedex.springdata.repository.TipoDoPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TipoDoPokemonService {

    private final TipoDoPokemonRepository tipoDoPokemonRepository;

    public TipoDoPokemonService(TipoDoPokemonRepository tipoDoPokemonRepository) {
        this.tipoDoPokemonRepository = tipoDoPokemonRepository;
    }

    private Boolean abaAberta = true;

    public void inicialTipos(Scanner inserido){

        while(abaAberta){

            System.out.println("---Tipos---");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - visualizar");
            System.out.println("4 - deletar");
            System.out.println("-----------");

            int acao = inserido.nextInt();

            if (acao ==1){
                salvar(inserido);

            }if(acao == 2){
                atualizar(inserido);

            }if(acao == 3){
                visualizar();

            }if(acao == 4){
                deletar(inserido);

            }
            if(acao == 0){
                abaAberta = false;

            }else{
                abaAberta = true;
            }
        }
    }

    public void salvar(Scanner inserido){
        System.out.println("Tipo do Pokemon");
        String Tipo = inserido.next();
        TipoDoPokemon tipo = new TipoDoPokemon();
        tipo.setTipo(Tipo);
        tipoDoPokemonRepository.save(tipo);
        System.out.println("Salvo");

    }

    public void atualizar(Scanner inserido){
        System.out.println("ID a ser alterdo");
        int id = inserido.nextInt();
        System.out.println("digite o tipo correto");
        String novoNome = inserido.next();
        TipoDoPokemon tipo = new TipoDoPokemon();
        tipo.setId(id);
        tipo.setTipo(novoNome);
        tipoDoPokemonRepository.save(tipo);
        System.out.println("Atualizado");
    }

    public void visualizar(){
        System.out.println(tipoDoPokemonRepository.findAll());

    }

    public void deletar(Scanner inserido){
        System.out.println("Digite o ID");
        int id = inserido.nextInt();
        tipoDoPokemonRepository.deleteById(id);
        System.out.println("tipo deletado");
    }


}
