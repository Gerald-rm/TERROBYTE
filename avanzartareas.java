import java.util.Scanner;

public class avanzartareas {
static final int Maximodetareas = 50;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
    String[] nombreTareas = new String[Maximodetareas];
    String[] estadoTareas = new String[Maximodetareas];
    int[] equipoTareas = new int[Maximodetareas];
    int totalTareas = 0;
    if (totalTareas <= Maximodetareas) {
        System.out.println("Haz alcanzado el limite de tareas.");
        
    }
    System.out.println("Ingresa el Nombre de la tarea: ");
    nombreTareas[totalTareas]= sc.nextLine();
    System.out.println("Ingresa el estado de la Tarea (ej: Pendiente, En Proceso, Terminado)");
    estadoTareas[totalTareas]=sc.nextLine();
    System.out.println("Equipos disponibles:");
        for (int i = 0; i <; i++) {
            System.out.println(i + ". " [i]);
        }
        System.out.print("Asignar a equipo (índice): ");
        equipoTareas[totalTareas] = sc.nextInt(); sc.nextLine();

        totalTareas++;
        System.out.println("Tarea creada correctamente.");
    }
    }

