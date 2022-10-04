package com.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String typeName;

	@ManyToMany(mappedBy = "types", cascade = CascadeType.MERGE)
	private List<Pokemon> pokemons_types;

	public Type(int id, String type) {
		super();
		this.id = id;
		this.typeName = type;

	}

	public Type() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return typeName;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.typeName = type;
	}

	@Override
	public String toString() {
		return typeName;

	}

}
