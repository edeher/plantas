package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Especie;
import com.unia.model.Familia;
import com.unia.model.Individuo;

@Local
public interface IIndividuoDAO extends IDAO<Individuo>{
	
	List<Individuo> listarPorEspecie(Especie e)throws Exception;
	List<Individuo> listarPorFamilia(Especie e)throws Exception;
	List<Individuo> listarPorNomComun(Individuo i)throws Exception;
}
