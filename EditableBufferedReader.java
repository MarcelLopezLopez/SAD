import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EditableBufferedReader extends BufferedReader {
    EditableBufferedReader(InputStreamReader in){
        super(in);
    }
    public void setRaw() throws IOException {

    }
    public void unsetRaw() throws IOException {

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
