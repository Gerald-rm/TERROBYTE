import java.util.ArrayList;
import java.util.List; // se ocupa para importar la lista
import java.util.Scanner;

public class crearperfiles {
    
    // se ocupa estatic para que se pueda compartir con las demas clases
    private static List<String> nombresPerfilesCreados = new ArrayList<>();

    // esta funcion es para crear el perfil, se supone que es mas facil para compartir con otras clases
    public void crearnuevoPerfil() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa tu apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Ingresa tu correo electronico: ");
        String correo = sc.nextLine();
        sc.nextLine();
        String nombreCompleto = nombre + " " + apellido;
        nombresPerfilesCreados.add(nombreCompleto); // añade el nuevo perfil a la lista

        System.out.println("\nperfil creado exitosamente:");
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Correo: " + correo);
    }

    // este metodo permite el acceso a la lista
    public static List<String> obtenerNombresPerfiles() {
        return nombresPerfilesCreados;
    }

    public void main(String[] args) {
        // nose que es, el visual me lo genero
        throw new UnsupportedOperationException("Unimplemented method 'main'");
    }
}