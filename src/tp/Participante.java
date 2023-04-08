
package tp;

/*
 * @author Grupo 4
 */
public class Participante {
    
    private int idParticipante;
    private String nombre;
    private ListaPronosticos pronosticos;
    private int puntaje;

    public Participante(int idParticipante, String nombre, ListaPronosticos pronosticos, int puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
        this.puntaje = puntaje;
    }
    
    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronosticos = null;
        this.puntaje = 0;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronosticos=" + pronosticos + ", puntaje=" + puntaje + '}';
    }
    
    public void cargarPronosticos(ListaPronosticos pronosticos){
        this.pronosticos = pronosticos;
    
    }
    
    public int calcularPuntaje(){
        int puntosTotal = 0;
        for (Pronostico pronos : pronosticos.getPronosticos()) {
            var resulPronostico = pronos.getResultado();
            char resulPartido = pronos.getPartido().resultado(pronos.getEquipo());
            //si resultado Pronostico es igual al del partido => acierto suma 3
            if (resulPronostico == resulPartido)
                puntosTotal = puntosTotal +3;

        } 
        
        return puntosTotal;
    }
    
    public int getAciertos(){
         int aciertos = 0;
        for (Pronostico pronos : pronosticos.getPronosticos()) {
            var resulPronostico = pronos.getResultado();
            char resulPartido = pronos.getPartido().resultado(pronos.getEquipo());
            //si resultado Pronostico es igual al del partido => acierto +1
            if (resulPronostico == resulPartido)
                aciertos += 1;

        } 
        
        return aciertos;
    }
    
     
    
}
