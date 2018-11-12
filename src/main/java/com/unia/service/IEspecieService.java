package com.unia.service;

import java.util.List;

import com.unia.model.Especie;
import com.unia.model.Familia;

public interface IEspecieService extends IService<Especie>{
	List<Especie> listarPorFamilia(Familia f)throws Exception;
	List<Especie> listarPorNombreCientifico(Especie e)throws Exception;
	List<Especie> listarPorNombreComun(Especie e)throws Exception;
}
