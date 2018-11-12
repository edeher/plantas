package com.unia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="familia")
public class Familia {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFamilia;
	
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	
	@OneToMany(mappedBy = "familia", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Especie> especie;


	public int getIdFamilia() {
		return idFamilia;
	}


	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Especie> getEspecie() {
		return especie;
	}


	public void setEspecie(List<Especie> especie) {
		this.especie = especie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFamilia;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Familia other = (Familia) obj;
		if (idFamilia != other.idFamilia)
			return false;
		return true;
	}

	
	
}
