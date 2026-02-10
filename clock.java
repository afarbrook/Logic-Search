/*+----------------------------------------------------------------------
 ||
 ||  Class clock
 ||
 ||         Author:  Alex Farbrook
 ||
 ||        Purpose:  Keep track of hours searched and allow augmentation of that time.
 ||
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  clock() : initilizes hours and totalTime to zero.
 ||
 ||  Class Methods:  tick(): void
 ||                  canMove(): boolean
 ||                  canSearch(): boolean
 ||                  reset(): void
 ||                  canMoveandSearch(): boolean
 ||                  canMoveTwice(): boolean
 ||
 ||  Inst. Methods:  N/A
 ||
 ++-----------------------------------------------------------------------*/
public class clock {
    int hours; //hours in the current sleep cycle
    int totalTime; //total hours searched
    /*---------------------------------------------------------------------
        |  Method clock()
        |
        |  Purpose:  Create a clock object and initlize all fields.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: An instance of a clock object is created.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public clock(){
        this.hours = 0;
        this.totalTime = 0;

    }
    /*---------------------------------------------------------------------
        |  Method tick()
        |
        |  Purpose:  tick both times foward in a clock.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: clock is one hour foward.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public void tick(){
        hours++;
        totalTime++;
    }
    /*---------------------------------------------------------------------
        |  Method canMove()
        |
        |  Purpose:  check if logic has time to move one sqaure.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: The truth value of hours<16 is returned.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  if hours<16 then true is returned, otherwise false.
        *-------------------------------------------------------------------*/
    public boolean canMove(){
        return hours < 16;
    }
    /*---------------------------------------------------------------------
        |  Method canSearch()
        |
        |  Purpose:  check if logic has time to search one sqaure.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: The truth value of hours<15 is returned.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  if hours<15 then true is returned, otherwise false.
        *-------------------------------------------------------------------*/
    public boolean canSearch(){
        return hours <15;
    }
    /*---------------------------------------------------------------------
        |  Method reset()
        |
        |  Purpose:  resets the cycle clock to 0, and adds 8 hours to the total
        |
        |  Pre-condition:  None
        |
        |  Post-condition: clock is reset and total time is corrected
        |
        |  Parameters:
        |      None
        |
        |  Returns:  none
        *-------------------------------------------------------------------*/
    public void reset(){
        hours = 0;
        totalTime +=8;
    }
    /*---------------------------------------------------------------------
        |  Method canMoveAndSearch()
        |
        |  Purpose:  check if logic has time to move one sqaure and search it.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: The truth value of hours<14 is returned.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  if hours<14 then true is returned, otherwise false.
        *-------------------------------------------------------------------*/
    public boolean canMoveAndSearch(){
        return hours<14;
    }
    /*---------------------------------------------------------------------
        |  Method canMoveTwice()
        |
        |  Purpose:  check if logic has time to move one sqaure, then another, and then search it.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: The truth value of hours<13 is returned.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  if hours<13 then true is returned, otherwise false.
        *-------------------------------------------------------------------*/
    public boolean canMoveTwice(){
        return hours<13;
    }
}