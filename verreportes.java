public class verreportes {
        static String[] reportes = crearreporte.getreportes();
       static int totalreportes = crearreporte.gettotalreportes();
public static void main(String[] args) {

     System.out.println("\nLista de reportes");
        for (int i = 0; i < totalreportes; i++) {
            System.out.println(reportes[i]);
        }
    
}
    
}