import java.util.Scanner;


public class TERROBYTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String red = "\u001B[31m";
        String reset = "\u001B[0m";
        int opcion;
        System.out.println(red+" _________   _______    ________   ________   ________   ________       ___    ___  _________   _______          ");
        System.out.println("|\\___   ___\\|\\  ___ \\  |\\   __  \\ |\\   __  \\ |\\   __  \\ |\\   __  \\     |\\  \\  /  /||\\___   ___\\|\\  ___ \\         ");
        System.out.println("\\|___ \\  \\_|\\ \\   __/| \\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\|\\ /_    \\ \\  \\/  / /\\|___ \\  \\_|\\ \\   __/|        ");
        System.out.println("     \\ \\  \\  \\ \\  \\_|/__\\ \\   _  _\\\\ \\   _  _\\\\ \\  \\\\\\  \\\\ \\   __  \\    \\ \\    / /      \\ \\  \\  \\ \\  \\_|/__      ");
        System.out.println("      \\ \\  \\  \\ \\  \\_|\\ \\\\ \\  \\\\  \\|\\ \\  \\\\  \\|\\ \\  \\\\\\  \\\\ \\  \\|\\  \\    \\/  /  /        \\ \\  \\  \\ \\  \\_|\\ \\     ");
        System.out.println("       \\ \\__\\  \\ \\_______\\\\ \\__\\\\ _\\ \\ \\__\\\\ _\\ \\ \\_______\\\\ \\_______\\ __/  / /           \\ \\__\\  \\ \\_______\\    ");
        System.out.println("        \\|__|   \\|_______| \\|__|\\|__| \\|__|\\|__| \\|_______| \\|_______||\\___/ /             \\|__|   \\|_______|    ");
        System.out.println("                                                                      \\|___|/                                     ");
        System.out.println();
        System.out.println();
        System.out.println("   ___         _   ___   ___   ____ ___    __  ___  ______ ____ ___    __  ___");
        System.out.println("  / _ ) __ __ (_)  / _ \\ / _ \\ / __// _ |  /  |/  / /_  __// __// _ |  /  |/  /");
        System.out.println(" / _  |/ // /_    / // // , _// _/ / __ | / /|_/ /   / /  / _/ / __ | / /|_/ / ");
        System.out.println("/____/ \\_, /(_)  /____//_/|_|/___//_/ |_|/_/  /_/   /_/  /___//_/ |_|/_/  /_/  ");
        System.out.println("      /___/                                                                   "+reset);
        System.out.println("================================================================================================================================");
        System.out.print("Presiona 'Enter' para comenzar.");
        sc.nextLine();
        System.out.println("""
            TERROBYTE es un software dedicado a la gestion de tareas asi como su delegacion de actividades.
            El proposito inicial es que el administrador pueda facilitar la logica de una tarea para el usuario

            By: 
            - Vargas juarez Rafael Alejandro.
            - Gomez Camacho Karlo Gamaliel.   
            - Aguilar Garcia David Gerardo.
                """);

        do {
            System.out.println(" __________________________________");
            System.out.println("|            Inicio                |");
            System.out.println("|==================================|");
            System.out.println("|Ingrese un valor entre el 1-15    |");
            System.out.println("|==================================|");
            System.out.println("| 1.- Crear Perfil                 |");
            System.out.println("| 2.- Crear Equipo                 |");
            System.out.println("| 3.- Crear Proyecto               |");
            System.out.println("| 4.- Crear Tareas                 |");
            System.out.println("| 5.- Crear Reportes               |");
            System.out.println("| 6.- Ver Tareas                   |");
            System.out.println("| 7.- Avances de tareas            |");
            System.out.println("| 8.- Tablero Kanbam               |");
            System.out.println("| 9.- Ver Perfiles                 |");
            System.out.println("| 10.- Ver Equipos                 |");
            System.out.println("| 11.- Ver Proyectos               |");
            System.out.println("| 12.- Ver Reportes                |");
            System.out.println("| 13.- Manual de usuario           |");
            System.out.println("| 14.- cambiar sesion              |");
            System.out.println("| 15.- Salir del programa          |");
            System.out.println("|__________________________________|"); 

           
            boolean entradaValida;
            String entrada;
            opcion = -85;

            do {
            entradaValida = true;
            System.out.print("Seleccione una opcion: ");
            entrada = sc.nextLine();

            try {
            opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
            System.out.println("Escribe un numero");
            entradaValida = false;
            }
            } while (!entradaValida);

            System.out.println();


            switch(opcion){
                case 1 : 
                crearperfiles misperfiles = new crearperfiles();
                misperfiles.crearnuevoPerfil();
                    break;
                case 2: 
                crearequipo ce = new crearequipo();
                ce.crearGrupo();
                    break;
                case 3 :
                crearproyecto miProyecto = new crearproyecto();
                miProyecto.main(args);
                    break;
                case 4:
                creartareas lastareas = new creartareas();
                lastareas.main(args);
                    break;
                case 5: 
                crearreporte losreportes = new crearreporte();
                losreportes.main(args);
                    break;
                case 6:
                vertareas mitareas = new vertareas();
                mitareas.main();
                    break;
                case 7: 
                avancestareas avast = new avancestareas();
                avancestareas.modificarTarea();
                    break;
                case 8: 
                kanban tablero = new kanban();
                kanban.tablero();
                    break;
                    
                case 9:
                verperfiles vp = new verperfiles();
                vp.mostrar();
                    break;
                case 10:
                verequipos ve = new verequipos();
                ve.mostrar();
                    break;
               
                     case 11: 
                verproyectos vpo = new verproyectos();
                vpo.mostrarListadeproyectos();
                    break;
            
                    case 12:
                    verreportes lasreportes =new verreportes();
                    lasreportes.main(args);
                    break;

                    case 13:
                    Manual.main(new String[0]);
                    break;
                       case 14:
                    login ellogin =new login();
                    ellogin.main(args);
                    break;

                    case 15: 
                    GuardarDatos.guardarReporteCompleto();
                    System.exit(0);
                    break;
                             

                    default:
                    System.out.println("Opcion incorrecta. Ingrese un valor entre el 1-14");
                    break;
                }
    }
        while (opcion != 14); //La condicion del bucle

        sc.close();
    
}
}
