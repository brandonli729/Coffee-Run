package com.mycompany.cofferun;

import java.util.ArrayList;

/**
 * Created by lyndseymugford on 11/28/18.
 */
public class Run {
    public int ID, slots;
    public String restaurant;
    public boolean charge, open;
    public ArrayList<runslot> slotlist;


    public Run(int count, int slotsj, boolean chargej, boolean openj, String restaurantj)
    {
        ID=count;
        slots=slotsj;
        charge=chargej;
        open=openj;
        restaurant = restaurantj;


        slotlist = new ArrayList<runslot>();



    }

    public void FillSlot(int kj, String namem, String orderm, double costm)
    {

            runslot slotk = new runslot (kj,namem, orderm, costm);
            slotlist.add(slotk);

    }
}
