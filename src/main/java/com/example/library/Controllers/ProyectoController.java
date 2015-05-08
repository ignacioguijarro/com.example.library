package com.example.library.Controllers;


import com.example.library.Model.Developer;
import com.example.library.Model.Especialidad;
import com.example.library.Model.Proyecto;
import com.example.library.Repositories.DeveloperRepository;
import com.example.library.Repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto save(@RequestBody Proyecto proyecto) {

        return proyectoRepository.save(proyecto);
    }


    @RequestMapping(value = "/{id}", method = GET)
    public Proyecto findById(@PathVariable Long id) {
        return proyectoRepository.findOne(id);
    }


    @RequestMapping( method = GET)
    public List<Proyecto> findAll() {
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        Iterator<Proyecto> iterator = proyectoRepository.findAll().iterator();

        while(iterator.hasNext()){
            Proyecto proyecto = iterator.next();
            proyectos.add(proyecto);
            System.out.println(proyecto);

        }

        return proyectos;
    }

    //Un developer ha de dominar como minimo una de las especialidades requeridas por el proyecto.
    @RequestMapping(value = "/{idProyecto}/developers/{idDeveloper}", method = GET)
    public Proyecto getProyectoDeveloper(@PathVariable Long idProyecto, @RequestBody Long idDeveloper) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Developer developer = developerRepository.findOne(idDeveloper);

        boolean accepted = false;

        //comprobamos si el developer contiene la especialidad requerida por el proyecto
        for (Especialidad especialidad : proyecto.getEspecialidades()){
            if(developer.getEspecialidades().contains(especialidad) ){
                accepted = true;
                break;
            }
        }
        if (accepted) {
            proyecto.getDevelopers().add(developer);
            proyectoRepository.save(proyecto);

        }


        return proyecto;
    }

    //Un developer ha de dominar como minimo una de las especialidades requeridas por el proyecto.
    @RequestMapping(value = "/{idProyecto}/developers/{idDeveloper}", method = POST)
    public Proyecto addDeveloper(@PathVariable Long idProyecto, @PathVariable Long idDeveloper) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Developer developer = developerRepository.findOne(idDeveloper);

        boolean accepted = false;

        //comprobamos si el developer contiene la especialidad requerida por el proyecto
        for (Especialidad especialidad : proyecto.getEspecialidades()){
            if(developer.getEspecialidades().contains(especialidad) ){
                accepted = true;
                break;
            }
        }
        if (accepted) {
            proyecto.getDevelopers().add(developer);
            proyectoRepository.save(proyecto);

        }else{
            throw new RuntimeException("The developer doesn't contain the required specialties!");
        }


        return proyecto;
    }



}
