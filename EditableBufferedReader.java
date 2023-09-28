import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EditableBufferedReader extends BufferedReader {

    static final int DRETA = 67; //La fletxa dreta es representa al terminal 
    // com "^[[C", de tal manera que representarem DRETA com 'C'
    static final int ESQUERRA = 68; //La fletxa esquerra es representa al 
    // terminal com "^[[D", de tal manera que representarem ESQUERRA com 'D'
    static final int INICI = 72; //Tecla inicio Printea ^[[H, utilitzarem la H
    static final int FINAL = 70; //Tecla fin Printea ^[[F, utilitzarem la F
    static final int DEL = 51; //Tecla supr Printea ^[[3~, utilitzarem el 3
    static final int BPSK = 127; //Tecla <-- backspace, te numero en ASCII
    static final int INSERT = 50; //Tecla insert Printea ^[[2~, utilitzarem el 2
   
    static final int VIRGULILLA = 126; //Útil per fer DEL e INSERT, ja que cal "~"
    static final int ESC = 27; //Útil per fer les fletxes, ja que ens cal "^["
    static final int CORXET = 91; //Útile per representar les fletxes ja que ens cal "["
    

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

        //Llegim el caràcter amb la funció main de BufferedReader
        lectura = super.read();
        if(lectura == ESC){
            lectura = super.read();
            if(lectura == CORXET){
                lectura = super.read();
                switch(lectura){
                    case DRETA:
                        return 'DRETA';
                    case ESQUERRA:
                        return 'ESQUERRA';
                    case 'INICIO':
                        return 'HOME';
                    case 'FINAL':
                        return 'END';
                    case 'INS'
                        return 'COMMUTA';
                    case 'DEL'
                        return

                }
            }
        }
        return lectura;
    }
    public String readLine() throws IOException {
        String linea = null;
        return linea;
    }
}
