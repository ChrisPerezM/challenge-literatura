package com.alura.challengeliteratura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;
    @ManyToOne
    private Libros libros;
}