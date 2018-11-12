package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Especie;
import com.unia.model.Familia;

@Local
public interface IEspecieDAO extends IDAO<Especie>{
	
	List<Especie> listarPorFamilia(Familia f)throws Exception;
	List<Especie> listarPorNombreCientifico(Especie e)throws Exception;
	List<Especie> listarPorNombreComun(Especie e)throws Exception;
}
