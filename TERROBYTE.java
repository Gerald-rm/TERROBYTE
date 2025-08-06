import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
        System.out.println("Presiona 'Enter' para comenzar.");
        sc.nextLine();

        do {
            System.out.println("\n=============Inicio=============");
            System.out.println("1.- Crear Perfil");
            System.out.println("2.- Crear Equipo");
            System.out.println("3.- Crear Proyecto");
            System.out.println("4.- Ver Tareas");
            System.out.println("5.- Mantenimiento de Teportes");
            System.out.println("6.- Crear Tareas");
            System.out.println("7.- Avances de tareas");
            System.out.println("8.- Tablero Kanbam");
            System.out.println("9.- Ver Perfiles");
            System.out.println("10.- Ver Equipos");
            System.out.println("11.- Ver Proyectos");
            System.out.println("11.- Salir del programa");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt(); 
            System.out.println();
            sc.nextLine();

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
                case 4:vertareas mitareas = new vertareas();
                mitareas.main();
                    break;
                case 5: //reportes
                    break;
                case 6:
                creartareas lastareas = new creartareas();
                lastareas.main(args);
                    break;
                case 7: 
                avancestareas avast = new avancestareas();
                avancestareas.modificarTarea();
                    break;
                case 8: 
                kanban tablero = new kanban();
                kanban.mostrarTablero();
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
                vpo.mostrarListaDeProyectos();
                    break;

                     case 12: 
                System.exit(0);
                    break;
                }
    }
        while (opcion != 12); //La condicion del bucle

        sc.close();
    
}
}
