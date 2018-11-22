package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.unia.model.Especie;
import com.unia.model.Familia;
import com.unia.model.Individuo;
import com.unia.service.IEspecieService;
import com.unia.service.IFamiliaService;
import com.unia.service.IIndividuoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class IndividuosGmapBean implements Serializable {

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

	private MapModel advancedModel;

	private Marker marker;

	@PostConstruct
	public void init() {
		lstIndividuo=new ArrayList<>();
		lstEspecie = new ArrayList<>();
		lstFamilia = new ArrayList<>();
		
		this.listarIndividuo();
		this.listarEspecie();
		this.listarFamilia();

	}

	public void listarIndividuo() {
		try {
			advancedModel = new DefaultMapModel();
			
			ArrayList<LatLng> coords = new ArrayList<LatLng>();
			ArrayList<String> especies = new ArrayList<String>();
			ArrayList<String> familias = new ArrayList<String>();
			lstIndividuo = serviceindividuo.listar();
			
			for (Individuo indi : lstIndividuo) {

				coords.add(new LatLng(indi.getLatitud(), indi.getLongitud()));

			}
			for (Individuo indi2 : lstIndividuo) {

				especies.add(indi2.getEspecie().getNombreCientifico());

			}
			for (Individuo indi3 : lstIndividuo) {

				familias.add(indi3.getEspecie().getFamilia().getNombre());

			}

			for (int i = 0; i < coords.size(); i++) {

				advancedModel.addOverlay(new Marker(coords.get(i),"Especie : "+especies.get(i)+", Familia : "+familias.get(i),"check.jpg"));

			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listarIndividuoEspecie() {
		
		try {
			advancedModel = new DefaultMapModel();
			
			ArrayList<LatLng> coords = new ArrayList<LatLng>();
			ArrayList<String> especies = new ArrayList<String>();
			ArrayList<String> familias = new ArrayList<String>();
			lstIndividuo = serviceindividuo.listarPorEspecie(especie);
			
			for (Individuo indi : lstIndividuo) {

				coords.add(new LatLng(indi.getLatitud(), indi.getLongitud()));

			}
			for (Individuo indi2 : lstIndividuo) {

				especies.add(indi2.getEspecie().getNombreCientifico());

			}
			for (Individuo indi3 : lstIndividuo) {

				familias.add(indi3.getEspecie().getFamilia().getNombre());

			}

			for (int i = 0; i < coords.size(); i++) {

				advancedModel.addOverlay(new Marker(coords.get(i),"Especie : "+especies.get(i)+", Familia : "+familias.get(i),"check.jpg"));

			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void listarIndividuoFamilia() {
		try {
			advancedModel = new DefaultMapModel();
			
			ArrayList<LatLng> coords = new ArrayList<LatLng>();
			ArrayList<String> especies = new ArrayList<String>();
			ArrayList<String> familias = new ArrayList<String>();
			lstIndividuo = serviceindividuo.listarPorFamilia(familia.getIdFamilia());
			for (Individuo indi : lstIndividuo) {

				coords.add(new LatLng(indi.getLatitud(), indi.getLongitud()));

			}
			for (Individuo indi2 : lstIndividuo) {

				especies.add(indi2.getEspecie().getNombreCientifico());

			}
			for (Individuo indi3 : lstIndividuo) {

				familias.add(indi3.getEspecie().getFamilia().getNombre());

			}

			for (int i = 0; i < coords.size(); i++) {

				advancedModel.addOverlay(new Marker(coords.get(i),"Especie : "+especies.get(i)+", Familia : "+familias.get(i),"check.jpg"));

			}

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

	public void listarFamilia() {

		try {

			lstFamilia = servicefamilia.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
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

	public MapModel getAdvancedModel() {
		return advancedModel;
	}

	public void setAdvancedModel(MapModel advancedModel) {
		this.advancedModel = advancedModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

}
