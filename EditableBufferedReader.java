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
    static final int ENTER = 13; //Útil per saber quan s'introdueix un CR i hem d'acabar
   
    static final int VIRGULILLA = 126; //Útil per fer DEL e INSERT, ja que cal "~"
    static final int ESC = 27; //Útil per fer les fletxes, ja que ens cal "^["
    static final int CORXET = 91; //Útile per representar les fletxes ja que ens cal "["

    //Definim els valors a retornar per la funció read, escollim valors a partir del
    //256, ja que son valors lliures a la taula ASCII, no definim BPSK, ja que es un 
    //valor existent i el podem retornar a ell mateix
    static final int RET_DRETA = 256;
    static final int RET_ESQUERRA = 257;
    static final int RET_INICI = 258;
    static final int RET_FINAL = 259;
    static final int RET_DEL = 260;
    static final int RTE_INSERT = 261;
    

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
        //Mirem si els caràcters enviats són ^[[
        if(lectura == ESC){
            lectura = super.read();
            if(lectura == CORXET){
                lectura = super.read();
                switch(lectura){
                    case DRETA:
                        return RET_DRETA;
                    case ESQUERRA:
                        return RET_ESQUERRA;
                    case INICI:
                        return RET_INICI;
                    case FINAL:
                        return RET_FINAL;
                    case INSERT:
                        //Mirem si el car`zcter enviat és ~
                        if(super.read() == VIRGULILLA){
                            return RTE_INSERT;
                        }
                        return -1;
                    case DEL:
                        //Mirem si el caràcter enviat és ~
                        if(super.read() == VIRGULILLA){
                            return RET_DEL;
                        }
                        return -1;
                    default:
                        //Si l'usuari prem ^[[ i un caràcter desconegut no retornem
                        return -1;
                }
            }
        //Especifiquem el cas del BPSK valor 127 (tecla espai)
        } else if (lectura == BPSK) {
            return BPSK;
        //Si s'introdueix un caràcter comú el retornem
        } else {
            return lectura;
        }
        //Per si hi hagués algun error o cas no contemplat
        return -1;
    }

    public String readLine() throws IOException {
        String linea = null;
        int lectura = 0;

        lectura = read();
        while(lectura != ENTER){
            linea.se
        }
        return linea;
    }
}
