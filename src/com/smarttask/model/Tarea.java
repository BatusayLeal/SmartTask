package com.smarttask.model;

public class Tarea {
    private int id;
    private String nombre;
    private boolean completado;

    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.completado = false;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public boolean isCompletado() {
        return completado;
    }
}
