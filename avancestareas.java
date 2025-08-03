 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.List;
 import java.util.Scanner;
 import java.util.Date;                 
import java.text.SimpleDateFormat;
public class avancestareas {
    
    public static void modificarTarea() {
        Scanner sc = new Scanner(System.in);
        if (creartareas.totalTareas == 0) {
            System.out.println("No hay tareas para modificar");
            return; //retorna al menu si no hay tareas lol
        }

        System.out.println("Modificar Tarea");
                vertareas.main();
                //asigne IDs a las tareas para no complicarme
        System.out.println("Equipos Disponibles: ");
          List<List<String>> todosLosEquipos = crearequipo.obtenerEquipos();
          //aqui accede a las listas de los equipos
        
        System.out.print("Ingrese el indice (ID) de la tarea a modificar: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice < 0 || indice >= creartareas.totalTareas) {
            System.out.println("Error: Indice no valido");
            return;
        }
        
        System.out.print("Ingrese el nuevo nombre (deja en blanco para no cambiar): ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.isEmpty()) {
            creartareas.nombreTareas[indice] = nuevoNombre;
             // Modifica el array nombretareas de creartareas
        }

        System.out.print("Ingrese el nuevo estado (deja en blanco para no cambiar): ");
        String nuevoEstado = sc.nextLine();
        if (!nuevoEstado.isEmpty()) {
            creartareas.estadoTareas[indice] = nuevoEstado;
             // Modifica el array nombretareas de creartareas
        }
        System.out.println("Desea asignar otro equipo a la tarea?");
        System.out.println("Ingrese '1' para cambiar");
        System.out.println("Ingrese '2' para omitir");
        int binario = sc.nextInt();
        sc.nextLine();
        if(binario==1) { 
        System.out.println("Asignar a equipo por indice (deje en blanco para no cambiar): ");
            int nuevoEquipo = sc.nextInt();
            sc.nextLine();
            creartareas.equipoTareas[indice] = nuevoEquipo;
        }


        System.out.print("¿Deseas modificar la fecha de entrega? (s/n): ");
        String respuesta = sc.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingresa la nueva fecha de entrega (formato DD/MM/AAAA): ");
            String fechaTexto = sc.nextLine();
            
            
           
            try {
                //Define el formato y convierte el texto al formato de fecha
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date nuevaFecha = formato.parse(fechaTexto);
                //Actualiza el array de fechas en la posición correcta
                creartareas.fechasEntrega[indice] = nuevaFecha;
               //try hace que este bloque devuelva un error si se ingresa un formato invalido

            } catch (ParseException e) {
                System.out.println("Formato de fecha invalido. La fecha no se modifico.");
                 //catch solo ejecuta este bloque si atrapa el error proporcionado por 'try' y devuelve el error por el formato de fecha
            }
        }
        System.out.println("Tarea actualizada");
    }

    
}
