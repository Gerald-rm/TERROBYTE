import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.lang.Math;


public class kanban {

    
    private static String crearContenidoCelda(String estadoBuscado, int posicion) {
        // consulta todos los datos de creartareas y consultamos la lista de crearperfiles
        int totalTareas = creartareas.getTotalTareas();
        String[] nombres = creartareas.getNombreTareas();
        String[] estados = creartareas.getEstadoTareas();
        int[] indicesMiembros = creartareas.getmiembrosTareas();
        Date[] fechas = creartareas.getFechasTareas();
        List<String> listaDeNombresMiembros = crearperfiles.obtenerNombresPerfiles();
        
        int contadorCoincidencias = 0; 
        
        // se recorren todas las tareas
        for (int i = 0; i < totalTareas; i++) {
            String estadoActual = estados[i];
            boolean coincidencia = false;

            // se comprueba si el estado de la tarea actual coincide con el que buscamos
            if (estadoBuscado.equalsIgnoreCase("Hecho")) {
                // caso especial para la ultima columna "Terminado"
                if (estadoActual.equalsIgnoreCase("Terminado")) {
                    coincidencia = true;
                }
            } else {
                // Caso para las demas columnas
                if (estadoActual.equalsIgnoreCase(estadoBuscado)) {
                    coincidencia = true;
                }
            }

            // si el estado coincide vemos si es la posición que nos interesa
            if (coincidencia) {
                if (contadorCoincidencias == posicion) {
                    //recopilamos y formateamos sus datos
                    String nombreTarea = nombres[i];
                    
                    // se asignan los nombre de miembros
                    int indiceMiembro = indicesMiembros[i] - 1; // se resta 1 porque los arrays empiezan en 0
                    String nombreMiembro = "N/A";
                    if (indiceMiembro >= 0 && indiceMiembro < listaDeNombresMiembros.size()) {
                        nombreMiembro = listaDeNombresMiembros.get(indiceMiembro);
                    }
                    
                    // se le da formato a la fecha
                    String fechaFormateada = "Sin fecha";
                    if (fechas[i] != null) {
                        fechaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(fechas[i]);
                    }
                    
                    // Devolvemos la "tarjeta" completa y salimos de la función
                    return String.format("%s | Miembro: %s | Entrega: %s", nombreTarea, nombreMiembro, fechaFormateada);
                }
                // Si no es la posición que buscamos, contamos y seguimos
                contadorCoincidencias++;
            }
        }
        
        return ""; // Se devuelve vacio cuando no encuentra ninguna tarea.
    }

    public static void tablero() {
        // Contamos tareas en cada estado para saber la altura del tablero
        int pendientes = 0, enProceso = 0, terminado = 0;
        for (int i = 0; i < creartareas.getTotalTareas(); i++) {
            String estado = creartareas.getEstadoTareas()[i];
            if (estado.equalsIgnoreCase("Pendiente")) pendientes++;
            else if (estado.equalsIgnoreCase("En Proceso")) enProceso++;
            else if (estado.equalsIgnoreCase("Terminado")) terminado++;
        }

        int alturaMaxima = Math.max(pendientes, Math.max(enProceso, terminado));
        String formatoFila = "| %-60s | %-60s | %-60s |\n";

        // Imprime el encabezado
        System.out.println("\n=================================================================== TABLERO KANBAN ===================================================================");
        System.out.printf(formatoFila, "PENDIENTE", "EN PROCESO", "TERMINADO");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Dibuja cada fila del tablero
        for (int i = 0; i < alturaMaxima; i++) {
            // Para cada celda, llamamos al método de ayuda para que construya su contenido
            String celdaPendiente = crearContenidoCelda("Pendiente", i);
            String celdaEnProceso = crearContenidoCelda("En Proceso", i);
            String celdaterminada = crearContenidoCelda("Terminado", i); // busca"Terminado"

            System.out.printf(formatoFila, celdaPendiente, celdaEnProceso, celdaterminada);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}