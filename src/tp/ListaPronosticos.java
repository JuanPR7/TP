
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Grupo 4
 */
public class ListaPronosticos {
    
    private List<Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos(List<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }
    
    
        public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico> ();
        this.nombreArchivo = "";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", nombreArchivo=" + nombreArchivo + '}';
    }

    public void addPronosticos(Pronostico p) {
        this.pronosticos.add(p);
    }
    public void removePronosticos(Pronostico p) {
        this.pronosticos.remove(p);
    }

    public String listar() {
        String lista = "";
        for (Pronostico pronostico: pronosticos) {
            lista += "\n" + pronostico;
        }           
        return lista;
    }
 
    // cargar desde el archivo
    public void cargarDeArchivo(ListaPartidos listPartidos) {
        // para las lineas del archivo csv
        String datosPronostico;
        // para los datos individuales de cada linea
        String vectorPronostico[];
        // para el objeto en memoria
        Pronostico pronostico;
        int fila = 0;
        int idPronostico = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./Pronosticos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostico = sc.next();
               // System.out.println(datosEquipo);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostico.split(",");   
                
                idPronostico += 1;
                int idPartido = Integer.parseInt(vectorPronostico[1]);
                Partido partido = listPartidos.getPartido(idPartido);
                int eq = Integer.parseInt(vectorPronostico[2]);
                  Equipo equipo = new Equipo();
                if (eq == 1){
                    equipo = partido.getEquipo1();
                }else{
                     equipo = partido.getEquipo2();
                }
                char resultado =  vectorPronostico[3].charAt(1);
                // crea el objeto en memoria
                pronostico = new Pronostico(idPronostico, equipo, partido, resultado);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPronosticos(pronostico);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }

}
