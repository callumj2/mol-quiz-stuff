package Quiz;
import bagel.*;
import bagel.util.Colour;
import bagel.util.Point;


public class AnswerSpace {
    private Point pos;
    private String display;
    private Image space;
    private ColouredString colouredString;

    public AnswerSpace(){
        this.display = "";
        this.space = new Image("res/images/ans.png");
        this.pos = new Point(Window.getWidth()/2, Window.getHeight()/2);
        this.colouredString = new ColouredString(display, Colour.BLACK);
    }

    public void update(Input input){
        space.draw(pos.x, pos.y);
        if (input.wasPressed(Keys.A)){
            display = display + "a";
        }        if (input.wasPressed(Keys.B)){
            display = display + "b";
        }        if (input.wasPressed(Keys.C)){
            display = display + "c";
        }        if (input.wasPressed(Keys.D)){
            display = display + "d";
        }        if (input.wasPressed(Keys.E)){
            display = display + "e";
        }        if (input.wasPressed(Keys.F)){
            display = display + "f";
        }        if (input.wasPressed(Keys.G)){
            display = display + "g";
        }        if (input.wasPressed(Keys.H)){
            display = display + "h";
        }        if (input.wasPressed(Keys.I)){
            display = display + "i";
        }        if (input.wasPressed(Keys.J)){
            display = display + "j";
        }       if (input.wasPressed(Keys.K)){
            display = display + "k";
        }        if (input.wasPressed(Keys.L)){
            display = display + "l";
        }        if (input.wasPressed(Keys.M)){
            display = display + "m";
        }        if (input.wasPressed(Keys.N)){
            display = display + "n";
        }        if (input.wasPressed(Keys.O)){
            display = display + "o";
        }        if (input.wasPressed(Keys.P)){
            display = display + "p";
        }        if (input.wasPressed(Keys.Q)){
            display = display + "q";
        }        if (input.wasPressed(Keys.R)){
            display = display + "r";
        }        if (input.wasPressed(Keys.S)){
            display = display + "s";
        }        if (input.wasPressed(Keys.T)){
            display = display + "t";
        }        if (input.wasPressed(Keys.U)){
            display = display + "u";
        }        if (input.wasPressed(Keys.V)){
            display = display + "v";
        }        if (input.wasPressed(Keys.W)){
            display = display + "w";
        }        if (input.wasPressed(Keys.X)){
            display = display + "x";
        }        if (input.wasPressed(Keys.Y)){
            display = display + "y";
        }        if (input.wasPressed(Keys.Z)){
            display = display + "z";
        }        if (input.wasPressed(Keys.BACKSPACE)){
            display = display.substring(0, (display.length() - 1));
        }
        colouredString.setMessage(display);
        colouredString.render(pos.asVector());
    }

    public String getDisplay() {
        return display;
    }
}
