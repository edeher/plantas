package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Especie;
import com.unia.model.Individuo;
import com.unia.service.IEspecieService;
import com.unia.service.IIndividuoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class IvisBean implements Serializable {

	@Inject
	private Individuo individuo;
	@Inject
	private Especie especie;
	@Inject
	private IIndividuoService serviceindividuo;
	@Inject
	private IEspecieService serviceespecie;

	private List<Individuo> lstIndividuo;
	private List<Individuo> lstIndividuo1;
	private List<Especie> lstEspecie;

	@PostConstruct
	public void init() {
		lstIndividuo = new ArrayList<>();
		lstEspecie = new ArrayList<>();

		this.listarIndividuo();
		this.listarEspecie();

		this.listanumeroIndividuosEspecie();

	}

	public void listarIndividuo() {

		try {

			lstIndividuo = serviceindividuo.listar();

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listarEspecie() {

		try {

			lstEspecie = serviceespecie.listar();

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listanumeroIndividuosEspecie() {

		try {

			for (Especie espe1 : this.lstEspecie) {

				lstIndividuo1 = serviceindividuo.listarPorEspecie(espe1);

				espe1.setNumeroIndividuos(lstIndividuo1.size());
				serviceespecie.modificar(espe1);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listaareaIndividuosEspecie() {
		
		try {

			for (Especie espe2 : this.lstEspecie) {

				double areas=0;
				lstIndividuo1 = serviceindividuo.listarPorEspecie(espe2);

				for(Individuo indi2:lstIndividuo1) {
					
					areas=areas+indi2.getCircunferencia();
				}
				
				espe2.setAreaIndividuos(areas);
				serviceespecie.modificar(espe2);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void numeroIndiviuosFamilia() {

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

}
