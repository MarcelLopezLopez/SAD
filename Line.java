import java.io.*;
import java.util.ArrayList;

public class Line {
    
    private int pos;
    private boolean insert;
    private ArrayList<Character> linia;

    Line(){
        this.pos = 0;
        this.insert = true;
        this.linia = new ArrayList<Character>();
    }
}
