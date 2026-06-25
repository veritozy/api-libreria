package com.puce.controller;

import com.puce.entity.Libro;
import com.puce.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    //LEER
    @GetMapping
    public List<Libro> leerLibros(){
        return libroService.mostrarLibros();
    }

    //REGISTRAR LIBRO
    @PostMapping("/guardarLibro")
    public Libro guardarLIbro(@RequestBody Libro libro){
        return libroService.guardarLibro(libro);
    }

    //ACTUALIZAR LIBRO
    @PutMapping("/actualizarLibro/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.actualizarLibro(libro, id);
    }

    //ELIMINAR
    @DeleteMapping("/eliminarLibro/{id}")
    public void eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
     }
}
