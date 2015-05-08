package com.example.library.Repositories;


import com.example.library.Model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {
	List<Developer> findByCategoria(@Param("categoria") String categoria);
    List<Developer> findByDni(@Param("dni") String dni);
    List<Developer> findByNombre(@Param("nombre") String nombre);

}
