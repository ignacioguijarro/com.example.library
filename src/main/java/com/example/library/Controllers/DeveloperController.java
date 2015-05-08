package com.example.library.Controllers;



import com.example.library.Model.Developer;
import com.example.library.Model.Especialidad;
import com.example.library.Repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Developer findById(@PathVariable Long id) {
        return developerRepository.findOne(id);
    }
}
