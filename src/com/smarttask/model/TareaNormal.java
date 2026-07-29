package com.smarttask.model;

public class TareaNormal extends Tarea {

    public TareaNormal(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String toString() {
        String estado = isCompletado() ? "Completada" : "Pendiente";
        return "[NORMAL] ID: " + getId() + " | Nombre: " + getNombre() + " | Estado: " + estado;
    }
}
