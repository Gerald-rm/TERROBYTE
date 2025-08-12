import java.util.Scanner;

public class crearreporte {

    static int maximor = 50;
    static String[] reportes = new String[maximor];
    static int totalreportes = 0;

    public static void main(String[] args) {
        int indice = -1;
        boolean entradaValida = false;
        Scanner sc = new Scanner(System.in);
        String[] nombres = crearproyecto.getnombreproyecto();
        int total = crearproyecto.getTotalProyectos();

        if (total == 0) {
            System.out.println("no hay proyecto para asignar algun reporte");
            return;

        }
        System.out.println("Listado de proyectos: ");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ":" + nombres[i]);
        }

        do {
            System.out.print("Selecciona un numero de proyecto: ");
            String entrada = sc.nextLine();

            try {
                indice = Integer.parseInt(entrada);  // para convertir la entrada al indice
                if (indice < 1 || indice > total) {
                    System.out.println("No se va a poder padrino, te pasaste");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero.");
            }
        } while (!entradaValida);
         

        System.out.println("Ingresa el reporte para el proyecto " + nombres[indice-1]);
        String reporte = sc.nextLine();

        if (totalreportes < maximor) {
            reportes[totalreportes] = "Reporte para " + nombres[indice-1] + ": " + reporte;
            totalreportes++;
            System.out.println("El reporte se creo correctamente");
        } else {
            System.out.println("Se arrebaso el limite de reportes");
        }

        // Para ver todos los reportes
        System.out.println("\nLista de reportes");
        for (int i = 0; i < totalreportes; i++) {
            System.out.println(reportes[i]);
        }
    
    }
    public static String[] getreportes(){
        return reportes;
    }
    public static int gettotalreportes(){
        return totalreportes;
    }
}
