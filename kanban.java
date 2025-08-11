import java.util.Date;
//para las fechas que voy a robar
import java.util.List;
//para consultar la lista de nombres que david hizo
import java.text.SimpleDateFormat;
//para poder asignarle el formato a la fecha xd
import java.lang.Math;
//sirve para hacer operaciones matematicas
//solo se uso el max, el cual encuentra el valor mas alto entre dos numeros lol

public class kanban{
    public static void tablero() {
        
    
    //aqui se hace la consulta de datos de las demas clases
    int todastareas = creartareas.getTotalTareas();
    String[] nombres = creartareas.getNombreTareas();
    String[] estados = creartareas.getEstadoTareas();
    int[] indice=creartareas.getmiembrosTareas();
    Date[] fechas = creartareas.getFechasTareas();
    List<String> lista = crearperfiles.obtenerNombresPerfiles();

    int pendiente=0;
    int enproceso=0;
    int terminada=0;
    //declaracion de contadores
    for(int i =0;i<todastareas;i++){
        String estado = estados[i];
        //se hace consulta de estados
        if (estado.equalsIgnoreCase("Pendiente")) pendiente++;
        else if (estado.equalsIgnoreCase("En Proceso") || estado.equalsIgnoreCase("Proceso")) enproceso++;
        else if (estado.equalsIgnoreCase("Terminado")) terminada++;
        //aqui se usa el equalsignorecase para hacer que los estados se agreguen sin importar como fue que
        //el usuario ingresase el estado en la clase creartareas, osea minusculas o mayusculas
        //tambien usamos los contadores para acumular los estados que coinciden con los criterios previamente establecidos
    }
    int maxi = Math.max(pendiente,Math.max(enproceso,terminada));
    //en base al estado que mas se repita determina la altura del tablero, .max compara la cantidad de estados
    int columna = 3;
    //aqui determino cuantas columnas horizontales quiero que mi tablero tenga lol, el conteo empieza desde el cero aparentemente

    String [][] tabla = new String[maxi][columna];
    //aqui se crea la matriz xd

    int columnapendiente = 0;
    int columnaproceso = 0;
    int columnaterminada = 0;
    //contador para hacer las comparaciones

    for (int i = 0; i <todastareas;i++){
        String nombreMiembro = "No hay miembros";
        int miembros = indice[i]-1;
        //creo que se resta porque esta empezaba en cero
        if (miembros >= 0 && miembros <lista.size()){
            nombreMiembro = lista.get(miembros);
            //consulta a los miembros a los que se les asigno una tarea, el if se ejecuta si hay por lo menos un miembro y si hay por lo menos un miembro al que se la asigno la tarea
            //de otra forma solo imprime 'no hay miembros'
        }
        String fecha = (fechas[i]!=null) ? new SimpleDateFormat("dd-MM-yyyy").format(fechas[i]):"Sin fecha";
        //consulta las fechas asignadas a las tareas y les da el formato ej:2005-09-25
        //si a la tarea no se le asigno ninguna fecha (null), simplemente imprime "Sin fecha" ('?' es como un if-else xd, los dos puntos se usan para separar los condicionales)
        String plantilla = String.format("%s, Miembro: %s, Entrega: %s", nombres[i],nombreMiembro,fecha);
        //'%s' es en donde se van a ubicar los strings a los que se les va a aplicar el formato
        String estado = estados[i];
        if (estado.equalsIgnoreCase("Pendiente")) {
            tabla[columnapendiente][0] = plantilla;
            columnapendiente++;
        } else if (estado.equalsIgnoreCase("En Proceso") || estado.equalsIgnoreCase("Proceso")) {
            tabla[columnaproceso][1] = plantilla;
            columnaproceso++;
        } else if (estado.equalsIgnoreCase("Terminado")){
            tabla[columnaterminada][2] = plantilla;
            columnaterminada++;
            // en teoria los acumuladores asignan a una tarea del mismo estado debajo de esta misma
            //el numero dentro de los corchetes indica la columna que se le asigno a dicho estado, empiezan desde cero, por ej 'Pendiente' pertenece a la columna 1, 
        }
    }

    String formato = "| %-60s | %-60s | %60s |\n";
    //se le asignan 60 caracteres de espacio entre string xd
    System.out.println("\n=========================================================================================== Kanban ===========================================================================================");
    //le spam signo igual xd
    System.out.printf(formato,"Pendiente","En Proceso","Terminado");
    //printf: impresion con fossrmato lol
    //pstt: no me pidan que le ponga 'Por hacer', 'En p4rogreso' y 'Hecho', literalmente son sinonimos y tambien tendrian que modificar las demas clases solo para eso
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    for (int i =0; i<maxi;i++){
        String columna1 = (tabla[i][0]!=null) ? tabla[i][0]:"";
        //bascamente nos dice que la tabla empieza en la posicion '0' y avanza a partir de ahi, si en esa posicion no hay nada, solo imprime algo vacio
        //se repite la misma logica para las demas columnas xd
        //pstt: no David, no voy a hacer un if para que no imprima absolutamente nada, que hueva.
        String columna2 = (tabla[i][1]!=null) ? tabla[i][1]:"";
        String columna3 = (tabla[i][2]!=null) ? tabla[i][2]:"";

        System.out.printf(formato,columna1,columna2,columna3);
        //la logica es la siguiente: se ingresa la variable que contiene el formato con el que se va a imprimir,
        //luego se agregan las variables a las que se les va a aplicar el formato y ya
    }
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

}
}