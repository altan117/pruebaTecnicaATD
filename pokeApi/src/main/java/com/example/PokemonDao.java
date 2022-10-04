package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PokemonDao {

	List<Type> getTipos();

	ArrayList<Pokemon> getPokes();

	ArrayList<Pokemon> getPokes(String name);

	ArrayList<Type> getTipos(String typeName);

	ArrayList<Pokemon> getPokes(int parseInt);

	List<Type> getTipos(int parseInt);

}
