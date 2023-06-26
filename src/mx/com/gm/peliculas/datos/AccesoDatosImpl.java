/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatdosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author z0s0xp
 */
public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existente(String nombreRecurso) throws AccesoDatosEx {
        File archivo=new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> lista(String nombreRecurso) throws LecturaDatosEx {
    
        File archivo=new File(nombreRecurso);
        List<Pelicula> peliculas=new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea=null;
            linea=entrada.readLine();
            while(linea !=null){
                Pelicula pelicula=new Pelicula(linea);
                peliculas.add(pelicula);
                linea=entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar pelicula: "+ex.getMessage());

        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al listar pelicula: "+ex.getMessage());
            

        }
        return peliculas;
        }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatdosEx {
        var archivo=new File(nombreRecurso);
        try {
            var salida=new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se a escrito informacion al archivo "+pelicula);
        
        } catch (IOException ex) {
            throw new EscrituraDatdosEx("Excepcion al escribir pelicula: "+ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {

        var archivo=new File(nombreRecurso);
        String resultado=null;
        try {
            var entrada= new BufferedReader(new FileReader(archivo));
            String linea=null;
            linea=entrada.readLine();
            int indice=1;
            while(linea!=null){
                if(buscar!=null&& buscar.equalsIgnoreCase(linea)){
                resultado="Pelicula "+linea+"encontrada en el indice"+indice;
                break;
                
                }
                linea=entrada.readLine();
                indice++;
            }
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscra pelicula: "+ex.getMessage());

        } catch (IOException ex) {

            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscra pelicula: "+ex.getMessage());


        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo=new File(nombreRecurso);
        try {
            PrintWriter salida=new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se a creado archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear pelicula: "+ex.getMessage());
        }


    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo= new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha eliminado el archivo");    
    
    
    }

    
}
