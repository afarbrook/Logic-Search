public class clock {
    int hours;
    int totalTime;

    public clock(){
        this.hours = 0;
        this.totalTime = 0;

    }

    public void tick(){
        hours++;
        totalTime++;
    }

    public boolean canMove(){
        return hours < 16;
    }
    public boolean canSearch(){
        return hours <15;
    }
    public void reset(){
        hours = 0;
        totalTime +=8;
    }
    public boolean canMoveAndSearch(){
        return hours<14;
    }
    public boolean canMoveTwice(){
        return hours<13;
    }
}