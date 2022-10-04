package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pokemonId;
	@Column
	private String nombre = "null";

	@Autowired
	@ManyToMany(targetEntity = Type.class, cascade = { CascadeType.MERGE })
	@JoinTable(name = "pokemonHasType", joinColumns = { @JoinColumn(name = "pokemon_id") }, inverseJoinColumns = {
			@JoinColumn(name = "type_id") })
	private List<Type> types;

	@Autowired
	@ManyToMany(targetEntity = Type.class, cascade = { CascadeType.MERGE })
	@JoinTable(name = "pokemonHasWeakness", joinColumns = { @JoinColumn(name = "Pokemon_id") }, inverseJoinColumns = {
			@JoinColumn(name = "weakness_id") })
	private List<Type> debilidades = new ArrayList<>();

	@OneToOne
	private Pokemon evolution;
	@Column
	private String image = "";

	public Pokemon() {

	}

	public void setPokemonId(int id) {
		this.pokemonId = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipos(List<Type> tipos) {
		this.types = tipos;
	}

	public void setDebilidades(List<Type> debilidades) {
		this.debilidades = debilidades;
	}

	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Type> getTipos() {
		return types;
	}

	public List<Type> getDebilidades() {
		return debilidades;
	}

	public Pokemon getEvolution() {
		return evolution;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("Pokemon = " + nombre);
		if (types.size() == 1)
			cadena.append(" \ntipo =");
		if (types.size() == 2)
			cadena.append("\ntipos= ");
		cadena.append(types.toString());
		cadena.append("\ndebilidades= " + debilidades.toString());
		if (evolution == null)
			cadena.append("\nNo evoluciona");
		if (evolution != null)
			cadena.append("\nevolution=" + evolution.getNombre());

		cadena.append("\nimage=" + image + "\n");

		return cadena.toString();

	}

	public void addToTypes(Type type) {
		this.types.add(type);

	}

	public void addToWeakness(Type type) {
		this.debilidades.add(type);

	}

	public void setTipos(Type findByTypeName) {
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(findByTypeName);
		this.types = types;

	}

}
