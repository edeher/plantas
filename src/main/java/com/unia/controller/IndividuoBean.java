package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Especie;
import com.unia.model.Familia;
import com.unia.model.Individuo;
import com.unia.service.IEspecieService;
import com.unia.service.IFamiliaService;
import com.unia.service.IIndividuoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class IndividuoBean implements Serializable {

	@Inject
	private Individuo individuo;
	@Inject
	private Especie especie;
	@Inject
	private Familia familia;
	@Inject
	private IIndividuoService serviceindividuo;
	@Inject
	private IEspecieService serviceespecie;
	@Inject
	private IFamiliaService servicefamilia;

	private List<Individuo> lstIndividuo;
	private List<Individuo> lstIndividuoEspecie;
	private List<Individuo> lstIndividuoFamilia;
	private List<Especie> lstEspecie;
	private List<Familia> lstFamilia;

	@PostConstruct
	public void init() {
		lstIndividuo = new ArrayList<>();
		lstEspecie = new ArrayList<>();
		lstFamilia = new ArrayList<>();
	
		this.listarIndividuo();
		this.listarEspecie();
		this.listarFamilia();

	}
//listoprobando cambiabdo todo
	public void listarIndividuo() {
		
		try {
			
			lstIndividuo = serviceindividuo.listar();
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}
	

	public void listarIndividuoEspecie() {
		
		try {
			
			lstIndividuo = serviceindividuo.listarPorEspecie(especie);
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarIndividuoFamilia() {
	
		try {
			
			lstIndividuo = serviceindividuo.listarPorFamilia(familia.getIdFamilia());
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarEspecie() {
		
		try {

			lstEspecie=serviceespecie.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarFamilia() {
		try {

			lstFamilia=servicefamilia.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public Individuo getIndividuo() {
		return individuo;
	}

	public void setIndividuo(Individuo individuo) {
		this.individuo = individuo;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public List<Individuo> getLstIndividuo() {
		return lstIndividuo;
	}

	public void setLstIndividuo(List<Individuo> lstIndividuo) {
		this.lstIndividuo = lstIndividuo;
	}

	public List<Especie> getLstEspecie() {
		return lstEspecie;
	}

	public void setLstEspecie(List<Especie> lstEspecie) {
		this.lstEspecie = lstEspecie;
	}

	public List<Familia> getLstFamilia() {
		return lstFamilia;
	}

	public void setLstFamilia(List<Familia> lstFamilia) {
		this.lstFamilia = lstFamilia;
	}

	public List<Individuo> getLstIndividuoEspecie() {
		return lstIndividuoEspecie;
	}

	public void setLstIndividuoEspecie(List<Individuo> lstIndividuoEspecie) {
		this.lstIndividuoEspecie = lstIndividuoEspecie;
	}

	public List<Individuo> getLstIndividuoFamilia() {
		return lstIndividuoFamilia;
	}

	public void setLstIndividuoFamilia(List<Individuo> lstIndividuoFamilia) {
		this.lstIndividuoFamilia = lstIndividuoFamilia;
	}

}
