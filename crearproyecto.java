import java.util.Scanner;
import java.util.List;
public class crearproyecto {
    static int Maximodeproyectos=50;
    static String[] nombreproyecto = new String[Maximodeproyectos];
    static String[] equipoasig = new String[Maximodeproyectos];
    static int totalproyectos =0;
    static List<String> nombres = crearequipo.Obtenernombres();


     // Proyectos predeterminados
    static {
        // Proyecto 1
        nombreproyecto[totalproyectos] = "Pasar Con teacher Emer";
        equipoasig[totalproyectos] = nombres.get(0);
        totalproyectos++;

        // Proyecto 2
        nombreproyecto[totalproyectos] = "Pasar Ingles";
        equipoasig[totalproyectos] = nombres.get(1);
        totalproyectos++;
    }
public static void main(String[] args) {

    
    Scanner sc = new Scanner(System.in);

    System.out.println("\n=======Crear Proyecto========");
    if (totalproyectos >= Maximodeproyectos) {
        System.out.println("Se alcanzo el limite de protectos");
        return;
        
    }    
    System.out.println("Ingresa el Nombre del proyecto a crear");
    nombreproyecto[totalproyectos]=sc.nextLine();


    
    System.out.println("Quieres asignar equipos?");
    int opcion = -666;
    boolean entradaValida = false;
    do {
        System.out.println("1 = Sí");
        System.out.println("2 = No");
        String entrada = sc.nextLine();
        try {
            opcion = Integer.parseInt(entrada);
            if (opcion == 1 || opcion == 2) {
                entradaValida = true;
            } else {
                System.out.println("Solo puedes ingresar 1 o 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Solo numeros.");
        }
    } while (!entradaValida);
    System.out.println("==============================================");
        if (opcion == 1) {
        List<String> equiposDisponibles = crearequipo.Obtenernombres();
        for (int i = 0; i < equiposDisponibles.size(); i++) {
            System.out.println((i + 1) + ": " + equiposDisponibles.get(i));
        }

        int equiposelect = -1;
        boolean equipoValido = false;
        
        while (!equipoValido) {
            System.out.println("Elige el numero del equipo disponible para asignarlo al proyecto:");
            try {
                equiposelect = Integer.parseInt(sc.nextLine());
                if (equiposelect > 0 && equiposelect <= equiposDisponibles.size()) {
                    equipoasig[totalproyectos] = equiposDisponibles.get(equiposelect - 1);
                    equipoValido = true; // Salir del bucle si la opción es válida
                    System.out.println("Equipo asignado: " + equipoasig[totalproyectos]);
                } else {
                    System.out.println("Numero de equipo inválido. Ingresa un número entre 1 y " + equiposDisponibles.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un numero valido.");
            }
        }

        System.out.println("Proyecto " + nombreproyecto[totalproyectos] + " creado exitosamente.");
        System.out.println("Equipo: " + equipoasig[totalproyectos] + " fue asignado");
    } else {
        equipoasig[totalproyectos] = "Sin equipo";
        System.out.println("No se asignara equipo.");
    }

            
    
    totalproyectos++;


}

public static String[] getnombreproyecto() {
    return nombreproyecto;
}
//funcion para obtener nombre de proyecto lol

 public static int getTotalProyectos() {
        return totalproyectos;
    }
    public static String[] getEquipoAsignado() {
    return equipoasig;
}

    
}
