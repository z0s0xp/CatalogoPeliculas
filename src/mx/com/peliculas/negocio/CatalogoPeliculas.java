
package mx.com.peliculas.negocio;

/**
 *
 * @author z0s0xp
 */
public interface CatalogoPeliculas {
   String NOMBRE_RECURSO="peliculas.txt";
    
    void agregarPelicula(String nombrePelicula);
    void listar();
    void buscar(String buscar);
    void iniciarCatalogoPeliculas();
}
