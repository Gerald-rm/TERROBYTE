public class verproyectos {

public static void mostrarListadeproyectos() {
        
        String[] nombres = crearproyecto.getnombreproyecto();
        int total = crearproyecto.getTotalProyectos();

        System.out.println("\n=====Ver Proyectos=====");

        //revisa si hay proyectos que mostrar
        if (total == 0) {
            System.out.println("No hay proyectos creados");
            return; 
        }

        //Recorre el array y muestra cada proyecto
        for (int i = 0; i < total; i++) {
            System.out.println("Proyecto: " + nombres[i]);
        }

    }
}