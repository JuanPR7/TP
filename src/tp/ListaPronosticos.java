
package tp;

import java.util.ArrayList;
import java.util.List;
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
    
    public void cargarDeArchivo(){
    }
}
