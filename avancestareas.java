 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Scanner;
 import java.util.Date;                 


public class avancestareas {
    
    public static void modificarTarea() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=====Avance De Tareas=====");

        if (creartareas.totalTareas == 0) {
            System.out.println("No hay tareas para modificar \n");
            return; //retorna al menu si no hay tareas lol
        }

        System.out.println("Modificar Tarea");
                vertareas.main();
                //asigne IDs a las tareas para no complicarme
        int indice = -28888;
        boolean entradaValida = false;
        do {
            System.out.print("Ingrese el indice (ID) de la tarea a modificar: ");
            String entrada = sc.nextLine();
            try {
                indice = Integer.parseInt(entrada);
                if (indice >= 0 && indice < creartareas.totalTareas) {
                    entradaValida = true;
                } else {
                    System.out.println("El ID no se encuentra en la lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número.");
            }
        } while (!entradaValida);

        
        if (indice < 0 || indice >= creartareas.totalTareas) {
            System.out.println("Error: Indice no valido\n");
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
       int binario = -1;
        boolean entradavalida = false;

        do {
            System.out.println("Desea asignar otro miembro a la tarea?");
            System.out.println("Ingrese '1' para cambiar");
            System.out.println("Ingrese '2' para omitir");
            String entrada = sc.nextLine();

            try {
                binario = Integer.parseInt(entrada);
                if (binario == 1 || binario == 2) {
                    entradavalida = true;
                } else {
                    System.out.println("Solo puedes ingresar 1 o 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Solo numeros.");
            }
        } while (!entradavalida);

        if (binario == 1) {
           verperfiles vp = new verperfiles();
            vp.mostrar();
            System.out.println("==============================");
          //aqui accede a las listas de los miembros

        System.out.println("Asigne a los miembros por numero de indice:");
            int nuevomiembro = -1;
        entradaValida = false;
        do {
            System.out.print("Asignar a miembro : ");
            String entrada = sc.nextLine();
            try {
                nuevomiembro = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Solo numeros.");
            }
        } while (!entradaValida);
        creartareas.miembrosTareas[indice] = nuevomiembro;

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
                System.out.println("Formato de fecha invalido. La fecha no se modifico.\n");
                 //catch solo ejecuta este bloque si atrapa el error proporcionado por 'try' y devuelve el error por el formato de fecha
            }
        }
        System.out.println("Tarea actualizada\n");
    }

    
}
