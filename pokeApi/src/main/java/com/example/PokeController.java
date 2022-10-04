package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PokeController {
	ArrayList<Pokemon> pokes = new ArrayList<>();

	@Autowired
	PokemonDao pokemonDao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/pokemon")
	@ResponseBody

	public ResponseEntity<ArrayList<Pokemon>> pokemon(@RequestParam(value = "name", required = false) String name) {

		if (name == null) {

			return ResponseEntity.ok(pokemonDao.getPokes());

		}
		boolean b = Pattern.matches(".*\\d.*", name);
		if (b) {
			String sb = "no puede haber numeros en el nombre";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);

		}
		if (pokemonDao.getPokes(name) == null) {
			String sb = "no existe dicho pokemon<br><br>" + "*recomendación*<br>" + "-revise la escritura<br>";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(pokemonDao.getPokes(name));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/pokemon/id")
	@ResponseBody

	public ResponseEntity<ArrayList<Pokemon>> pokemonID(
			@RequestParam(value = "id", required = false) String pokemonId) {
		if (pokemonId == null) {
			String sb = "debe digitar un ID para buscar el pokemon<br>escriba en la URL lo siguiente:<br>?id=X<br><br>donde x es la ID del pokemon que quiere buscar<br>0 para todos los pokes";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);

		}

		if (Integer.parseInt(pokemonId) < 0 || Integer.parseInt(pokemonId) > 151) {
			String sb = "no existe dicho tipo <br>use un id entre 1 y 151 (inclusivo)<br> 0 para todos los pokemones";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(pokemonDao.getPokes((Integer.parseInt(pokemonId))));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/pokemon/type")
	public ResponseEntity<List<Type>> type(@RequestParam(value = "name", required = false) String typeName) {

		if (typeName == null) {

			return ResponseEntity.ok(pokemonDao.getTipos());

		}
		if (pokemonDao.getTipos(typeName) == null) {
			String sb = "no existe dicho tipo<br>" + "*recomendación*<br>" + "-revise la escritura<br>";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);
		} else
			return ResponseEntity.ok(pokemonDao.getTipos(typeName));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/pokemon/type/id")
	@ResponseBody
	public ResponseEntity<List<Type>> typeID(@RequestParam(value = "id", required = false) String typeID) {

		if (typeID == null) {
			String sb = "debe digitar un ID para buscar el tipo<br>escriba en la URL lo siguiente:<br>?id=X<br><br>donde x es la ID del tipo que quiere buscar<br>0 para todos los tipos";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);

		}

		if (Integer.parseInt(typeID) < 0 || Integer.parseInt(typeID) > 18) {
			String sb = "no existe dicho tipo <br>use un id entre 1 y 18 (inclusivo)<br> 0 para todos los tipos";
			return new ResponseEntity(sb, HttpStatus.BAD_REQUEST);

		}
		return ResponseEntity.ok(pokemonDao.getTipos(Integer.parseInt(typeID)));
	}

}