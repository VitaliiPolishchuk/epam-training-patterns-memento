package the.best;

public class ChristFigure extends Figure {

    static Figure instance;

    private ChristFigure() {
        super("X");
    }

    public static Figure getInstance(){
        if(instance == null){
            instance = new ChristFigure();
        }
        return instance;
    }
}
