package com.smarttask.service;

// import com.smarttask.model.Tarea;
import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GestorTareasTest {

    private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    void testAgregarTarea() {
        TareaNormal tarea1 = new TareaNormal(0, "Estudiar Java");
        gestor.agregarTarea(tarea1);

        assertEquals(1, tarea1.getId());
        assertEquals(1, gestor.getTareas().size());
        assertEquals("Estudiar Java", gestor.getTareas().get(0).getNombre());
        assertFalse(gestor.getTareas().get(0).isCompletado());

        TareaUrgente tarea2 = new TareaUrgente(0, "Entregar proyecto", 3);
        gestor.agregarTarea(tarea2);

        assertEquals(2, tarea2.getId());
        assertEquals(2, gestor.getTareas().size());
        assertEquals(3, gestor.getSiguienteId());
    }

    @Test
    void testListarTareas() {
        TareaNormal t1 = new TareaNormal(0, "Tarea normal");
        TareaUrgente t2 = new TareaUrgente(0, "Tarea urgente", 5);
        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        gestor.listarTareas();

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("TAREAS ACTIVAS"));
        assertTrue(output.contains("TAREAS COMPLETADAS"));
        assertTrue(output.contains("[NORMAL]"));
        assertTrue(output.contains("[URGENTE]"));
        assertTrue(output.contains("Tarea normal"));
        assertTrue(output.contains("Tarea urgente"));
    }

    @Test
    void testMarcarComoCompletada() {
        TareaNormal tarea = new TareaNormal(0, "Completar informe");
        gestor.agregarTarea(tarea);

        assertFalse(tarea.isCompletado());
        assertEquals(1, tarea.getId());

        gestor.marcarComoCompletada(1);

        assertTrue(tarea.isCompletado());
        assertTrue(gestor.getTareas().get(0).isCompletado());

        // Verificar que no marca una inexistente (no lanza excepción)
        gestor.marcarComoCompletada(999);
        assertEquals(1, gestor.getTareas().size());
    }
}
