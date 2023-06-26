
package mx.com.gm.peliculas.domain;

/**
 *
 * @author z0s0xp
 */
public class Pelicula {
    
   private String nombre;
   
   //Constructor por defecto o vacio
   public Pelicula(){
   }
   //Constructor inicializado
   public Pelicula(String nombre){
   this.nombre=nombre;
   }

   //Metodos Get and Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //Metodo toString
    @Override
    public String toString() {
        return  this.nombre ;
    }

   

   
}
