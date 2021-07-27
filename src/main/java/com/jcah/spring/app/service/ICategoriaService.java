package com.jcah.spring.app.service;

import com.jcah.spring.app.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    void guardar(Categoria categoria);
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);




}
