package com.example.libreria.controller;

import com.example.libreria.entidades.Editorial;
import com.example.libreria.repository.EditorialRepo;
import com.example.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(

)
public class EditorialController {
    @Autowired
    private EditorialService editorialService;


    @PostMapping
    public ResponseEntity<?> crearEditorial (@RequestBody Editorial editorial){
        return editorialService.crearEditorial(editorial);
    }

}
