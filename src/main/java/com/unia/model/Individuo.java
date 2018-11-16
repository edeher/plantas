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
@Table(name="individuo")
public class Individuo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIndividuo;
	
	@Column(name = "nombreComun", length = 100, nullable = false)
	private String nombreComun;
	
	@Column(name="altura", columnDefinition="Decimal(10,2)", nullable=false)
	private double altura;
	
	@Column(name="dap", columnDefinition="Decimal(10,2)", nullable=false)
	private double dap;
	
	@Column(name = "ubicacion", length = 15, nullable = false)
	private String ubicacion;
	
	@Column(name = "plaqueado", length = 10, nullable = false)
	private String plaqueado;
	
	
	@Column(name="latitud", columnDefinition="Decimal(15,14)", nullable=false)
	private double latitud;
	
	@Column(name="longitud", columnDefinition="Decimal(20,14)", nullable=false)
	private double longitud;
	
	@Column(name="cz", columnDefinition="Decimal(10,2)", nullable=false)
	private double cz;
	
	
	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="idEspecie", nullable=false)
	private Especie especie;
	
	

	public int getIdIndividuo() {
		return idIndividuo;
	}

	public void setIdIndividuo(int idIndividuo) {
		this.idIndividuo = idIndividuo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getDap() {
		return dap;
	}

	public void setDap(double dap) {
		this.dap = dap;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getPlaqueado() {
		return plaqueado;
	}

	public void setPlaqueado(String plaqueado) {
		this.plaqueado = plaqueado;
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

	public double getCz() {
		return cz;
	}

	public void setCz(double cz) {
		this.cz = cz;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idIndividuo;
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
		Individuo other = (Individuo) obj;
		if (idIndividuo != other.idIndividuo)
			return false;
		return true;
	}

	
}
