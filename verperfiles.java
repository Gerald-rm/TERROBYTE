import java.util.List;

public class verperfiles {
    public void mostrar() {
        List<String> perfiles = crearperfiles.nombreCorreos();

        System.out.println("\n=====Lista de Perfiles=====");
        if (perfiles == null || perfiles.isEmpty()) {
            System.out.println("No hay perfiles.");
        } else {
            for (int i = 0; i < perfiles.size(); i++) {
                System.out.println((i + 1) + ". " + perfiles.get(i));
            }
        }
    }
}