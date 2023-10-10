import java.util.ArrayList;

public class Line {
    
    private int pos;
    private boolean insert;
    private ArrayList<Character> linia;

    public Line(){
        this.pos = 0;
        this.insert = true;
        this.linia = new ArrayList<Character>();
    }

    public int getPos(){
        return this.pos;
    }

    public void setPos(int posicio){
        this.pos = posicio;
    }

    public void start(){
        //Ens movem al inici
        this.pos = 0;
    }

    public void end(){
        //Ens movem al final
        this.pos = this.linia.size();
    }

    public void dreta(){
        if(this.pos < this.linia.size()){
            this.pos ++;
            System.out.print("\u001b[1C");
        } else {
            //Fem sonar la campana 
            //Provar si fiquem 'u\0007'
            System.out.print('\007');
        }
    }

    public void esquerra(){
        if(this.pos > 0){
            this.pos--;
            System.out.print("\u001b[1D");
        } else {
            System.out.print('\007');
        }
    }

    public void bksp(){
        //Borrem la posicio de l'esquerra del cursor
        if(!linia.isEmpty()){
            this.linia.remove(this.pos - 1);
            this.esquerra();
        } else {
            System.out.print('\007');
        }
    }

    public void del(){
        //Borrem la posicio de la dreta del cursor
        if(this.pos < this.linia.size() && !linia.isEmpty()){
            this.linia.remove(this.pos);
        } else {
            System.out.print('\007');
        }
    }

    public void ins(){
        insert = !insert;
    }

    public void add(char c){
        //Mirem si estem en mode insercio
        if(insert){
            this.linia.add(pos, c);
        //Mirem si estem en mode sobre-escriptura
        } else {
            //Comprovem que no ens trobem al final, ja que set() donaria error
            if(pos < this.linia.size()){
                this.linia.set(pos, c);
            } else {
                this.linia.add(pos, c);
            }
        }
        this.dreta();
    }

    public String toString(){
        //Mostrar la linea de caràcters
        String str = "";
        for(Character c: linia){
            str = str + c;
        }
        return str;
    }
}
