package com.puce.service;

import com.puce.entity.Libro;
import com.puce.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    //LEER - SELECT
    public List<Libro> mostrarLibros(){
        return libroRepository.findAll();
    }

    //Buscar libro por id - SELECT * FROM LIBROS WHERE ID = 10
    public Optional<Libro> buscarLibroPorId(Long id){
        return libroRepository.findById(id);

    }

    //GUARDAR - INSERT INTO LIBROS VALUES()
    public Libro guardarLibro(Libro libro){
        return libroRepository.save(libro);
    }

    //ACTUALIZAR - UPDATE LIBROS SET NOMBRE='NUEVO NOMBRE' WHERE ID = 10
    public Libro actualizarLibro(Libro libro, Long id){
        Libro libroEncontrado = buscarLibroPorId(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        libroEncontrado.setTitulo(libro.getTitulo());
        libroEncontrado.setNumeroPaginas(libro.getNumeroPaginas());
        libroEncontrado.setEditorial(libro.getEditorial());

        return libroRepository.save(libroEncontrado);
    }

    //ELIMINAR - DELETE FROM LIBROS WHERE ID = 10
    public void eliminarLibro(Long id){
        Libro libro = buscarLibroPorId(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));
        libroRepository.delete(libro);
    }
}
