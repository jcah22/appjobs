package com.jcah.spring.app.service;

import com.jcah.spring.app.model.Vacante;

import java.util.List;

public interface IVacanteService {

    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);
    void guardar(Vacante vacante);
}
