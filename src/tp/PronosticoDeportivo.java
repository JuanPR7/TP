/*
Para entrega 2
 */
package tp;


/**
 *
 * @author aguzman
 */
public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
    }

    public void play(){
       // cargar y listar los equipos
        equipos.cargarDeArchivo();
        System.out.println("Los equipos cargados son: " + equipos.listar());
        // cargar lista de partidos
        partidos.cargarDeArchivo(equipos);
        System.out.println("Los partidos cargados son: " + partidos.listar());
        
    }    
}
