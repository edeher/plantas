package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IEspecieDAO;
import com.unia.model.Especie;
import com.unia.model.Familia;

@Stateless
public class EspecieDAOImpl implements IEspecieDAO, Serializable{
	
	@PersistenceContext(unitName = "Plantas")
	private EntityManager em;

	@Override
	public void registrar(Especie t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Especie t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Especie> listar() throws Exception {
		List<Especie> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Especie e");
		lista = (List<Especie>) q.getResultList();

		return lista;
	}

	@Override
	public Especie listarPordId(Especie t) throws Exception {
		 List<Especie> lista=new ArrayList<>();
			
			Query q=em.createQuery("FROM Especie e where e.idEspecie=?1");
			q.setParameter(1, t.getIdEspecie() );
			lista=(List<Especie>)q.getResultList();
			
			Especie especie=lista!=null&&!lista.isEmpty() ? lista.get(0):new Especie();
			
			return especie;
	}

	@Override
	public List<Especie> listarPorFamilia(Familia f) throws Exception {
		 List<Especie> lista=null;
			
			Query q= em.createQuery("FROM Especie e where e.familia.idFamilia=?1");
			q.setParameter(1, f.getIdFamilia());
			
			lista=(List<Especie>)q.getResultList();
			
					
			return lista;
	}

	@Override
	public List<Especie> listarPorNombreCientifico(Especie e) throws Exception {
       List<Especie> lista=null;
		
		Query q= em.createQuery("FROM  Especie e where e.nombreCientifico=?1");
		q.setParameter(1, e.getNombreCientifico());
		
		lista=(List<Especie>)q.getResultList();
		
				
		return lista;
	}

	

}
