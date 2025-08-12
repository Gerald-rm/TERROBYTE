import java.util.ArrayList;
import java.util.List; // se ocupa para importar la lista
import java.util.Scanner;

public class crearperfiles {
    
    // se ocupa estatic para que se pueda compartir con las demas clases
    private static List<String> nombresPerfilesCreados = new ArrayList<>();

    private static List<String> nombreYCorreos =new ArrayList<>();
    
  static {
        nombresPerfilesCreados.add("Pinto GPT");
        nombresPerfilesCreados.add("Navy Lara");
        nombresPerfilesCreados.add("Eduardo Tulane");

    }
    // esta funcion es para crear el perfil, se supone que es mas facil para compartir con otras clases
    public void crearnuevoPerfil() {
        Scanner sc = new Scanner(System.in);

        String nombreCompleto;

        System.out.println("\n=====Crear Perfiles=====");

        String nombre;//validar nombre
        while (true) {
            System.out.print("Ingresa tu nombre: ");
            nombre = sc.nextLine().trim();
            if (nombre.matches("[abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZáéíóúÁÉÍÓÚñÑ ]+")) {
                break;
            } else {
                System.out.println("Nombre invalido. Solo se permiten letras y espacios.");
            }
        }

        String apellido;//validar apellido
        while (true) {
            System.out.print("Ingresa tu apellido: ");
            apellido = sc.nextLine().trim();
            if (apellido.matches("[abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZáéíóúÁÉÍÓÚñÑ ]+")) {
                break;
            } else {
                System.out.println("Apellido Invalido. Solo se permiten letras y espacis.");
            }
        }

        String correo;//validar correo
        String [] dominiosP = {"@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@ut-tijuana.edu.mx"};
        while (true) {
            System.out.print("Ingrese tu correo: ");
            correo = sc.nextLine().trim();

            boolean terminaCorrecto = false;
            for (String dominio : dominiosP) {
                if (correo.endsWith(dominio)) {
                    terminaCorrecto = true;
                    break;
                }
            }
            if (!terminaCorrecto) {
                System.out.println("Correo invalido. Debe terminar con @gmail.com, @hotmail.com, @outlook, @yahoo.com o ut-tijuana.edu.mx");
                continue;
            }
            if (correo.indexOf('@') > 0 && !correo.contains(" ")) {
                break;
            } else {
                System.out.println("Correo invalido. Formato incorrecto.");
            }
        }


        nombreCompleto = nombre + " " + apellido;
        String nomApllCorreo = nombre + " " + apellido + " \nCorreo: " + correo;
        nombresPerfilesCreados.add(nombreCompleto); // añade el nuevo perfil a la lista
        nombreYCorreos.add(nomApllCorreo);//anade el nombre completo y el correo

        System.out.println("\nperfil creado exitosamente:");
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Correo: " + correo+"\n");
        System.out.print("Presione Enter para continuar");
        sc.nextLine();
    }

    // este metodo permite el acceso a la lista
    public static List<String> obtenerNombresPerfiles() {
        return nombresPerfilesCreados;
    }
    public static List<String> nombreCorreos() {
        return nombreYCorreos;
    }
    public void main(String[] args) {
        // nose que es, el visual me lo genero
        throw new UnsupportedOperationException("Unimplemented method 'main'");
    }
}