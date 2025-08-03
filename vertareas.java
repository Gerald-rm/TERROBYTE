import java.util.ArrayList;
import java.util.Arrays;
public class vertareas {
    public static void main() {
        String[] nombres = creartareas.getNombreTareas();
        String[] estados = creartareas.getEstadoTareas();
        int[] equipos = creartareas.getEquipoTareas();
int total = creartareas.getTotalTareas();

        if (total ==0) {
            System.out.println("No hay ninguna tarea registrada.");
            
        } else{
            for(int i=0; i<total; i++){
            System.out.println( "ID de Tareas: "+i + " // tarea: "+(i+1)+": "+nombres[i]+" // Estado: "+estados[i]+" // Equipo asignao: "+equipos[(i+1)]);
            //agregue ID a las tareas para facilitarme la vida -Karro
            }
            
        }
    }
}
