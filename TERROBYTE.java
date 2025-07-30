import java.util.Scanner;

public class TERROBYTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1.- Crear Perfil");
            System.out.println("2.- Crear Usuario");
            System.out.println("3.- Crear Equipo");
            System.out.println("4.- Crear Proyecto");
            System.out.println("5.- Crear Tablero Kanban");
            System.out.println("6.- Salir del programa");
        
            opcion = sc.nextInt(); 
            sc.nextLine();

            switch(opcion){
                case 1 : 
                crearperfiles misperfiles = new crearperfiles();
                misperfiles.crearnuevoPerfil();
                    break;
                case 2: //crearusuario();
                    break;
                case 3 :// crearequipo();
                    break;
                case 4:
                crearproyecto miProyecto = new crearproyecto();
                    miProyecto.main(args);
                    break;
                case 5: //creartablero();
                    break;
                case 6: System.exit(0);
                    break;
            }
        } while (opcion != 6); //La condicion del bucle

        sc.close();
    }

    
}