package com.example.library.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Empleado{

    @Column
    private String categoria;

    @JsonIgnore
    @ManyToMany(mappedBy = "developers")
    private Set<Proyecto> proyectos = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    private Set<Especialidad> especialidades = new HashSet<>();

    public Developer(){

    }

    public Developer(Long id, String nombre, String dni, String categoria, Set<Proyecto> proyectos, Set<Especialidad> especialidades) {
        super(id, nombre, dni);
        this.categoria = categoria;
        this.proyectos = proyectos;
        this.especialidades = especialidades;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Set<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }



}
