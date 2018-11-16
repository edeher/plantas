package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IIndividuoDAO;
import com.unia.model.Especie;
import com.unia.model.Individuo;
import com.unia.service.IIndividuoService;

@Named
public class IndividuoServiceImpl implements IIndividuoService,Serializable{

	@EJB
	private IIndividuoDAO dao;
	
	@Override
	public void registrar(Individuo t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Individuo t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Individuo> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Individuo listarPordId(Individuo t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPordId(t);
	}

	@Override
	public List<Individuo> listarPorEspecie(Especie e) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorEspecie(e);
	}

	@Override
	public List<Individuo> listarPorFamilia(Especie e) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorFamilia(e);
	}

	@Override
	public List<Individuo> listarPorNomComun(Individuo i) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorNomComun(i);
	}

	
	
}
