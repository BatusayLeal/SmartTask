package com.smarttask.model;

public class TareaUrgente extends Tarea {

    private int diasLimite;

    public TareaUrgente(int id, String nombre, int diasLimite) {
        super(id, nombre);
        this.diasLimite = diasLimite;
    }

    
    public int getDiasLimite() {
        return diasLimite;
    }

    public void setDiasLimite(int diasLimite) {
        this.diasLimite = diasLimite;
    }

    public boolean estaVencida() {
        return diasLimite <= 0;
    }

    @Override
    public String toString() {
        String estado = isCompletado() ? "Completada" : "Pendiente";
        return "[URGENTE] ID: " + getId() + " | Nombre: " + getNombre() + " | Estado: " + estado + " | Días límite: " + diasLimite;
    }
}
