package com.smarttask.service;

import com.smarttask.model.Tarea;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {

    private List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.siguienteId = 1;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tarea.setId(siguienteId);
        siguienteId++;
        tareas.add(tarea);
    }

    @Override
    public void listarTareas() {
        System.out.println("TAREAS ACTIVAS");
        boolean hayActivas = false;
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletado()) {
                System.out.println(tarea.toString());
                hayActivas = true;
            }
        }
        if (!hayActivas) {
            System.out.println("(ninguna)");
        }

        System.out.println("TAREAS COMPLETADAS");
        boolean hayCompletadas = false;
        for (Tarea tarea : tareas) {
            if (tarea.isCompletado()) {
                System.out.println(tarea.toString());
                hayCompletadas = true;
            }
        }
        if (!hayCompletadas) {
            System.out.println("(ninguna)");
        }
    }

    @Override
    public void eliminarTarea(int id) {
        Tarea encontrada = null;
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                encontrada = tarea;
                break;
            }
        }
        if (encontrada != null) {
            tareas.remove(encontrada);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    @Override
    public void marcarComoCompletada(int id) {
        Tarea encontrada = null;
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                encontrada = tarea;
                break;
            }
        }
        if (encontrada != null) {
            encontrada.setCompletado(true);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    // Método auxiliar para tests (no forma parte de la interfaz)
    public List<Tarea> getTareas() {
        return tareas;
    }

    public int getSiguienteId() {
        return siguienteId;
    }
}
