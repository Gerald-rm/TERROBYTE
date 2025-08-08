import java.util.Scanner;
import java.util.List;
public class crearproyecto {
    static int Maximodeproyectos=50;
    static String[] nombreproyecto = new String[Maximodeproyectos];
    static int totalproyectos =0;
public static void main(String[] args) {

    
    Scanner sc = new Scanner(System.in);
    if (totalproyectos >= Maximodeproyectos) {
        System.out.println("Se alcanzo el limite de protectos");
        
    }    
    System.out.println("Ingresa el Nombre del proyecto");
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
    if (opcion == 1) {
        List<String> equiposDisponibles = crearequipo.Obtenernombres();
        for (int i = 0; i < equiposDisponibles.size(); i++){
            System.out.println((i + 1) + ": " + equiposDisponibles.get(i));
    
        }
        
        System.out.println();

        System.out.println("Elije el equipo disponible de la siguiente lista: ");
        int equiposelect= sc.nextInt();

        // no me pregunten como solo se que funciona despues de ver videos de tryhard indios
        if (equiposelect > 0 && equiposelect <= equiposDisponibles.size()){
            //para que en la lista este el uusuario que elijas
           String equipoasig = equiposDisponibles.get(equiposelect - 1);
           //para coseguir un indice de la lista
           sc.nextLine();


            System.out.println("Proyecto "+nombreproyecto[totalproyectos]+" creado exitosamente");


           System.out.println("Equipo: "+equipoasig+" fue asignado");


        }else if(equiposelect==0){
            System.out.println("El numero no puede ser cero por que no esta en la lista");

        }
        else{
            System.out.println("Hubo un error al asignar el equipo.");
        }
        

        
    } else {
        System.out.println("No se asignara ninguno ps ;(");
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
    
}