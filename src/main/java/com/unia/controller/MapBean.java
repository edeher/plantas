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
			
		
		LatLng coord1 = new LatLng(-8.34727713233379,-74.5897709746486);
		LatLng coord2 = new LatLng(-8.34719428465128,-74.5899849037566);
		LatLng coord3 = new LatLng(-8.34617089041925,-74.5905663533101);
		LatLng coord4 = new LatLng(-8.34513113946504,-74.5908083994369);
		LatLng coord5 = new LatLng(-8.34422824229298,-74.5915360862770);
		LatLng coord6 = new LatLng(-8.34303499305241,-74.5914946611828);
		LatLng coord7 = new LatLng(-8.34228164780819,-74.5918044211898);
		LatLng coord8 = new LatLng(-8.34152308849189,-74.5915077692718);
		LatLng coord9 = new LatLng(-8.33965576164965,-74.5890542880994);
		LatLng coord10 = new LatLng(-8.34138057448765,-74.5878233456500);
			
					
		LatLng coord11 = new LatLng(-8.34363395029085,-74.5856549848265);
		LatLng coord12 = new LatLng(-8.34363469287896,-74.5863661040744);
		LatLng coord13 = new LatLng(-8.34462423195344,-74.5867145599966);
		LatLng coord14 = new LatLng(-8.34523390202484,-74.5870800040157);
		LatLng coord15 = new LatLng(-8.34553732393763,-74.5873776868383);
		LatLng coord16 = new LatLng(-8.34598002798472,-74.5867801640981);
		LatLng coord17 = new LatLng(-8.34667224894339,-74.5870719595872);
		LatLng coord18 = new LatLng(-8.34710046527057,-74.5862167037165);
		LatLng coord19 = new LatLng(-8.34728035307120,-74.5861215609884);
		
		
	    LatLng coord20 = new LatLng(-8.34728053530486, -74.5859141683147);
		LatLng coord21 = new LatLng(-8.34727713233379, -74.5897709746486);
			
			
		

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
		
		polyline.getPaths().add(coord11);
		polyline.getPaths().add(coord12);
		polyline.getPaths().add(coord13);
		polyline.getPaths().add(coord14);
		polyline.getPaths().add(coord15);
		polyline.getPaths().add(coord16);
		polyline.getPaths().add(coord17);
		polyline.getPaths().add(coord18);
		polyline.getPaths().add(coord19);
				
		polyline.getPaths().add(coord20);
		polyline.getPaths().add(coord21);

		

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
