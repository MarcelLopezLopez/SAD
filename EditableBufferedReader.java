import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EditableBufferedReader extends BufferedReader {

    static final int DRETA
    static final int ESQUERRA
    static final int INICI
    static final int FINAL
    static final int DELETE //Borrar esquerra
    static final int SUPRIMIR //Borrar dreta
    static final int INSERT

    EditableBufferedReader(InputStreamReader in){
        super(in);
    }
    public void setRaw() throws IOException {
        //Passar de mode Cooked a mode Raw
        //String amb la seqüència necessaria per canviar de mode Cooked a mode Raw al terminal
        String [] modeRaw = {"/bin/sh", "-c", "stty raw </dev/tty"};
        try {
            //getRuntime().exec() serveix per poder executar la linea de comandes
            //waitFor() espera hasta que el subproceso termine
            Runtime.getRuntime().exec(modeRaw).waitFor();  
        }catch (Exception e) {
            //Comuniquem l'error
            System.out.println("Error");
        } 
    }
    public void unsetRaw() throws IOException {
        //Passar de mode Cooked a mode Raw
        //String amb la seqüència necessaria per canviar de mode Raw a mode Cooked al terminal
        String[] modeCooked = {"/bin/sh", "-c", "stty cooked <dev/tty"};
        try{
            //getRuntime().exec() serveix per poder executar la linea de comandes
            //waitFor() espera hasta que el subproceso termine
            Runtime.getRuntime().exec(modeCooked).waitFor();
        } catch (IOException | InterruptedException e){
            //Comuniquem l'error
            System.out.println("Error");
        }
    }

    public int read() throws IOException {
        int lectura = 0;
        return lectura;
    }
    public String readLine() throws IOException {
        String linea = null;
        return linea;
    }
}
