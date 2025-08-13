import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class crearequipo {

    // Lista para guardar todos los equipos creados
    private static List<List<String>> equipos = new ArrayList<>();

    private static List<String> Nombres = new ArrayList<>();
    // equipos predeterminados
    static {
        List<String> perfiles = crearperfiles.obtenerNombresPerfiles();

        // Equipo Temach hasta la muerte brrrr
        List<String> equipo1 = new ArrayList<>();
        equipo1.add(perfiles.get(0));
        equipo1.add(perfiles.get(1));
        equipos.add(equipo1);
        Nombres.add("Equipo Temach");

        // Equipo dani rep
        List<String> equipo2 = new ArrayList<>();
        equipo2.add(perfiles.get(2));
        equipos.add(equipo2);
        Nombres.add("Equipo Danirep");
    }


    public void crearGrupo() {
        Scanner sc = new Scanner(System.in);
        List<String> perfiles = crearperfiles.obtenerNombresPerfiles();
        System.out.println("\n======Crear Equipos======");

        if (perfiles.isEmpty()) {
            System.out.println("No hay perfiles. Crea uno ahora.\n");
            crearperfiles cp = new crearperfiles();
            cp.crearnuevoPerfil();
            perfiles = crearperfiles.obtenerNombresPerfiles();
        }

        String nombredelGrupo;
        while (true) {
            System.out.print("Nombre del grupo: ");
            nombredelGrupo = sc.nextLine();

            if (Nombres.contains(nombredelGrupo)) {
                System.out.println("Ese nombre de equipo ya está en uso, intenta con otro.");
            } else {
                Nombres.add(nombredelGrupo);
                break; // salir del bucle si es válido
        }
    }

        
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
                System.out.println("El numero no es valido");
            }
        }

        if (!miembros.isEmpty()) {
            equipos.add(miembros); //guardar equipos
            System.out.println("\nGrupo '" + nombredelGrupo + "' creado con estos miembros:");
            for (String m : miembros) {
                System.out.println("- " + m);
            }
        } else {
            System.out.println("No se agregaron miembros al grupo.");
        }

        System.out.println();
    }

    public static List<String> Obtenernombres() {
        return Nombres;
    }
    public static List<List<String>> obtenerEquipos() {
        return equipos;
    }
}