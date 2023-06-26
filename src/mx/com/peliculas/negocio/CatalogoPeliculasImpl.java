
package mx.com.peliculas.negocio;


import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author z0s0xp
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos=new AccesoDatosImpl();
        
    }
    
    
    

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula peicula=new Pelicula(nombrePelicula);
        boolean anexar=false;
        try {
            anexar=datos.existente("NOMBRE_RECURSO");
            datos.escribir(peicula, NOMBRE_RECURSO, anexar);
            
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        
        
        }

    }

    @Override
    public void listar() {
        try {
            var peliculas =this.datos.lista(NOMBRE_RECURSO);
            for(var pelicula:peliculas){
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);

        }

    }

    @Override
    public void buscar(String buscar) {
        String resultado=null;
        try {
            resultado=this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);

        }
        System.out.println("resultado = " + resultado);


    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existente(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
                
            }else{
                datos.crear(NOMBRE_RECURSO);
                
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error a iniciar catalogo de pelicuas");
            ex.printStackTrace(System.out);

        }

    }
    
  
}
