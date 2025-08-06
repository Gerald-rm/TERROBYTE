import java.util.List;
import java.util.Scanner;
import java.util.Date;                 
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class creartareas {
static final int Maximodetareas = 50;
static String[] nombreTareas = new String[Maximodetareas];
static String[] estadoTareas = new String[Maximodetareas];
static int[] miembrosTareas = new int[Maximodetareas];
static Date[] fechasEntrega = new Date[Maximodetareas];
static int totalTareas = 0;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

    if (totalTareas >= Maximodetareas) {
        System.out.println("Haz alcanzado el limite de tareas.");
        return;
    }
   
    System.out.println("Ingresa el Nombre de la tarea: ");
    nombreTareas[totalTareas]= sc.nextLine();
    System.out.println("Ingresa el estado de la Tarea (ej: Pendiente, En Proceso, Terminado)");
    estadoTareas[totalTareas]=sc.nextLine();

    System.out.println("Miembros disponibles:");
        List<String> todosLosMiembros = crearperfiles.obtenerNombresPerfiles();

        for (int i = 0; i <todosLosMiembros.size(); i++) {
            System.out.println((i+1) + ". "+todosLosMiembros.get(i));
        }
        System.out.print("Asignar a miembro (índice): ");
        miembrosTareas[totalTareas] = sc.nextInt(); 
        sc.nextLine();
        
        System.out.print("Ingrese la fecha de entrega: (formato DD/MM/AAAA): ");

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
         System.out.println("Tarea creada correctamente.");

        SimpleDateFormat formatolimpio = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("La fecha de entrega asignada es: " + formatolimpio.format(fechasEntrega[totalTareas]));
        //sirve para darle formato a la fecha para que esta sea legible

        totalTareas++;
        //Al momento de agregar algun parametro es importante recorrer el acumulador hasta al final para que este almacene los datos correctamente
    }

    

    public static String[] getNombreTareas() {
    return nombreTareas;
            }
    public static String[] getEstadoTareas() {
    return estadoTareas;
}

    public static int[] getmiembrosTareas() {
    return miembrosTareas;
    }

    public static int getTotalTareas() {
    return totalTareas;
}


    
}

