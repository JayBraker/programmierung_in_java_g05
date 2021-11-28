package JavaHausaufgaben08;

public class Position {
    public int x;
    public int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public boolean equals( Position p) {
        if(this.x == p.x && this.y == p.y) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean isValid(int x, int y) {
        if(x<0 && x>8) {
            return true;
        }else if (y<0 && y>8) {
            return true;
        }else {
            return false;
        }
    }
    public String toString() {
        return String.format("(%d / %d", this.x, this.y);
    }
}
