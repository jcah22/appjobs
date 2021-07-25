package com.jcah.spring.app.service;

import com.jcah.spring.app.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacantesServiceImpl implements IVacanteService {

    private List<Vacante> lista = null;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new ArrayList<Vacante>();

        try {
            //oferta de trabajo1
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero civil");
            vacante1.setDescripcion("Ingeniero civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(14000.0);
            vacante1.setDestacado(1);
            vacante1.setImagen("logo1.png");


            // oferta de trabajo 2
            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("contador publico");
            vacante2.setDescripcion("contador con 5 años de experiencia titulado");
            vacante2.setFecha(sdf.parse("12-10-2019"));
            vacante2.setSalario(12000.0);
            vacante2.setDestacado(0);
            vacante2.setImagen("logo2.png");

            //vacante #3

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Ingeniero electromecanico para mantenimiento de la instalacion electrica");
            vacante3.setFecha(sdf.parse("14-08-2020"));
            vacante3.setSalario(10500.0);
            vacante3.setDestacado(0);


            //vacante #4
            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Grafico");
            vacante4.setDescripcion("Diseñador grafico para diseñar la publicidad de la empresa");
            vacante4.setFecha(sdf.parse("12-06-2021"));
            vacante4.setSalario(11500.0);
            vacante4.setDestacado(1);
            vacante4.setImagen("logo3.png");


            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);


        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }


    }


    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {

        for(Vacante v : lista){
            if(v.getId() == idVacante){
                return v;
            }
        }

        return null;
    }
}
