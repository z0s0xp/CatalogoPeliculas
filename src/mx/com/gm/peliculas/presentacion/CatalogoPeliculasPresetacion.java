package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.peliculas.negocio.CatalogoPeliculas;
import mx.com.peliculas.negocio.*;

/**
 *
 * @author z0s0xp
 */
public class CatalogoPeliculasPresetacion {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar pelicula\n"
                    + "4. Buscar pelicula\n"
                    + "0. salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Escribe el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listar();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscar(buscar);
                    break;
                case 0:
                    System.out.println("Adios :D");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;

            }

        }
    }
}
