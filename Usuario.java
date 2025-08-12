import java.util.Scanner;

public class Usuario {
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
        
                """);

        do {
            System.out.println("\n=============Inicio=============");
            System.out.println("1.- Ver Tareas");
            System.out.println("2.- Avances de tareas");
            System.out.println("3.- Tablero Kanbam");
            System.out.println("4.- Ver Perfiles");
            System.out.println("5.- Ver Equipos");
            System.out.println("6.- Ver Proyectos");
            System.out.println("7.- Salir del programa");
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
                case 1:
                vertareas mitareas = new vertareas();
                mitareas.main();
                    break;
                case 2: 
                avancestareas avast = new avancestareas();
                avancestareas.modificarTarea();
                    break;
                case 3: 
                kanban tablero = new kanban();
                kanban.tablero();
                    break;
                    
                case 4:
                verperfiles vp = new verperfiles();
                vp.mostrar();
                    break;
                case 5:
                verequipos ve = new verequipos();
                ve.mostrar();
                    break;
               
                     case 6: 
                verproyectos vpo = new verproyectos();
                vpo.mostrarListadeproyectos();
                    break;

                    case 7: 
                System.exit(0);
                    break;

                    default:
                    System.out.println("Opcion incorrecta. Ingrese un valor entre el 1-7");
                    break;
                }
    }
        while (opcion != 7); //La condicion del bucle

        sc.close();
    
}
}

        
    
