import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "127.0.0.1";
        int puerto = 5000;
        
        try (Socket socket = new Socket(servidorIP, puerto)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            login.main(new String[0]);
            

            System.out.println("Datos enviados. Gracias.");
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}