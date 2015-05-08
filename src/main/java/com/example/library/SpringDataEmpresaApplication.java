package com.example.library;


import com.example.library.Model.Developer;
import com.example.library.Model.Especialidad;
import com.example.library.Model.Manager;
import com.example.library.Model.Proyecto;
import com.example.library.Repositories.DeveloperRepository;
import com.example.library.Repositories.EspecialidadRepository;
import com.example.library.Repositories.ManagerRepository;
import com.example.library.Repositories.ProyectoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@SpringBootApplication
@EnableJpaRepositories
public class SpringDataEmpresaApplication {

    public static void main(String[] args) {
	    ConfigurableApplicationContext context = SpringApplication.run(SpringDataEmpresaApplication.class, args);
//fechas
        Calendar c1 = GregorianCalendar.getInstance();

        c1.set(GregorianCalendar.YEAR, 2015);
        c1.set(GregorianCalendar.MONTH, 8);
        c1.set(GregorianCalendar.DATE, 18);

        Date d1 = c1.getTime();

//repositorios
        EspecialidadRepository especialidadRepository = context.getBean(EspecialidadRepository.class);
        DeveloperRepository developerRepository = context.getBean(DeveloperRepository.class);
        ProyectoRepository proyectoRepository = context.getBean(ProyectoRepository.class);
        ManagerRepository managerRepository = context.getBean(ManagerRepository.class);


//managers
        Manager manager1 = new Manager();
        manager1.setNombre("k-rlos");
        manager1.setDni("3742121A");
        managerRepository.save(manager1);

//especialidad
        Especialidad especialidad1 = new Especialidad();
        especialidad1.setNombre("Java");
        especialidadRepository.save(especialidad1);

//developer
        Developer developer1 = new Developer();
        developer1.setNombre("ignacio");
        developer1.setDni("47323112Z");
        developer1.setCategoria("junior");

//developer y espec
        developer1.getEspecialidades().add(especialidad1);
        developerRepository.save(developer1);

//proyectos
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setDescripcion("muchas pruebas demasiadas");
        proyecto1.setFechaFin(d1);
        proyecto1.setFechaInicio(new Date());

        proyecto1.getDevelopers().add(developer1);
        proyecto1.getEspecialidades().add(especialidad1);
        proyecto1.setManager(manager1);
        proyectoRepository.save(proyecto1);

        Proyecto proyecto2 = new Proyecto();
        proyecto2.setDescripcion("cosas cosas cosas cosas");
        proyecto2.setFechaFin(d1);
        proyecto2.setFechaInicio(new Date());

        proyecto2.getDevelopers().add(developer1);
        proyecto2.getEspecialidades().add(especialidad1);
        proyecto2.setManager(manager1);
        proyectoRepository.save(proyecto2);




    }
}
