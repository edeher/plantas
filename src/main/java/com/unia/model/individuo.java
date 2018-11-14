package com.unia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="especie")
public class individuo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEspecie;
	
	
	@Column(name = "nombreCientifico", length = 50, nullable = false)
	private String nombreCientifico;
	
	@Column(name = "nombreComun", length = 50, nullable = false)
	private String nombreComun;
	
	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;
	
	@Column(name="latitud", columnDefinition="Decimal(10,4)", nullable=false)
	private double latitud;
	
	@Column(name="longitud", columnDefinition="Decimal(10,4)", nullable=false)
	private double longitud;
	
	@ManyToOne
	@JoinColumn(name="idFamilia", nullable=false)
	private Familia familia;

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEspecie;
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
		individuo other = (individuo) obj;
		if (idEspecie != other.idEspecie)
			return false;
		return true;
	}
	
	

}
