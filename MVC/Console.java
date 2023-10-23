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

    public void escribir(char c){
        System.out.print(c);
    }

    public void modeInsertar(){
        System.out.print("\033[4l");
    }

    public void modeNormal(){
        System.out.print("\033[4l");
    }
}
