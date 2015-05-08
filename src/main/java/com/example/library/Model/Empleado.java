package com.example.library.Model;
import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
    protected String nombre;

    @Column
    protected String dni;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


}