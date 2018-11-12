package com.unia.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IFamiliaDAO;
import com.unia.model.Familia;

@Stateless
public class FamiliaDAOImpl implements IFamiliaDAO{
	
	@PersistenceContext(unitName="Plantas")
	private EntityManager em;

	@Override
	public void registrar(Familia t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Familia t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Familia> listar() throws Exception {
		List<Familia> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Familia f");
		lista=(List<Familia>)q.getResultList();
		
		return lista;
	}

	@Override
	public Familia listarPordId(Familia t) throws Exception {
		List<Familia> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Familia f where f.idFamilia=?1");
		q.setParameter(1, t.getIdFamilia() );
		lista=(List<Familia>)q.getResultList();
		
		Familia familia=lista!=null&&!lista.isEmpty() ? lista.get(0):new Familia();
		
		return familia;
	}

}
