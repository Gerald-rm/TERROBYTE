import java.util.Scanner;

public class login {
    private static final String USUARIO ="admin";
    private static final String PASS = "admin123";

    public static void main(String[] args) {
        LogSetup.init("salida", false); // crea logs/salida.txt y guarda todo

        Scanner sc = new Scanner(System.in);

        System.out.println("========Inicio de Sesion========\n");

        int eleccion;
        
        do {
            System.out.print("Quieres iniciar como usuario(1) o admin(2)? ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingresa 1 o 2: ");
                sc.next();
            }
            eleccion = sc.nextInt();
            sc.nextLine(); 
        } while (eleccion != 1 && eleccion != 2);

        if (eleccion == 1) {
            System.out.println("Entrando como USUARIO...");
            Usuario.main(new String[0]);
        } else if (eleccion == 2) {
            String azul = "\u001B[94m";
            String reset = "\u001B[0m";
            System.out.println(azul +
                "    _    ____  __  __ ___ _   _      _     ___   ____ ___ _   _ \n" +
                "   / \\  |  _ \\|  \\/  |_ _| \\ | |    | |   / _ \\ / ___|_ _| \\ | |\n" +
                "  / _ \\ | | | | |\\/| || ||  \\| |    | |  | | | | |  _ | ||  \\| |\n" +
                " / ___ \\| |_| | |  | || || |\\  |    | |__| |_| | |_| || || |\\  |\n" +
                "/_/   \\_\\____/|_|  |_|___|_| \\_|    |_____\\___/ \\____|___|_| \\_|\n" +
                reset);

    
            boolean paso;
            do {
                System.out.print("Ingresa tu Usuario: ");
                String usuario = sc.nextLine().trim();

                System.out.print("Ingresa tu Contraseña: ");
                String contra = sc.nextLine();

                paso = USUARIO.equals(usuario) && PASS.equals(contra);

                if (!paso) {
                    System.out.println("Credenciales inválidas, inténtalo de nuevo.\n");
                }
            } while (!paso);

            System.out.println("Login Correcto. Entrando al sistema...");
            TERROBYTE.main(new String[0]);
        }

    }
}

