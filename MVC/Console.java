package MVC;

public class Console {
    public void error(){
        System.out.print("Error");
    }

    public void campana(){
        System.out.print("\007");
    }

    public void move(String s){
        System.out.print("\033[" + s);
    }
}
