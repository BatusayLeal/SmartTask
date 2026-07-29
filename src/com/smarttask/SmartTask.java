package com.smarttask;

import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import com.smarttask.service.GestorTareas;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        agregarTarea(scanner, gestor);
                        break;
                    case 2:
                        gestor.listarTareas();
                        break;
                    case 3:
                        marcarCompletada(scanner, gestor);
                        break;
                    case 4:
                        eliminarTarea(scanner, gestor);
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Entrada inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // limpiar entrada inválida
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== SMARTTASK =====");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarTarea(Scanner scanner, GestorTareas gestor) {
        try {
            System.out.print("Nombre de la tarea: ");
            String nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                return;
            }

            System.out.println("Tipo de tarea:");
            System.out.println("1. Normal");
            System.out.println("2. Urgente");
            System.out.print("Seleccione tipo: ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            if (tipo == 1) {
                TareaNormal tarea = new TareaNormal(0, nombre);
                gestor.agregarTarea(tarea);
                System.out.println("Tarea normal agregada correctamente.");
            } else if (tipo == 2) {
                System.out.print("Días límite: ");
                int diasLimite = scanner.nextInt();
                scanner.nextLine();
                TareaUrgente tarea = new TareaUrgente(0, nombre, diasLimite);
                gestor.agregarTarea(tarea);
                System.out.println("Tarea urgente agregada correctamente.");
            } else {
                System.out.println("Entrada inválida. Intente nuevamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
        }
    }

    private static void marcarCompletada(Scanner scanner, GestorTareas gestor) {
        try {
            System.out.print("ID de la tarea a marcar como completada: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            gestor.marcarComoCompletada(id);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
        }
    }

    private static void eliminarTarea(Scanner scanner, GestorTareas gestor) {
        try {
            System.out.print("ID de la tarea a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            gestor.eliminarTarea(id);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
        }
    }
}
