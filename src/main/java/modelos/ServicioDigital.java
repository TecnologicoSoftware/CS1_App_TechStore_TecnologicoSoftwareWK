package modelos;

import abstractos.Producto;
import enums.Categoria;
import java.util.List;

public class ServicioDigital extends Producto {

    private int duracionMinutos;
    private String descripcion;
    private Tecnico tecnicoAsignado;
    private boolean requiereTecnico;
    private boolean asignado;

    public ServicioDigital(String id, String nombre, double precio, String descripcion, int duracionMinutos) {
        super(id, nombre, precio, Categoria.SERVICIOS_TECNICOS);
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.requiereTecnico = true;
        this.tecnicoAsignado = null;
        this.asignado = false;
    }
    
    public boolean asignarTecnicoDisponible(List<Tecnico> tecnicosDisponibles) {
        // No necesita técnico
        if (!requiereTecnico) {
            this.asignado = true;
            return true; 
        }
        
        for (Tecnico tecnico : tecnicosDisponibles) {
            if (tecnico.isDisponible()) {
                this.tecnicoAsignado = tecnico;
                tecnico.setDisponible(false);
                this.asignado = true;
                return true;
            }
        }
        
        // No hay técnicos disponibles
        return false;
    }
    
    public void liberarTecnico() {
        if (this.tecnicoAsignado != null) {
            this.tecnicoAsignado.setDisponible(true);
            this.tecnicoAsignado = null;
        }
        this.asignado = false;
    }
    
    public boolean estaAsignado() {
        return asignado;
    }
    
    public boolean tieneTecnicoAsignado() {
        return tecnicoAsignado != null && asignado;
    }

    public String getInfoTecnico() {
        if (tecnicoAsignado != null) {
            return tecnicoAsignado.getNombre() + " - " + tecnicoAsignado.getEspecialidad();
        }
        return "Sin técnico asignado";
    }

    // Getters
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }
    
    public boolean isRequiereTecnico() {
        return requiereTecnico;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
}
