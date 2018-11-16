package com.unia.service;

import java.util.List;

import com.unia.model.Especie;
import com.unia.model.Individuo;

public interface IIndividuoService extends IService<Individuo>{
	
	List<Individuo> listarPorEspecie(Especie e)throws Exception;
	List<Individuo> listarPorFamilia(Especie e)throws Exception;
	List<Individuo> listarPorNomComun(Individuo i)throws Exception;
}
