import java.util.Date;

public class kanban {

    // Se eliminó "String[] args" porque no se utiliza
    public static void mostrarTablero() {
        System.out.println("\n--- ESTADO DEL TABLERO ---");
        
        // El formato de la fila para imprimir la tabla
        String formatoFila = "| %-4s | %-25s | %-15s | %-12s |\n";
        
        // Se imprime el encabezado
        System.out.printf(formatoFila, "ID", "TAREA", "ESTADO", "ENTREGA");
        System.out.println("------------------------------------------------------------------");

        // El for para recorrer las tareas
        for (int i = 0; i < creartareas.totalTareas; i++) {
            
            String id = String.valueOf(i);                         
            String nombre = creartareas.nombreTareas[i];   
            String estado = creartareas.estadoTareas[i];   
            Date fecha =creartareas.fechasEntrega[i];       

            // Se usa el formato de fecha dentro de un printf separado o se formatea antes.
            String fechaconformato = String.format("%1$tY-%1$tm-%1$td", fecha);

            System.out.printf(formatoFila, id, nombre, estado, fechaconformato);
        }
        System.out.println("------------------------------------------------------------------");
    }
}