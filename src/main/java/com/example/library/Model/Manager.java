package com.example.library.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Empleado {

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private Set<Proyecto> proyectos = new HashSet<>();

    public Manager(){

    }

    public Manager(Long id, String nombre, String dni, Set<Proyecto> proyectos) {
        super(id, nombre, dni);
        this.proyectos = proyectos;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


}
