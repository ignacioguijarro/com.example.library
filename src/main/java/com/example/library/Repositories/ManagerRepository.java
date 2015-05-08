package com.example.library.Repositories;


import com.example.library.Model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
	List<Manager> findByNombre(@Param("nombre") String nombre);
	List<Manager> findByDni(@Param("dni") String dni);

}
