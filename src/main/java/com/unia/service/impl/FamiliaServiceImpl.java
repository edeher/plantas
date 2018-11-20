package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IFamiliaDAO;
import com.unia.model.Familia;
import com.unia.service.IFamiliaService;

@Named
public class FamiliaServiceImpl implements IFamiliaService, Serializable{
	
	
	@EJB
	private IFamiliaDAO dao;

	@Override
	public void registrar(Familia t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Familia t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Familia> listar() throws Exception {
		
		return dao.listar();
	}


	@Override
	public Familia listarPorId(Familia t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
