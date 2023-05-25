package com.example.libreria.service;

import com.example.libreria.entidades.Editorial;
import com.example.libreria.repository.EditorialRepo;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {


    private EditorialRepo editorialRepo;

    public EditorialService(EditorialRepo editorialRepo) {
        this.editorialRepo = editorialRepo;
    }

    public ResponseEntity<?> crearEditorial (Editorial editorial){
        if (editorialRepo.existsByNombre(editorial.getNombre())){
            return ResponseEntity.badRequest().body("Esta editorial ya existe");
        }
        else if(editorial.getNombre().length()<2 || editorial.getNombre().length()>30){
            return ResponseEntity.badRequest().body("Solo se permite mas de 1 caracter y menor de 30");
        } else if (editorial.getDescripcion().length()>300) {
            return ResponseEntity.badRequest().body("Solo se permiten 300 caracteres");
        }
        Editorial editorialResultado = editorialRepo.save(editorial);
        return ResponseEntity.ok(editorialResultado);
    }

}
