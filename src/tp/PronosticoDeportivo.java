/*
Para entrega 2
 */
package tp;

import java.util.List;


/**
 *
 * @author aguzman
 */
public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaPronosticos pronosticos;
    private ListaParticipantes participantes;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        pronosticos = new ListaPronosticos();
        participantes = new ListaParticipantes();
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
        
        //cargar la lista de participantes + la lista de pronostico de cada participante
        participantes.cargarDeArchivo();       
        String lista = "";
        List<Participante> p = participantes.getParticipantes();
        for (Participante participante: p ) {
            ListaPronosticos pronosticosP = new ListaPronosticos();
            pronosticosP.cargarDeArchivo(partidos,participante.getIdParticipante());
            participante.setPronosticos(pronosticosP);
            lista += "\n" + participante;
        }   
        System.out.println("Los Participantes cargados son: " + lista);
        
    }    
}
