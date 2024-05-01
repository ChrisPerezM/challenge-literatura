package com.alura.challengeliteratura.repository;

import com.alura.challengeliteratura.model.Libros;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros, Long> {
    @Query("SELECT * FROM Libros l  WHERE l.titulo t ILIKE %:nombreLibro%")
    List<Libros> librosPorNombre(String nombreLibro);
}
