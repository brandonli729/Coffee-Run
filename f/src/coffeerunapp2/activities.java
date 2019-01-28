package coffeerunapp2;


import static com.codename1.ui.CN.*;

import com.codename1.charts.compat.Canvas;
import com.codename1.charts.compat.Paint;
import com.codename1.components.SpanLabel;
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


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.codename1.ui.layouts.BoxLayout;

public class activities {

    private Form current;
    private Resources theme;
    public boolean HasDebt;

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
        /*
        Form Main_Page = new Form("Coffee Run", new BorderLayout());
//

        Tabs Main_Tab = new Tabs();
        Style Tab_Style = UIManager.getInstance().getComponentStyle("Tab");

        //FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_QUESTION_ANSWER, Tab_Style);


        //making all the forms
        Form CreateRuns = new Form("Create a Run", new GridLayout(6, 2));
        Form Main_Runs = new Form("Open Runs", new GridLayout(10, 1));
        Main_Runs.setScrollableY(true);
        Form Profile = new Form("Profile", new BorderLayout());
        Form Groups = new Form("Groups", new BorderLayout());
        Form Run = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run2 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run3 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run4 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run5 = new Form("Coffee Run", new GridLayout(6, 1));

        //making tabs at the top
        Main_Tab.addTab("Runs", Main_Runs);
        Main_Tab.addTab("Create", CreateRuns);
        Main_Tab.addTab("Profile", Profile);
        Main_Tab.addTab("Groups", Groups);

        //all the stuff after this is making all the buttons on the first page
        TextField a = new TextField("Search");
        Main_Runs.add(a);
        //Button b = new Button("Asia Chung, Starbucks, 1/8/19, 6th period");
        //Main_Runs.add(b);
        final Button b = new Button("Asia Chung, Starbucks, 1/8/19, 6th period");
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
        final Label Location1 = new Label ("Location: Starbucks");
        Run5.add(Location1);
        final Label Time1 = new Label ("Time: 6th Period on 1/8/19");
        Run5.add(Time1);
        final Label Spaces1 = new Label ("Spaces: 2 remaining");
        Run5.add(Spaces1);
        final Label Pickup1 = new Label ("Pickup: The Stu");
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
        final Label Name2 = new Label ("Name: Alyssa Dunn");
        Run4.add(Name2);
        final Label Class2 = new Label ("Class: 1");
        Run4.add(Class2);
        final Label Location2 = new Label ("Location: Dunkin' Donuts");
        Run4.add(Location2);
        final Label Time2 = new Label ("Time: 3:00pm on 1/8/19");
        Run4.add(Time2);
        final Label Spaces2 = new Label ("Spaces: 4 remaining");
        Run4.add(Spaces2);
        final Label Pickup2 = new Label ("Pickup: The Stu");
        Run4.add(Pickup2);
        final Button Join2 = new Button ("Place Order");
        Run4.add(Join2);

        final Button t = new Button("Esteban Gutierrez, Dunkin', 1/25/19, 2:55 pm");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Esteban's Run", "Esteban Gutierrez, Class 1, Dunkin' Donuts at 2:55pm 1/25/19, 9 Spaces remaining ", "Join", "Cancel");
            }
        });
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run3.show();
            }
        });
        final Label Name3 = new Label ("Name: Esteban Gutierrez");
        Run3.add(Name3);
        final Label Class3 = new Label ("Class: 1");
        Run3.add(Class3);
        final Label Location3 = new Label ("Location: Dunkin' Donuts");
        Run3.add(Location3);
        final Label Time3 = new Label ("Time: 2:55pm on 1/25/19");
        Run3.add(Time3);
        final Label Spaces3 = new Label ("Spaces: 9 remaining");
        Run3.add(Spaces3);
        final Label Pickup3 = new Label ("Pickup: Wigg Hall");
        Run3.add(Pickup3);
        final Button Join3 = new Button ("Place Order");
        Run3.add(Join3);

        final Button f = new Button("Andre Heard, 7-11, 1/13/19, 4:00 am");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(f);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Andre's Run", "Andre Heard, Admin, 7-11 at 4:00am 1/13/19, 27 Spaces remaining ", "Join", "Cancel");
            }
        });
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run2.show();
            }
        });
        final Label Name4 = new Label ("Name: Andre Heard");
        Run2.add(Name4);
        final Label Class4 = new Label ("Class: Admin");
        Run2.add(Class4);
        final Label Location4 = new Label ("Location: 7-11");
        Run2.add(Location4);
        final Label Time4 = new Label ("Time: 4:00am on 1/13/19");
        Run2.add(Time4);
        final Label Spaces4 = new Label ("Spaces: 27 remaining");
        Run2.add(Spaces4);
        final Label Pickup4 = new Label ("Pickup: The Dean's Office");
        Run2.add(Pickup4);
        final Button Join4 = new Button ("Place Order");
        Run2.add(Join4);
        /*final Button back = new Button("Back");
        back.addActionListener((e) -> {
            Run.setToolbar(new Toolbar());
            Run.setBackCommand(new Command("Back") {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Run.showBack();
                }
            });
            Run.show();
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





        Main_Page.add(BorderLayout.CENTER, Main_Tab);*/

        letstry.show();


    }

    public Form alyssaform(){
        Form Main_Page = new Form("Coffee Run", new BorderLayout());
//



        //FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_QUESTION_ANSWER, Tab_Style);


        //making all the forms
        Form CreateRuns = new Form("Create a Run", new GridLayout(6, 2));
        Form Main_Runs = new Form("Open Runs", new GridLayout(10, 1));
        Main_Runs.setScrollableY(true);
        Form Profile = new Form("Profile", new BorderLayout());
        Form Groups = new Form("Groups", new BorderLayout());
        Form Run = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run2 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run3 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run4 = new Form("Coffee Run", new GridLayout(6, 1));
        Form Run5 = new Form("Coffee Run", new GridLayout(6, 1));

        //making tabs at the top



        //all the stuff after this is making all the buttons on the first page
        TextField a = new TextField("Search");
        Main_Runs.add(a);
        //Button b = new Button("Asia Chung, Starbucks, 1/8/19, 6th period");
        //Main_Runs.add(b);
        final Button b = new Button("Asia Chung, Starbucks, 1/8/19, 6th period");
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
        final Label Location1 = new Label ("Location: Starbucks");
        Run5.add(Location1);
        final Label Time1 = new Label ("Time: 6th Period on 1/8/19");
        Run5.add(Time1);
        final Label Spaces1 = new Label ("Spaces: 2 remaining");
        Run5.add(Spaces1);
        final Label Pickup1 = new Label ("Pickup: The Stu");
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
        final Label Name2 = new Label ("Name: Alyssa Dunn");
        Run4.add(Name2);
        final Label Class2 = new Label ("Class: 1");
        Run4.add(Class2);
        final Label Location2 = new Label ("Location: Dunkin' Donuts");
        Run4.add(Location2);
        final Label Time2 = new Label ("Time: 3:00pm on 1/8/19");
        Run4.add(Time2);
        final Label Spaces2 = new Label ("Spaces: 4 remaining");
        Run4.add(Spaces2);
        final Label Pickup2 = new Label ("Pickup: The Stu");
        Run4.add(Pickup2);
        final Button Join2 = new Button ("Place Order");
        Run4.add(Join2);

        final Button t = new Button("Esteban Gutierrez, Dunkin', 1/25/19, 2:55 pm");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Esteban's Run", "Esteban Gutierrez, Class 1, Dunkin' Donuts at 2:55pm 1/25/19, 9 Spaces remaining ", "Join", "Cancel");
            }
        });
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run3.show();
            }
        });
        final Label Name3 = new Label ("Name: Esteban Gutierrez");
        Run3.add(Name3);
        final Label Class3 = new Label ("Class: 1");
        Run3.add(Class3);
        final Label Location3 = new Label ("Location: Dunkin' Donuts");
        Run3.add(Location3);
        final Label Time3 = new Label ("Time: 2:55pm on 1/25/19");
        Run3.add(Time3);
        final Label Spaces3 = new Label ("Spaces: 9 remaining");
        Run3.add(Spaces3);
        final Label Pickup3 = new Label ("Pickup: Wigg Hall");
        Run3.add(Pickup3);
        final Button Join3 = new Button ("Place Order");
        Run3.add(Join3);

        final Button f = new Button("Andre Heard, 7-11, 1/13/19, 4:00 am");
        //final Button showPopup = new Button("Show Popup");
        Main_Runs.add(f);
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Andre's Run", "Andre Heard, Admin, 7-11 at 4:00am 1/13/19, 27 Spaces remaining ", "Join", "Cancel");
            }
        });
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Run2.show();
            }
        });
        final Label Name4 = new Label ("Name: Andre Heard");
        Run2.add(Name4);
        final Label Class4 = new Label ("Class: Admin");
        Run2.add(Class4);
        final Label Location4 = new Label ("Location: 7-11");
        Run2.add(Location4);
        final Label Time4 = new Label ("Time: 4:00am on 1/13/19");
        Run2.add(Time4);
        final Label Spaces4 = new Label ("Spaces: 27 remaining");
        Run2.add(Spaces4);
        final Label Pickup4 = new Label ("Pickup: The Dean's Office");
        Run2.add(Pickup4);
        final Button Join4 = new Button ("Place Order");
        Run2.add(Join4);
        /*final Button back = new Button("Back");
        back.addActionListener((e) -> {
            Run.setToolbar(new Toolbar());
            Run.setBackCommand(new Command("Back") {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Run.showBack();
                }
            });
            Run.show();
        });*/
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