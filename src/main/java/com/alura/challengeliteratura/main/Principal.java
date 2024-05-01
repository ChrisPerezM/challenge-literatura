package com.alura.challengeliteratura.main;

import com.alura.challengeliteratura.model.Libros;
import com.alura.challengeliteratura.repository.LibrosRepository;
import com.alura.challengeliteratura.service.ConsumoAPI;
import com.alura.challengeliteratura.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository repositorio;
    private Optional<Libros> libroBuscado;


    public void muestraMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ***********************************************************************************
                    Elija la opción que desea através de un número de la siguiente lista:
                    1 - Buscar libro por título
                    2 - Mostrar libros registrados
                    3 - Mostrar autores registrados
                    4 - Mostrar autores vivos en una determinada fecha
                    5 - Mostrar libros por idioma
                                        
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibrosPorTitulo();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación, gracias por usar nuestros servicios.....");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibrosPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        var nombreLibro = teclado.nextLine();
        List<Libros> librosEncontrados = repositorio.librosPorNombre(nombreLibro);
        librosEncontrados.forEach(l ->
                System.out.printf("""
                        ********* LIBRO **********
                        Titulo:  %l
                        Autor: %l
                        Idioma: %l
                        Numero de descargas: %l
                        **************************
                        """, l.getTitulo(),l.getAutor(),l.getIdiomas(),l.getNumeroDeDescargas()));
    }
}
