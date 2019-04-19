package coffeerunapp2;

/**
 * Created by lyndseymugford on 2/6/19.
 */
public class AvailibleRun {

    public String runId, destination, timeCreated;
    public int numslots, slotsLeft;
    public Boolean privacy;

    public AvailibleRun(String runIDj, String destinationj, Boolean privacyj, String timeCreatedj, int numslotsj)
    {
        runId=runIDj;
        destination=destinationj;
        numslots=numslotsj;
        privacy=privacyj;
        //slotsLeft=slotsLeftj;
        timeCreated=timeCreatedj;
    }
}
