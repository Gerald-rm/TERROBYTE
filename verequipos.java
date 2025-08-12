import java.util.List;

public class verequipos {

    public void mostrar() {
        List<List<String>> equipos = crearequipo.obtenerEquipos();
        List<String> nombres = crearequipo.Obtenernombres();

        System.out.println("\n======Equipos creados======");

        if (equipos.isEmpty()) {
            System.out.println("No hay equipos aun.\n");
            return;
        }

        for (int i = 0; i < equipos.size(); i++) {
         //System.out.println("Equipo #" +(i+1)+" "+ crearequipo.Obtenernombres()+ ":");
        System.out.println("Equipo #" + (i + 1) + " \"" + nombres.get(i) + "\":");

            List<String> miembros = equipos.get(i);
            for (String m : miembros) {
                System.out.println("- " + m);
            }

        }
    }
}