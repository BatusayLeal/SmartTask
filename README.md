## Descripción

SMARTTASK es una aplicación de consola en Java para el trabajo de modulo 4
.  
Permite agregar tareas normales o urgentes, listarlas separadas por estado (activas / completadas), marcarlas como completadas y eliminarlas. 

El proyecto implementa herencia (Tarea → TareaNormal / TareaUrgente), una interfaz de servicio (Accionable) y un gestor que genera IDs autoincrementales sin reutilización.

## Cómo compilar

Desde la raíz del proyecto:

```bash
javac -d out src/com/smarttask/model/*.java src/com/smarttask/service/*.java src/com/smarttask/SmartTask.java
```

## Cómo ejecutar

```bash
java -cp out com.smarttask.SmartTask
```

Para ejecutar las pruebas unitarias (requiere JUnit 5 en el classpath):

```bash
javac -d out -cp "lib/*" test/com/smarttask/service/GestorTareasTest.java src/com/smarttask/model/*.java src/com/smarttask/service/*.java 
java -cp "out:lib/*" org.junit.platform.console.ConsoleLauncher --class-path out --select-class com.smarttask.service.GestorTareasTest
```

es normal que aparezca el mensaje:
"Tarea no encontrada."
¿Por qué aparece?
En el test testMarcarComoCompletada() tenemos esta línea a propósito:
Javagestor.marcarComoCompletada(999); // ID que no existe
Esa llamada es para verificar que el programa no se cae cuando se intenta marcar una tarea inexistente. Como el método marcarComoCompletada imprime el mensaje por consola, aparece en el log de las pruebas.
No es un error. Las 3 pruebas están pasando correctamente (✔).
Estructura de clases

## Estructura de clases

```
src/
└── com/smarttask/
    ├── Main.java                  # Punto de entrada y menú interactivo
    ├── model/
    │   ├── Tarea.java             # Clase base abstracta de tarea
    │   ├── TareaNormal.java       # Tarea de tipo normal
    │   └── TareaUrgente.java      # Tarea urgente con días límite y método estaVencida()
    └── service/
        ├── Accionable.java        # Interfaz con operaciones del gestor
        └── GestorTareas.java      # Implementación: lista de tareas + IDs autoincrementales

test/
└── com/smarttask/service/
    └── GestorTareasTest.java      # Pruebas unitarias JUnit 5
```

## Enlace al repositorio

https://github.com/BatusayLeal/SmartTask
