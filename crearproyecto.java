import java.util.Scanner;
import java.util.List;
public class crearproyecto {
public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
    System.out.println("ingresa el Nombre del proyecto");
    String Nombrepro = sc.nextLine();
    System.out.println("quieres asignar miembros?");
    System.out.println("1 = Si");
    System.out.println("2 = No");

    int opcion= sc.nextInt();

    if (opcion == 1) {
        List<String> perfilesDisponibles = crearperfiles.obtenerNombresPerfiles();
        for (int i = 0; i < perfilesDisponibles.size(); i++){
            System.out.println((i + 1) + ": " + perfilesDisponibles.get(i));
    
        }
        System.out.println("elije el miemrbo disponible de la siguiente lista: ");
        int miembroselect= sc.nextInt();
        // no me pregunten como solo se que funciona despues de ver videos de tryhard indios
        if (miembroselect > 0 && miembroselect <= perfilesDisponibles.size()){
            //para que en la lista este el uusuario que elijas
           String miembroasig = perfilesDisponibles.get(miembroselect - 1);
           //para coseguir un indice de la lista
           sc.nextLine();

            System.out.println("proyecto "+Nombrepro+" creado exitosamente");

           System.out.println("Miembro: "+miembroasig+" fue asignado");


        }else if(miembroselect==0){
            System.out.println("el numero no puede ser cero por que no esta en la lista");

        }
        else{
            System.out.println("hubo un error al asignar los miembros");
        }
        

        
    } else {
        System.out.println("no se asignara ninguno ps ;(");
    }


}
    
}