package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	List<Pokemon> findByPokemonId(int pokemonId);

	Object findByNombre(String nombre);

}
