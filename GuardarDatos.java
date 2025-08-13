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
        // ruta
        String rutaCarpeta = "ReportesTerrobyte/";

        // Crea el objeto File para la carpeta
        File carpeta = new File(rutaCarpeta);

        // para crear carpeta
        if (!carpeta.exists()) {
            boolean carpetaCreada = carpeta.mkdir();
            if (carpetaCreada) {
                System.out.println("Se ha creado la carpeta 'ReportesTerrobyte' para guardar los reportes.");
            }
        }

        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        // Conbina la ruta de la carpeta con el nombre del archivo
        String nombreArchivo = rutaCarpeta + "reporte_Terrobyte_" + fecha + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("===== REPORTE COMPLETO DEL PROYECTO TERROBYTE =====");
            writer.println("Fecha y Hora del Reporte: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            writer.println("\n");

            // Guardar perfiles
            writer.println("---------- PERFILES DE USUARIO ----------");
            List<String> nombresCompletos = crearperfiles.nombreCorreos();
            if (nombresCompletos.isEmpty()) {
                writer.println("No hay perfiles de usuario creados.");
                //siempre hay perfiles pero ps ya que
            } else {
                for (String perfil : nombresCompletos) {
                    writer.println(perfil);
                }
            }
            writer.println("\n");

            //Guardar Equipos
            writer.println("--------- EQUIPOS CREADOS ----------");
            List<String> nombresEquipos = crearequipo.Obtenernombres();
            List<List<String>> equipos = crearequipo.obtenerEquipos();
            if (nombresEquipos.isEmpty()) {
                writer.println("No hay equipos creados.");
                //tambien siempre hay equipos
            } else {
                for (int i = 0; i < nombresEquipos.size(); i++) {
                    writer.println("Equipo: " + nombresEquipos.get(i));
                    writer.println("Miembros: " + equipos.get(i));
                    writer.println();
                }
            }
            writer.println("\n");

            // Guardar Proyectos
            writer.println("------------ PROYECTOS ------------");
            int totalProyectos = crearproyecto.getTotalProyectos();
            String[] nombresProyectos = crearproyecto.getnombreproyecto();
            String[] equiposAsignados = crearproyecto.getEquipoAsignado();
            if (totalProyectos == 0) {
                writer.println("No hay proyectos creados");
                //siempre hay proyectos pero por si las dudas
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
                //siempre hay
        
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
                    
            //  Tabla Kanban 
            writer.println("------- TABLA KANBAN -------");
            writer.println();

            // guarda las tareas en pendiente
            writer.println("PENDIENTE:");
            for (int i = 0; i < totalTareas; i++) {
                // por si o escriben mal
                if (estadosTareas[i].equalsIgnoreCase("PENDIENTE") || estadosTareas[i].equalsIgnoreCase("TODO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println();

            // guarda tareas en proceso
            writer.println("EN PROCESO:");
            for (int i = 0; i < totalTareas; i++) {
                // pa las mayusculas y asi
                if (estadosTareas[i].equalsIgnoreCase("EN PROCESO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println();

            // tareas en terminado
            writer.println("TERMINADO:");
            for (int i = 0; i < totalTareas; i++) {
                // los musmo
                if (estadosTareas[i].equalsIgnoreCase("TERMINADO")) {
                    writer.println("- " + nombresTareas[i]);
                }
            }
            writer.println("\n");

            //guardar reportes
            writer.println("---------- REPORTES -----------");
            int totalReportes = crearreporte.gettotalreportes();
            String[] reportes = crearreporte.getreportes();
            if (totalReportes == 0) {
                writer.println("No hay reportes creados.");
                //siempre hay
            } else {
                for (int i = 0; i < totalReportes; i++) {
                    writer.println(reportes[i]);
                }
            }

            System.out.println("Reporte completo guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("No se va a poder padrino,Ocurrio un error al escribir en el archivo: " + e.getMessage());
        }
    }
}