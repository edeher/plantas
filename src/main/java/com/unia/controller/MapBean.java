package com.unia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polyline;

@Named
@ViewScoped
public class MapBean implements Serializable {

	private MapModel polylineModel;

	@PostConstruct
	public void init() {

		polylineModel = new DefaultMapModel();

		// Shared coordinates
		// LatLng coord1 = new LatLng(36.879466, 30.667648);
		// LatLng coord2 = new LatLng(36.883707, 30.689216);
		// LatLng coord3 = new LatLng(36.879703, 30.706707);
		// LatLng coord4 = new LatLng(36.885233, 30.702323);

		LatLng coord1 = new LatLng(9077286.3234, 545168.1963);
		LatLng coord2 = new LatLng(9077295.5072, 545144.6508);
		LatLng coord3 = new LatLng(9077408.7162, 545080.7467);
		LatLng coord4 = new LatLng(9077523.6947, 545054.2149);
		LatLng coord5 = new LatLng(9077623.5985, 544974.1946);
		LatLng coord6 = new LatLng(9077755.5148, 544978.8923);
		LatLng coord7 = new LatLng(9077838.8370, 544944.8714);
		LatLng coord8 = new LatLng(9077922.6666, 544977.6219);
		LatLng coord9 = new LatLng(9078128.8308, 545247.9852);
		LatLng coord10 = new LatLng(9077938.0009, 545383.3238);

		// Polyline
		Polyline polyline = new Polyline();
		polyline.getPaths().add(coord1);
		polyline.getPaths().add(coord2);
		polyline.getPaths().add(coord3);
		polyline.getPaths().add(coord4);
		polyline.getPaths().add(coord5);
		polyline.getPaths().add(coord6);
		polyline.getPaths().add(coord7);
		polyline.getPaths().add(coord8);
		polyline.getPaths().add(coord9);
		polyline.getPaths().add(coord10);
		
		
		

		polyline.setStrokeWeight(10);
		polyline.setStrokeColor("#FF9900");
		polyline.setStrokeOpacity(0.7);

		polylineModel.addOverlay(polyline);

	}

	public void onPolylineSelect(OverlaySelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Polyline Selected", null));
	}

	public MapModel getPolylineModel() {
		return polylineModel;
	}

	public void setPolylineModel(MapModel polylineModel) {
		this.polylineModel = polylineModel;
	}

}
