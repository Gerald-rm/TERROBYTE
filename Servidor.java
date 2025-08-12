import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en puerto " + puerto + "...");

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado desde " + cliente.getInetAddress());

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(cliente.getInputStream())
                );

                try (PrintWriter archivo = new PrintWriter(new FileWriter("respuestas.txt", true))) {
                    archivo.println("===== Nueva sesión =====");
                    String linea;
                    while ((linea = entrada.readLine()) != null && !linea.isEmpty()) {
                        archivo.println(linea);
                    }
                    archivo.println();
                }

                cliente.close();
                System.out.println("Datos guardados correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}