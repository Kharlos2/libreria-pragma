package com.example.libreria.service;

import com.example.libreria.entidades.Autor;
import com.example.libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


    public Optional<Autor> saveAutor(Autor autor) {
        if (verificarEmail(autor)) {
            return Optional.empty();
        }
        if (autorRepository.findByPseudonimo(autor.getPseudonimo()).isPresent()) {
            return Optional.empty();
        }
        if (verificarNombreApellidoPseudonimo(autor, true)) {
            return Optional.empty();
        }
        return Optional.of(autorRepository.save(autor));
    }




    private boolean verificarNombreApellidoPseudonimo(Autor autor, boolean nacionalidad) {
        if (autor.getNacionalidad() == null && nacionalidad) {
            return true;
        }
        if (autor.getPseudonimo() == null) {
            if (autor.getNombre() == null || autor.getApellido() == null) {
                return true;
            }
        } else if (autor.getNombre() == null && autor.getApellido() == null) {
            return false;
        } else if (autor.getNombre() == null || autor.getApellido() == null) {
            return true;
        }
        return false;
    }

    private boolean verificarEmail(Autor autor) {
        if (autor.getEmail() == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (pattern.matcher(autor.getEmail()).find()) {
            return false;
        }
        return true;
    }
}