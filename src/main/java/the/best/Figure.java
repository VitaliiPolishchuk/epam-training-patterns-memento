package the.best;

abstract public class Figure {
    String token;

    protected Figure(String token){
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
