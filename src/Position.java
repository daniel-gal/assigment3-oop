public class Position implements Comparable<Position>{

    private int x;
    private int y;

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

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position)obj;

        if (x != other.getX())
            return false;
        if (y != other.getY())
            return false;
        return true;
    }

    public int compareTo(Position p){
        return (int)Math.sqrt(Math.pow(p.getY() - this.y,2) + Math.pow(p.getX() - this.x,2));
    }
}
