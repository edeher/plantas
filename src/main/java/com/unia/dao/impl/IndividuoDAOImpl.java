package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IIndividuoDAO;
import com.unia.model.Especie;
import com.unia.model.Familia;
import com.unia.model.Individuo;

@Stateless

public class IndividuoDAOImpl implements IIndividuoDAO, Serializable{
	
	
	@PersistenceContext(unitName = "Plantas")
	private EntityManager em;

	@Override
	public void registrar(Individuo t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Individuo t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Individuo> listar() throws Exception {
		List<Individuo> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Individuo i");
		lista = (List<Individuo>) q.getResultList();

		return lista;
	}

	@Override
	public Individuo listarPordId(Individuo t) throws Exception {
		 List<Individuo> lista=new ArrayList<>();
			
			Query q=em.createQuery("FROM Individuo  i where i.idIndividuo=?1");
			q.setParameter(1, t.getIdIndividuo() );
			lista=(List<Individuo >)q.getResultList();
			
			Individuo  individuo =lista!=null&&!lista.isEmpty() ? lista.get(0):new Individuo ();
			
			return individuo ;
	}

	@Override
	public List<Individuo> listarPorEspecie(Especie e) throws Exception {
		 List<Individuo> lista=null;
			
			Query q= em.createQuery("FROM Individuo i where  i.especie.idEspecie=?1");
			q.setParameter(1, e.getIdEspecie());
			
			lista=(List<Individuo>)q.getResultList();
			
					
			return lista;
	}

	@Override
	public List<Individuo> listarPorFamilia(int idFamilia) throws Exception {
		List<Individuo> lista=null;
		
		Query q= em.createQuery("FROM Individuo i where  i.especie.familia.idFamilia=?1");
		q.setParameter(1,idFamilia);
		
		lista=(List<Individuo>)q.getResultList();
		
				
		return lista;
	}

	@Override
	public List<Individuo> listarPorNomComun(Individuo i) throws Exception {
		
		List<Individuo> lista=null;
		
		Query q=em.createQuery("FROM Individuo  i where i.nombreComun=?1");
		q.setParameter(1, i.getNombreComun() );
		
		lista=(List<Individuo>)q.getResultList();
		
				
		return lista;
}
	}
