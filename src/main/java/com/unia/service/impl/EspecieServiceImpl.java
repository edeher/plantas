package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import com.unia.dao.IEspecieDAO;
import com.unia.model.Especie;
import com.unia.model.Familia;
import com.unia.service.IEspecieService;

public class EspecieServiceImpl implements IEspecieService, Serializable{

	
	@EJB
	private IEspecieDAO dao;
	
	@Override
	public void registrar(Especie t) throws Exception {
		
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Especie t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Especie> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public Especie listarPordId(Especie t) throws Exception {
	
		return dao.listarPordId(t);
	}

	@Override
	public List<Especie> listarPorFamilia(Familia f) throws Exception {
		
		return dao.listarPorFamilia(f);
	}

	@Override
	public List<Especie> listarPorNombreCientifico(Especie e) throws Exception {
		
		return dao.listarPorNombreCientifico(e);
	}

	@Override
	public List<Especie> listarPorNombreComun(Especie e) throws Exception {
		
		return dao.listarPorNombreComun(e);
	}

}
