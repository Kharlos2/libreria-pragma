package com.example.libreria.repository;

import com.example.libreria.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepo extends JpaRepository<Editorial,Integer> {

    boolean existsByNombre (String valNombre);

}
