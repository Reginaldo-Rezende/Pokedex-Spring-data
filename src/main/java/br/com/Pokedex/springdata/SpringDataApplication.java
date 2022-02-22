package br.com.Pokedex.springdata;

import br.com.Pokedex.springdata.service.BuscaService;
import br.com.Pokedex.springdata.service.PokemonService;
import br.com.Pokedex.springdata.service.TipoDoPokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final PokemonService pokemonService;
	private final TipoDoPokemonService tipoDoPokemonService;
	private final BuscaService buscaService;


	private Boolean pokedexLigada = true;

	public SpringDataApplication(PokemonService pokemonService, TipoDoPokemonService tipoDoPokemonService, BuscaService buscaService) {
		this.pokemonService = pokemonService;
		this.tipoDoPokemonService = tipoDoPokemonService;
		this.buscaService = buscaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(pokedexLigada){

			System.out.println("---Pokédex---");
			System.out.println("0 - Desligar");
			System.out.println("1 - Pokemons");
			System.out.println("2 - Tipos");
			System.out.println("3 - Buscas");
			System.out.println("-------------");

			int acao =scanner.nextInt();

			/*
			if (acao == 1){
				pokemonService.inicial(scanner);
				break;
			}if (acao == 2){
				tipoDoPokemonService.inicialTipos(scanner);
				break;
			}if (acao == 3){
                buscaService.inicialBusca(scanner);
				break;
			}
			if (acao == 0){
				System.out.println("desligando...");
				pokedexLigada =false;
			}else{

				pokedexLigada =true;
			}*/

			switch (acao) {
				case 1:
					pokemonService.inicial(scanner);
					break;
				case 2:
					tipoDoPokemonService.inicialTipos(scanner);
					break;
				case 3:
					buscaService.inicialBusca(scanner);
					break;
				default:
					System.out.println("Desligando...");
					pokedexLigada = false;
					break;


			}

		}

	}
}
