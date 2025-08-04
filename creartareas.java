import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class creartareas {
static final int Maximodetareas = 50;
static String[] nombreTareas = new String[Maximodetareas];
static String[] estadoTareas = new String[Maximodetareas];
static int[] equipoTareas = new int[Maximodetareas];
static int totalTareas = 0;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

    if (totalTareas >= Maximodetareas) {
        System.out.println("Haz alcanzado el limite de tareas.");
        
    }
   
    System.out.println("Ingresa el Nombre de la tarea: ");
    nombreTareas[totalTareas]= sc.nextLine();
    System.out.println("Ingresa el estado de la Tarea (ej: Pendiente, En Proceso, Terminado)");
    estadoTareas[totalTareas]=sc.nextLine();
    System.out.println("Equipos disponibles:");
        List<List<String>> todosLosEquipos = crearequipo.obtenerEquipos();

        for (int i = 0; i <todosLosEquipos.size(); i++) {
            System.out.println((i+1) + ". "+todosLosEquipos.get(i));
        }
        System.out.print("Asignar a equipo : ");
        equipoTareas[totalTareas] = sc.nextInt(); sc.nextLine();

        totalTareas++;
        System.out.println("Tarea creada correctamente.");
    }

    public static String[] getNombreTareas() {
    return nombreTareas;
            }
    public static String[] getEstadoTareas() {
    return estadoTareas;
}

    public static int[] getEquipoTareas() {
    return equipoTareas;
    }

    public static int getTotalTareas() {
    return totalTareas;
}


    
}

