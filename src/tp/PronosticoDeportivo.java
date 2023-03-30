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
    private ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        pronosticos = new ListaPronosticos();
    }

    public void play(){
       // cargar y listar los equipos
        equipos.cargarDeArchivo();
        System.out.println("Los equipos cargados son: " + equipos.listar());
        // cargar lista de partidos
        partidos.cargarDeArchivo(equipos);
        System.out.println("Los partidos cargados son: " + partidos.listar());
        // cargar lista de pronosticos
        pronosticos.cargarDeArchivo(partidos);
        System.out.println("Los pronosticos cargados son: " + pronosticos.listar());
    }    
}
