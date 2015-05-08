package com.example.library.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
    protected String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "especialidades")
    private Set<Proyecto> proyectos = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "especialidades")
    private Set<Developer> developers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Especialidad(){

    }

    public Especialidad(String nombre, Set<Proyecto> proyectos, Set<Developer> developers) {
        this.nombre = nombre;
        this.proyectos = proyectos;
        this.developers = developers;
    }


}
