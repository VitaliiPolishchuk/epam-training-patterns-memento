package the.best;

public class ZeroFigure extends Figure {

    static Figure instance;

    private ZeroFigure() {
        super("O");
    }

    public static Figure getInstance(){
        if(instance == null){
            instance = new ZeroFigure();
        }
        return instance;
    }
}
