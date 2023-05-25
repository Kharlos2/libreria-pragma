package com.example.libreria.controller;

import com.example.libreria.entidades.Autor;
import com.example.libreria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/")
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        Optional<Autor> data = autorService.saveAutor(autor);
        if (data.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(autor);
    }


}