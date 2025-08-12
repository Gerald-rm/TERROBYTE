import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LogSetup {
    private LogSetup() {}

    // porFecha=false => siempre logs/salida.txt
    // porFecha=true  => logs/salida-YYYY-MM-DD_HH-mm-ss.txt
    public static void init(String baseName, boolean porFecha) {
        try {
            File dir = new File("logs");
            if (!dir.exists()) dir.mkdirs();

            String fileName = porFecha
                ? baseName + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".txt"
                : baseName + ".txt";

            File file = new File(dir, fileName);
            PrintStream archivo = new PrintStream(new FileOutputStream(file, true), true, StandardCharsets.UTF_8);

            PrintStream consola = System.out; // conserva consola
            System.setOut(new PrintStream(new MultiOutputStream(consola, archivo), true, StandardCharsets.UTF_8));
            System.setErr(new PrintStream(new MultiOutputStream(consola, archivo), true, StandardCharsets.UTF_8));

            System.out.println("=== LOG iniciado: " + file.getAbsolutePath() + " ===");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MultiOutputStream extends OutputStream {
    private final OutputStream[] outs;
    MultiOutputStream(OutputStream... outs) { this.outs = outs; }

    @Override public void write(int b) throws IOException { for (var o: outs) o.write(b); }
    @Override public void write(byte[] b, int off, int len) throws IOException { for (var o: outs) o.write(b, off, len); }
    @Override public void flush() throws IOException { for (var o: outs) o.flush(); }
    @Override public void close() throws IOException { for (var o: outs) o.close(); }
}
