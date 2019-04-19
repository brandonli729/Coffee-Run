package coffeerunapp2;


import static com.codename1.ui.CN.*;

import com.codename1.charts.compat.Canvas;
import com.codename1.charts.compat.Paint;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionEvent;
import com.codename1.components.FloatingActionButton;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.cofferun.CoffeeRun;

public class activities {

    private Form current;
    private Resources theme;
    public boolean HasDebt;
    public Map response;
    public ArrayList<AvailibleRun> availibleRuns;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);
    }

    public void start() {
        if(current != null){
            current.show();
            return;
        }
        Form letstry = new Form("Unecessaryform", new BorderLayout());

        letstry.show();


    }



    public Form alyssaform(){
        Form Main_Page = new Form("Coffee Run", new BorderLayout());

        availibleRuns = new ArrayList <AvailibleRun>();

        ReadJsonGetRuns("https://crippin-coffee.herokuapp.com/getDocked");



//



        //FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_QUESTION_ANSWER, Tab_Style);


        //making all the forms
        Form CreateRuns = new Form("Create a Run", new GridLayout(6, 2));
        Form Main_Runs = new Form("Open Runs", new GridLayout(availibleRuns.size(), 1));
        Main_Runs.setScrollableY(true);
        Form Profile = new Form("Profile", new BorderLayout());


        for (int p=0;p<availibleRuns.size();p++)
        {
            final Button bb = new Button(p+":"+availibleRuns.get(p).destination+","+availibleRuns.get(p).timeCreated);
            Main_Runs.add(bb);
            int j = p;
            bb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Dialog.show("This Run",j+":"+availibleRuns.get(j).destination+","+availibleRuns.get(j).timeCreated , "Join", "Cancel");
                    CoffeeRun coffeerun2 = new CoffeeRun();
                    coffeerun2.addtobalance(4.5, 2);
                    String runIDtempstring = availibleRuns.get(j).runId;
                    //int runidint = Integer.valueOf (runIDtempstring);
                    // System.out.println(runidint);
                    coffeerun2.makearun(runIDtempstring, availibleRuns.get(j).destination, false, availibleRuns.get(j).numslots);
                    System.out.println("we're switching forms now!");
                }
            });
        }

        Form Groups = new Form("Groups", new BorderLayout());
        Form Run = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run2 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run3 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run4 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run5 = new Form("Coffee Run", new GridLayout(6, 1));

        //making tabs at the top



        ////THIS IS HOW YOU CALL A METHOD FROM ANOTHER CLASS ^

        //all the stuff after this is making all the buttons on the first page
        TextField a = new TextField("Search");
        Main_Runs.add(a);
        //Button b = new Button("Asia Chung, Starbucks, 1/8/19, 6th period");
        //Main_Runs.add(b);
        final Button b = new Button(availibleRuns.get(1).destination+","+availibleRuns.get(1).timeCreated);
        Main_Runs.add(b);
        //these action listeners make the dialog show up an then a new tab to open when "Join" is clicked
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Asia's Run", "Asia Chung, Class 1, Starbucks at 6th period 1/8/19, 2 Spaces remaining ", "Join", "Cancel");
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run5.show();
            }
        });
        //these make all the labels for the Run pages
        final Label Name1 = new Label ("Name: Asia Chung");
        Run5.add(Name1);
        final Label Class1 = new Label ("Class: 1");
        Run5.add(Class1);

        // System.out.println("!!!!!!!"+response.get("112wg7njrfec0n5"));
        // Map response2 = response.get("112wg7njrfec0n5");
        Map <String, Object> allItems = (Map<String, Object>) response.get("2heenjt07ywca");
        Object destination1 = allItems.get("destination");
        String destination1string = (String) destination1;
        System.out.println("HERE"+destination1string);






        final Label Location1 = new Label (availibleRuns.get(1).destination);
        Run5.add(Location1);
        final Label Time1 = new Label (availibleRuns.get(1).timeCreated);
        System.out.println(availibleRuns.get(1).timeCreated);
        Run5.add(Time1);
        final Label Spaces1 = new Label ("Spaces: 2 remaining");
        Run5.add(Spaces1);
        final Label Pickup1 = new Label (availibleRuns.get(1).timeCreated);
        Run5.add(Pickup1);
        final Button Join1 = new Button ("Place Order");
        Run5.add(Join1);



        //Button c = new Button ("Alyssa Dunn, Dunkin', 1/8/19, 3:00 pm");
        //Main_Runs.add(c);
        final Button show = new Button("Alyssa Dunn, Dunkin', 1/8/19, 3:00 pm");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(show);
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Alyssa's Run", "Alyssa Dunn, Class 1, Dunkin' Donuts at 3:00pm 1/8/19, 4 Spaces remaining ", "Join", "Cancel");
            }
        });
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run4.show();
            }
        });

        final Button r = new Button("Andrew Willworth, Pat's, 1/20/19, 6:00 pm");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(r);
        r.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Andrew's Run", "Andrew Willworth, Class 2, Pat's Pizza at 6:00pm 1/20/19, 1 Spaces remaining ", "Join", "Cancel");
            }
        });
        r.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run.show();
            }
        });
        final Label Name5 = new Label ("Name: Andrew Willworth");
        Run.add(Name5);
        final Label Class5 = new Label ("Class: 2");
        Run.add(Class5);
        final Label Location5 = new Label ("Location: Pat's Pizza");
        Run.add(Location5);
        final Label Time5 = new Label ("Time: 6:00pm on 1/20/19");
        Run.add(Time5);
        final Label Spaces5 = new Label ("Spaces: 1 remaining");
        Run.add(Spaces5);
        final Label Pickup5 = new Label ("Pickup: The Stu");
        Run.add(Pickup5);
        final Button Join5 = new Button ("Place Order");
        Run.add(Join5);

        //This adds the floating button at the bottom
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        //fab.setText("fred");

        //  fab.setTextBitmap("ANDROID", 100f, Color.WHITE)
        //  fab.scaleType = ImageView.ScaleType.CENTER
        //  fab.adjustViewBounds = false
        // if (HasDebt == true){
        //}
        Main_Runs.add(fab);
        fab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Your Debt", "You owe $4.56", "Pay", "Cancel");
            }
        });
        //this opens the page that displays all the debt
        Form DebtPage = new Form("Your Debt", new GridLayout(10, 2));
        fab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DebtPage.show();
            }
        });
        final Button y = new Button ("Lyndsey - $4.56");
        DebtPage.add(y);
        final Button u = new Button("Pay");
        DebtPage.add(u);




        Main_Runs.getToolbar().hideToolbar();
        Main_Page.add(BorderLayout.CENTER, Main_Runs);
        return(Main_Page);


    }
    public void chipotle()
    {
        String BASE_ORDER_URL = "https://order.chipotle.com";



    }

    public void ReadJsonGetRuns(String inputUrl) {
        ConnectionRequest req=new ConnectionRequest();

        req.setUrl(inputUrl);

        req.setPost(false);

        //string key, string value?
        req.setHttpMethod("GET");
        NetworkManager.getInstance().addToQueueAndWait(req);
        JSONParser parser=new JSONParser();
        try {
            Hashtable result =parser.parse(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println("test"+result);
            System.out.println(parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()))));
            response= parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println("!!!!!!!"+response.get("2heenjt07ywca"));



            Map <String, Object> allItems = (Map<String, Object>) response;
            System.out.println(allItems);


            for (Map.Entry<String, Object> entry : allItems.entrySet())
            {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                String currentkey = entry.getKey();

                //System.out.println("!!!!!!!"+response.get("112wg7njrfec0n5"));
                // Map response2 = response.get("112wg7njrfec0n5");
                Map <String, Object> thisItem = (Map<String, Object>) response.get(currentkey);
                Object destination1 = thisItem.get("destination");
                String destination1string = (String) destination1;
                Object privacy1 = thisItem.get("privacy");
                String privacy1string = (String) privacy1;
                Boolean privacy1boolean = false;
                if (privacy1string=="true")
                {
                    privacy1boolean = true;
                }

                Object numslots1 = thisItem.get("numSlots");
                String numslots1string = (String) numslots1;
                //int numslotsint = Integer.parseInt(numslots1string);
                // Object slotsLeft1 = thisItem.get("slotsLeft");
                // String slotsLeftstring = (String) slotsLeft1;
                // int slotsleftint = (int) slotsLeftstring;
                //  int slotsleftint = Integer.parseInt(slotsLeftstring);
                Object timecreated = thisItem.get("timeCreated");
                String timecreatedstring = (String) timecreated;
                Object runslotobject = thisItem.get("numSlots");
                String runslotstring = (String) runslotobject;
                System.out.println("??????"+runslotstring);
                int runslotint=0;
                if (runslotstring!=null&&!runslotstring.equals("")) {
                    try {
                        runslotint = Integer.parseInt(runslotstring);
                    }
                    catch(Exception e1)
                    {
                        System.out.println("something went wrong");
                    }
                    System.out.println("hereherehere"+runslotint);

                }

                AvailibleRun newrun = new AvailibleRun(currentkey, destination1string, privacy1boolean, timecreatedstring, runslotint);
                availibleRuns.add(newrun);



            }





        } catch (IOException e) {
            e.printStackTrace();
        }
        //return (null);
    }


    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
