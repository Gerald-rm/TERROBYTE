import java.util.List;
import java.util.Scanner;
import java.util.Date;                 
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class creartareas {
static final int Maximodetareas = 50;
static String[] nombreTareas = new String[Maximodetareas];
static String[] estadoTareas = new String[Maximodetareas];
static int[] equipoTareas = new int[Maximodetareas];
static Date[] fechasEntrega = new Date[Maximodetareas];
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
        List<String> todosLosEquipos = crearequipo.Obtenernombres();

        for (int i = 0; i <todosLosEquipos.size(); i++) {
            System.out.println((i+1) + ". "+todosLosEquipos.get(i));
        }
        System.out.print("Asignar a equipo : ");
        equipoTareas[totalTareas] = sc.nextInt(); sc.nextLine();

        totalTareas++;
        System.out.println("Tarea creada correctamente.");
         System.out.print("La fecha de entrega es: (formato DD/MM/AAAA): ");
        String fechaTexto = sc.nextLine();
        
        try {
            // Define el formato que ingresa el usuario
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            // convierte el texto a un objeto Date
            Date fecha = formato.parse(fechaTexto);
            // guarda el objeto dato en creartareas
            fechasEntrega[totalTareas] = fecha;
             //try hace que este bloque devuelva un error si se ingresa un formato invalido

        } catch (ParseException e) {
            System.out.println("Formato de fecha invalido, se asignara la fecha actual");
            fechasEntrega[totalTareas] = new Date();
             //catch solo ejecuta este bloque si atrapa el error proporcionado por 'try' y devuelve el error por el formato de fecha
        }

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

