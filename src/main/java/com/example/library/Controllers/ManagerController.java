package com.example.library.Controllers;



import com.example.library.Model.Manager;
import com.example.library.Model.Proyecto;
import com.example.library.Repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Manager save(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Manager findById(@PathVariable Long id) {
        return managerRepository.findOne(id);
    }
}
