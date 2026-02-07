public class clock {
    private int hours;

    public clock(){
        this.hours = 0;

    }

    public void tick(){
        hours++;
    }

    public boolean canMove(){
        return hours < 16;
    }
    public void reset(){
        hours = 0;
    }
}