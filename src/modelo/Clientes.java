
package modelo;

/**
 *
 * @author Jose
 */
public class Clientes {
    // Atributos
    private int  id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String combinacion;
    private String estado;
    
    // Constructor vacio
    public Clientes() {
        id = 0;
        nombre = "";
        telefono = "";
        direccion = "";
        combinacion = "";
    }
    
    // Constructor con parametros

    public Clientes(int id, String nombre, String telefono, String direccion, String combinacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.combinacion = combinacion;
        this.estado = estado;
    }
    
    // Getteo and setteo

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    // Metodo toString

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", combinacion=" + combinacion + ", estado=" + estado + '}';
    }
    
    
    
}
