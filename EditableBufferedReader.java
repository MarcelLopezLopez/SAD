import java.io.BufferedReader;
import java.io.InputStreamReader;

class EditableBufferedReader extends BufferedReader {
    EditableBufferedReader(InputStreamReader in){
        super(in);
    }
    public void setRaw(){

    }
    public void unsetRaw(){

    }
    public int read(){
        int lectura = 0;
        return lectura;
    }
    public String readLine(){
        String linea = null;
        return linea;
    }
}
