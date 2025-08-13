import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class GuardarDatos {

    public static void guardarReporteCompleto() {
        // Define la ruta de la carpeta donde se guardarán los reportes
        String rutaCarpeta = "ReportesTerrobyte/";

        // Crea el objeto File para la carpeta
        File carpeta = new File(rutaCarpeta);

        // Si la carpeta no existe, la crea automáticamente
        if (!carpeta.exists()) {
            boolean carpetaCreada = carpeta.mkdir();
            if (carpetaCreada) {
                System.out.println("Se ha creado la carpeta 'ReportesTerrobyte' para guardar los reportes.");
            }
        }

        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        // Combina la ruta de la carpeta con el nombre del archivo
        String nombreArchivo = rutaCarpeta + "reporte_terrobyte_" + fecha + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("===== REPORTE COMPLETO DEL PROYECTO TERROBYTE =====");
            writer.println("Fecha y Hora del Reporte: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            writer.println("\n");

            // --- Guardar Perfiles ---
            writer.println("--- PERFILES DE USUARIO ---");
            List<String> nombresCompletos = crearperfiles.nombreCorreos();
            if (nombresCompletos.isEmpty()) {
                writer.println("No hay perfiles de usuario creados.");
            } else {
                for (String perfil : nombresCompletos) {
                    writer.println(perfil);
                }
            }
            writer.println("\n");

            // --- Guardar Equipos ---
            writer.println("--- EQUIPOS CREADOS ---");
            List<String> nombresEquipos = crearequipo.Obtenernombres();
            List<List<String>> equipos = crearequipo.obtenerEquipos();
            if (nombresEquipos.isEmpty()) {
                writer.println("No hay equipos creados.");
            } else {
                for (int i = 0; i < nombresEquipos.size(); i++) {
                    writer.println("Equipo: " + nombresEquipos.get(i));
                    writer.println("Miembros: " + equipos.get(i));
                    writer.println();
                }
            }
            writer.println("\n");

            // --- Guardar Proyectos ---
            writer.println("--- PROYECTOS ---");
            int totalProyectos = crearproyecto.getTotalProyectos();
            String[] nombresProyectos = crearproyecto.getnombreproyecto();
            String[] equiposAsignados = crearproyecto.getEquipoAsignado();
            if (totalProyectos == 0) {
                writer.println("No hay proyectos creados.");
            } else {
                for (int i = 0; i < totalProyectos; i++) {
                    writer.println("Proyecto: " + nombresProyectos[i]);
                    writer.println("Equipo Asignado: " + equiposAsignados[i]);
                    writer.println();
                }
            }
            writer.println("\n");

            // Guardar Tareas
            writer.println("--- TAREAS ---");
            int totalTareas = creartareas.getTotalTareas();
            String[] nombresTareas = creartareas.getNombreTareas();
            String[] estadosTareas = creartareas.getEstadoTareas();
            int[] miembrosAsignados = creartareas.getmiembrosTareas();
            Date[] fechasEntrega = creartareas.getFechasTareas();
            List<String> todosLosMiembros = crearperfiles.obtenerNombresPerfiles();

            if (totalTareas == 0) {
                writer.println("No hay tareas creadas.");
            } else {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                for (int i = 0; i < totalTareas; i++) {
                    String nombreMiembro = (miembrosAsignados[i] > 0 && miembrosAsignados[i] <= todosLosMiembros.size())
                        ? todosLosMiembros.get(miembrosAsignados[i] - 1)
                        : "Sin asignar";
                    String fechaTarea = (fechasEntrega[i] != null)
                        ? formatoFecha.format(fechasEntrega[i])
                        : "Sin fecha";

                    writer.println("Tarea: " + nombresTareas[i]);
                    writer.println("Estado: " + estadosTareas[i]);
                    writer.println("Miembro Asignado: " + nombreMiembro);
                    writer.println("Fecha de Entrega: " + fechaTarea);
                    writer.println();
                }
            }
            writer.println("\n");
                        // --- Guardar Tabla Kanban ---
            writer.println("--- TABLA KANBAN ---");
            writer.println();

            // Filtra y guarda las tareas en estado "TODO"
            writer.println("TODO:");
            for (int i = 0; i < totalTareas; i++) {
                if (estadosTareas[i].equalsIgnoreCase("TODO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println();

            // Filtra y guarda las tareas en estado "EN PROGRESO"
            writer.println("EN PROGRESO:");
            for (int i = 0; i < totalTareas; i++) {
                if (estadosTareas[i].equalsIgnoreCase("EN PROGRESO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println();

            // Filtra y guarda las tareas en estado "TERMINADO"
            writer.println("TERMINADO:");
            for (int i = 0; i < totalTareas; i++) {
                if (estadosTareas[i].equalsIgnoreCase("TERMINADO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println("\n");

            // --- Guardar Reportes ---
            writer.println("--- REPORTES ---");
            int totalReportes = crearreporte.gettotalreportes();
            String[] reportes = crearreporte.getreportes();
            if (totalReportes == 0) {
                writer.println("No hay reportes creados.");
            } else {
                for (int i = 0; i < totalReportes; i++) {
                    writer.println(reportes[i]);
                }
            }

            System.out.println("Reporte completo guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Ocurrio un error al escribir en el archivo: " + e.getMessage());
        }
    }
}