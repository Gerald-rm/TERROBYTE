import java.util.ArrayList;
import java.util.Arrays;
public class vertareas {
    public static void main() {

        System.out.println("\n=====Ver Tareas=====");

        String[] nombres = creartareas.getNombreTareas();
        String[] estados = creartareas.getEstadoTareas();
        int[] miembros = creartareas.getmiembrosTareas();
int total = creartareas.getTotalTareas();

        if (total ==0) {
            System.out.println("No hay ninguna tarea registrada.");
            
        } else{
            for(int i=0; i<total; i++){

            System.out.println( "ID de Tareas: "+i+ " // tarea: "+(i+1)+": "+nombres[i]+" // Estado: "+estados[i]+" // Miembro asignado: "+miembros[i]);

            //agregue ID a las tareas para facilitarme la vida -Karro
            }
            
        }
    }
}
