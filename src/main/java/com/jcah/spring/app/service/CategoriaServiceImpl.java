package com.jcah.spring.app.service;

import com.jcah.spring.app.model.Categoria;
import com.jcah.spring.app.model.Vacante;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    private List<Categoria> lista = null;

    public CategoriaServiceImpl() {
        lista = new LinkedList<Categoria>();

        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNombre("Contabilidad");
        cat1.setDescripcion("descripcion de la categoria de contabilidad");


        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNombre("Ventas");
        cat2.setDescripcion("Trabajo relacionado con ventas");

        Categoria cat3 =  new Categoria();
        cat3.setId(3);
        cat3.setNombre("Comunicaciones");
        cat3.setDescripcion("configuracion de telecomunicaciones");

        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNombre("Arquitectura");
        cat4.setDescripcion("Trabajos relacionados conarquitectura");

        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNombre("Educacion");
        cat5.setDescripcion("Maestros ,tutores");

        Categoria cat6 = new Categoria();
        cat6.setId(6);
        cat6.setNombre("Desarrollo de software");
        cat6.setDescripcion("desarrollo de software para la empreesa");


        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);
        lista.add(cat6);
    }

    @Override
    public void guardar(Categoria categoria) {

        lista.add(categoria);

    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria cat : lista){
            if (cat.getId() == idCategoria){
                return cat;
            }
        }

        return null;
    }
}
