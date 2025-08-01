import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class crearequipo {

    // Lista para guardar todos los equipos creados
    private static List<List<String>> equipos = new ArrayList<>();

    public void crearGrupo() {
        Scanner sc = new Scanner(System.in);
        List<String> perfiles = crearperfiles.obtenerNombresPerfiles();

        System.out.println("\n===== Crear Equipos =====");

        if (perfiles.isEmpty()) {
            System.out.println("No hay perfiles. Crea uno ahora.\n");
            crearperfiles cp = new crearperfiles();
            cp.crearnuevoPerfil();
            perfiles = crearperfiles.obtenerNombresPerfiles();
        }

        System.out.print("Nombre del grupo: ");
        String nombreGrupo = sc.nextLine();

        System.out.println("Perfiles disponibles:");
        for (int i = 0; i < perfiles.size(); i++) {
            System.out.println((i + 1) + ". " + perfiles.get(i));
        }

        System.out.print("Selecciona los numeros de los miembros separados por comas (ej: 1,3): ");
        String[] seleccion = sc.nextLine().split(",");
        List<String> miembros = new ArrayList<>();

        for (String s : seleccion) {
            try {
                int index = Integer.parseInt(s.trim()) - 1;
                if (index >= 0 && index < perfiles.size()) {
                    miembros.add(perfiles.get(index));
                }
            } catch (NumberFormatException e) {
                // Ignorar errores de conversión
            }
        }

        if (!miembros.isEmpty()) {
            equipos.add(miembros); //guardar equipos
            System.out.println("\nGrupo '" + nombreGrupo + "' creado con estos miembros:");
            for (String m : miembros) {
                System.out.println("- " + m);
            }
        } else {
            System.out.println("No se agregaron miembros al grupo.");
        }

        System.out.println();
    }

  
    public static List<List<String>> obtenerEquipos() {
        return equipos;
    }
}