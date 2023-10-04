import java.io.*;
import java.util.ArrayList;
import java.util.Observer;

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
        this.pos = 0;
    }

    public void end(){
        this.pos = this.linia.size();
    }

    public void dreta(){
        this.pos ++;
    }

    public void esquerra(){
        if(this.pos > 0){
            this.pos--;
        } else {
            System.out.print('\007');
        }
    }
}
