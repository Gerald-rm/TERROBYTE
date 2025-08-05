import java.util.Date;
import java.lang.Math;

public class kanban {

    private static String componerCelda(String estadoBuscado, int posicion) {
        // Se asume que los datos están en una clase BaseDeDatosTareas
        String[] nombres = creartareas.nombreTareas;
        String[] estados = creartareas.estadoTareas;
        Date[] fechas = creartareas.fechasEntrega;
        int totalTareas = creartareas.totalTareas;
        
        int contadorLocal = 0; // Para encontrar la posicion de la tarea
        
        for (int i = 0; i < totalTareas; i++) {
            // busca tareas por estado
            if (estados[i].equalsIgnoreCase(estadoBuscado)) {
                
                if (contadorLocal == posicion) {
                    String nombreTarea = nombres[i];
                    Date fechaTarea = fechas[i];
                    
                    // Si tiene fecha se le da formato y se muestra junto al nombre
                    if (fechaTarea != null) {
                        String fechaFormateada = String.format("(%1$tY-%1$tm-%1$td)", fechaTarea);
                        return nombreTarea + " " + fechaFormateada;
                    } else {
                        // Si no tiene fecha solo se devuelve el nombre
                        return nombreTarea;
                    }
                }
                // Si no encuentra la posicion, sigue contando
                contadorLocal++;
            }
        }
        
        return ""; 
    }

    public static void mostrarTablero() {
        //Cuenta cuantas tareas hay en cada estado
        int pendientes = 0, Proceso = 0, terminado = 0;
        for (int i = 0; i < creartareas.totalTareas; i++) {
            String estado = creartareas.estadoTareas[i];
            if (estado.equalsIgnoreCase("Pendiente")) pendientes++;
            else if (estado.equalsIgnoreCase("En Proceso")) Proceso++;
            else if (estado.equalsIgnoreCase("Terminado")) terminado++;
        }

        //Calcula la altura maxima del tablero
        int alturaMaxima = Math.max(pendientes, Math.max(Proceso, terminado));

        //Imprime los encabezados
        String formatoFila = "| %-40s | %-40s | %-40s |\n";
        System.out.println("\n====================================================== KANBAN ======================================================");
        System.out.printf(formatoFila, "PENDIENTE", "EN PROGRESO", "TERMINADO");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        
        for (int i = 0; i < alturaMaxima; i++) {
            //se compone la celda con la funcion componercelda
            String celda1 = componerCelda("Pendiente", i);
            String celda2 = componerCelda("En Progreso", i);
            String celda3 = componerCelda("Hecho", i);

            // Imprime la fila completa
            System.out.printf(formatoFila, celda1, celda2, celda3);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
}