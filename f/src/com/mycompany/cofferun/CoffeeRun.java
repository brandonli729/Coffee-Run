package com.mycompany.cofferun;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import java.io.IOException;
import com.codename1.ui.Toolbar;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import com.codename1.io.Log;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.*;

import com.codename1.social.Login;
import com.codename1.ui.*;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class CoffeeRun {

    public Form current, hi, slotmaker, runmaker, personalizerun;
    private Container mainpanel, runpanel;
    private Button addrunbutton, confirmslot;
    private Resources theme;
    public User user1;
    public int runcounter;
  //  public Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but10;
    public Button slotbuttons[];
    public TextField slotname, slotcost;
    public AutoCompleteTextField slotorder;
    public Map<String, String> items;
    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }


      /*  for(int s=0; s<slotbuttons.length; s++)
        {

            slotbuttons[s] = new Button("Claim Slot");


        }*/




       Form wellthen = new Form("coolio",new BorderLayout());
        /*hi = new Form("Coffee", new BorderLayout());

       // slotmaker = new Form("Claim Your Slot", new GridLayout(4,1));
        mainpanel=new Container();
        mainpanel.setLayout(new GridLayout(1, 1));


        addrunbutton = new Button("Make Run");
    //    slotname = new TextField("Name");
      //  slotcost = new TextField("0");
     //   slotorder = new TextField("order");
      //  confirmslot = new Button ("Enter");

        runpanel=new Container();





        mainpanel.add(addrunbutton);

        addrunbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {



                makearun();

                //HERE IS THE WIKIPEDIA
            }
        });

        hi.addComponent(BorderLayout.CENTER, mainpanel);*/
        wellthen.add(forgodsake());
        wellthen.show();
    }

    public Form forgodsake(){
        hi = new Form( new BorderLayout());

        slotbuttons = new Button[10];
        items = new HashMap<String, String>();

        user1 = new User ("Lyndsey Mugford", 1);

        // slotmaker = new Form("Claim Your Slot", new GridLayout(4,1));
        mainpanel=new Container();
        mainpanel.setLayout(new GridLayout(1, 1));


        addrunbutton = new Button("Make Run");
        //    slotname = new TextField("Name");
        //  slotcost = new TextField("0");
        //   slotorder = new TextField("order");
        //  confirmslot = new Button ("Enter");

        runpanel=new Container();





        mainpanel.add(addrunbutton);

        addrunbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {



                makearun();

                //HERE IS THE WIKIPEDIA
            }
        });

        hi.addComponent(BorderLayout.CENTER, mainpanel);
        return(hi);

    }
    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void addtobalance(double addition, int usernumber)
    {
        user1.balance=user1.balance+addition;

    }

    public void makearun()
    {
        System.out.println("make a run");
        Run currentrun= new Run (runcounter, 7, true, true, "");
        System.out.println("!!!!!!!!!" + currentrun.slots);
       runpanel.setLayout(new GridLayout(currentrun.slots, 1));
       runmaker = new Form(currentrun.restaurant+ " Run", new GridLayout(currentrun.slots,1));



        for (int j=0;j<currentrun.slots;j++)
        {

            currentrun.FillSlot(j, "name", "order", 0);
            System.out.println("bam");
            //runmaker.add(slotbuttons[j]);

           // ActivateSlotButton(j, currentrun);


        }

       PersonalizeRunMaker(currentrun);
        //Makerunmaker(currentrun, 4, true, false, "Bob's store");




      //  }
        //hi.removeComponent(mainpanel);
        //hi.addComponent(BorderLayout.CENTER, runpanel);






    }

    public void PersonalizeRunMaker (Run currentrun)
    {
        Container tf = new Container ();
        tf.setLayout(new GridLayout(1,2));


        personalizerun= new Form ("Personalize Run", new GridLayout(4,1));
        AutoCompleteTextField restaurantpicker = new AutoCompleteTextField("Starbucks", "Dunkin Donuts");

        RadioButton openbutton = new RadioButton ("open run");
        RadioButton closedbutton = new RadioButton ("closed run");
        new ButtonGroup (openbutton,closedbutton);
        openbutton.setSelected(true);

        RadioButton charge = new RadioButton ("add tip");
        RadioButton chargeless = new RadioButton ("no tip");
        new ButtonGroup(charge,chargeless);
        chargeless.setSelected(true);

        Button go = new Button ("Go");



        TextField setslots = new TextField ("size");


        tf.add(openbutton).add(closedbutton);
        tf.add(charge).add(chargeless);


        personalizerun.addComponent(restaurantpicker);
        personalizerun.addComponent(tf);
        personalizerun.addComponent(setslots);
        personalizerun.addComponent(go);



        go.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

               double slotsizedouble = Double.valueOf(setslots.getText());
               int slotsize = (int)slotsizedouble;

               currentrun.slots=slotsize;
               currentrun.open=true;
               currentrun.charge=false;
               currentrun.restaurant=restaurantpicker.getText();

                System.out.println("current run slots: " +currentrun.slots);


               Makerunmaker(currentrun);
                runmaker.show();

            }

        });


        personalizerun.show();

    }

    public void Makerunmaker(Run currentrun)
    {

        runmaker = new Form(currentrun.restaurant +" Run", new GridLayout(currentrun.slots,1));
        for(int s=0; s<currentrun.slotlist.size(); s++)
        {

            System.out.println("????"+currentrun.slotlist.size());
            slotbuttons[s] = new Button(currentrun.slotlist.get(s).name);
            System.out.println(slotbuttons.length);

        }


        for (int j=0;j<currentrun.slots;j++)
        {

            //currentrun.FillSlot(j, "name", "order", 0);

            runmaker.add(slotbuttons[j]);

            // ActivateSlotButton(j, currentrun);


        }
        for (int j=0;j<currentrun.slots;j++) {

          int jj=j;
        slotbuttons[jj].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                PersonalizeSlot(jj, currentrun);
                System.out.println("hit 0");
            }

        });
          }
        //hi.removeComponent(mainpanel);
        //hi.addComponent(BorderLayout.CENTER, runpanel);
        runmaker.show();


    }


    public void ActivateSlotButton(int jj, Run thisrun)
    {
        //thisrun.FillSlot(jj, "Lyndsey", "coffee", 2.99);
        slotbuttons[jj].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                PersonalizeSlot(jj, thisrun);
                //System.out.println(thisrun.slotlist.size());


            }
        });
    }


    public void PersonalizeSlot(int j, Run currentrun)
    {
        slotmaker = new Form("Claim Your Slot", new GridLayout(4,1));

        slotname = new TextField("Name");
        slotcost = new TextField("0");

        items.put("Coffee","3.45");
        items.put("Bread","2.00");
        items.put("Jam","8.43");
        items.put("","0.00");


        ComboBox <String> dropdownorder = new ComboBox<>();



        dropdownorder.addItem("Coffee");
        dropdownorder.addItem("bread");
        dropdownorder.addItem("jam");


        

        slotorder = new AutoCompleteTextField("Coffee", "Jam", "Croissant", "Caramel Latte", "Muffin", "Bread", "Tea", "Green tea", "iced tea", "iced coffee", "mocha");

        slotorder.setMinimumElementsShownInPopup(5);

        confirmslot = new Button ("Enter");


        slotmaker.addComponent(slotname);
        slotmaker.addComponent(slotorder);
        slotmaker.addComponent(slotcost);
      //  slotmaker.addComponent(dropdownorder);
        slotorder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {


                slotcost.setText(items.get(slotorder.getText()));

            }

        });





        slotmaker.addComponent(confirmslot);



        confirmslot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {





                System.out.println("J is: " + j);
                System.out.println(slotcost.getText());
                double costj = Double.valueOf(slotcost.getText());
                currentrun.slotlist.get(j).name=slotname.getText();
                currentrun.slotlist.get(j).order=slotorder.getText();
                currentrun.slotlist.get(j).cost=costj;
                System.out.println("set stuff");
               // System.out.println(currentrun.slotlist.size());
                //String displaystring = ""+currentrun.slotlist.get((j)).name + ", " + currentrun.slotlist.get((j)).order + ": "+currentrun.slotlist.get((j)).cost;
              //  System.out.println(displaystring);
                slotbuttons[j].setText(""+currentrun.slotlist.get((j)).name + ", " + currentrun.slotlist.get((j)).order + ": "+currentrun.slotlist.get((j)).cost);

                Makerunmaker(currentrun);
                for (int k=0;k<currentrun.slotlist.size();k++)
                {
                    System.out.print(currentrun.slotlist.get(k).name);
                }
                System.out.println("");
                //slotname.setText("name");
               // slotorder.setText("order");
               // slotcost.setText("0");


            }

        });


        slotmaker.show();

     //   String displaystring = ""+currentrun.slotlist.get((jj)).name + ", " + currentrun.slotlist.get((jj)).order + ": "+currentrun.slotlist.get((jj)).cost;
     //   slotbuttons[jj].setText(displaystring);

        for (int p=0;p<currentrun.slots;p++)
        {

           // currentrun.FillSlot(j, "name", "order", 0);
           // runpanel.add(slotbuttons[j]);
            slotbuttons[p].setText(""+currentrun.slotlist.get(p).name+ ", " + currentrun.slotlist.get((j)).order + ": "+currentrun.slotlist.get((j)).cost);

            // ActivateSlotButton(j, currentrun);


        }
        System.out.println("");
    }

    
    public void destroy() {
    }

}
