package com.example.library.Controllers;



import com.example.library.Model.Especialidad;
import com.example.library.Model.Manager;
import com.example.library.Repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save(@RequestBody Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Especialidad findById(@PathVariable Long id) {
        return especialidadRepository.findOne(id);
    }
}
