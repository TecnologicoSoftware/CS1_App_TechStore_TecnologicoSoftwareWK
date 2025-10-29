package modelos;

import abstractos.Usuario;

public class Tecnico extends Usuario {
    private String especialidad;
    private boolean disponible;
    private int serviciosAsignados;
    
    public Tecnico(String usuario, String password, String nombre, String especialidad) {
        super(usuario, password, nombre);
        this.especialidad = especialidad;
        this.disponible = true;
        this.serviciosAsignados = 0;
    }
    
    public void asignarServicio() {
        serviciosAsignados++;
        disponible = false;
    }
    
    public void liberarServicio() {
        serviciosAsignados = Math.max(0, serviciosAsignados - 1);
        if (serviciosAsignados == 0) {
            disponible = true;
        }
    }
    
    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public int getServiciosAsignados() {
        return serviciosAsignados;
    }
}