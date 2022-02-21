package br.com.Pokedex.springdata;

import br.com.Pokedex.springdata.orm.Pokemon;
import br.com.Pokedex.springdata.repository.PokemonRepository;
import br.com.Pokedex.springdata.service.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final PokemonService pokemonService;

	private Boolean pokedexLigada = true;

	public SpringDataApplication(PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(pokedexLigada){

			System.out.println("---Pokédex---");
			System.out.println("0 - Sair");
			System.out.println("1 - Pokemons");

			int acao =scanner.nextInt();
			if (acao == 1){
				pokemonService.inicial(scanner);
			}else{
				pokedexLigada =false;
			}

		}

	}
}
