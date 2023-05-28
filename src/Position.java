public class Position implements Comparable<Position>{

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double range(Position a,Position b){
        return Math.sqrt((Math.pow(a.getX()-b.getX(),2))+(Math.pow(a.getY()-b.getY(),2)));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Position p){
        if(p.getX() == this.x && p.getY() == this.y)
            return 0;
        return -1;
    }
}
