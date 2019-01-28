package UberEats;


import static com.codename1.ui.CN.*;
import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.AX;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.mig.LC;
import com.codename1.ui.layouts.mig.MigLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;

import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.mycompany.cofferun.CoffeeRun;

public class UberEats {
    private Image defaultpic;
    private Form current,whole;
    private Resources theme;
    private Label img;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }

        whole = new Form("Coffee with Friends", new BorderLayout());
        Tabs tb = new Tabs(){
            protected Component createTab(String title, Image icon) {
                SpanButton custom = new SpanButton(title);
                custom.setIcon(icon);
                custom.setUIID("Container");
                custom.setTextUIID("Tab");
                //custom.setIconPosition(BorderLayout.SOUTH);
                custom.setIconPosition(BorderLayout.CENTER);

                custom.setIconUIID("Tab");
                return custom;

        }
            protected void setTabSelectedIcon(Component tab, Image icon) {
                ((SpanButton)tab).setPressedIcon(icon);}
            protected void selectTab(Component tab) {
            }

            @Override
            protected void bindTabActionListener(Component tab, ActionListener l) {
                ((SpanButton)tab).addActionListener(l);
            }
        };




        tb.setTabUIID(null);
        whole.add(BorderLayout.CENTER, tb);
        CoffeeRun coffeerun = new CoffeeRun();
        www.hales.iscool.chat ayy = new www.hales.iscool.chat();
        Form LOL = ayy.LogInForm();
        Form pleasework = coffeerun.forgodsake();


        coffeerunapp2.activities please = new coffeerunapp2.activities();
        Form letsdothis = please.alyssaform();
        letsdothis.getToolbar().hideToolbar();
        Form asiaform = new www.hales.iscool.SplashScreen();

        tb.addTab("Splashscreen",FontImage.MATERIAL_WALLPAPER,4,asiaform);
        tb.addTab("Log-In", FontImage.MATERIAL_LOCK, 4, LOL);
        tb.addTab("Home", FontImage.MATERIAL_HOME,4,letsdothis);
        tb.addTab("User Profile", FontImage.MATERIAL_ACCESSIBILITY, 4, profileForm());
        tb.addTab("Make a Run", FontImage.MATERIAL_SHOPPING_CART, 4,pleasework);

        tb.getTabsContainer().setScrollableX(false);


        whole.show();
    }


    public Form profileForm()
    {
        try {
            defaultpic = Image.createImage("/default.jpg");
        } catch (IOException e1){
            e1.printStackTrace();
        }


        img = new Label();
        img.setIcon(defaultpic);
        TableLayout wholelayout = new TableLayout(2,1);
        TableLayout secondhalf = new TableLayout(5,2);
        Form hi = new Form(wholelayout);
        TableLayout firsthalf = new TableLayout(2,1);
        Container information = new Container(secondhalf);

        Container picname = new Container(firsthalf);
        picname.add(firsthalf.createConstraint().heightPercentage(50),new ScaleImageLabel(defaultpic));
        picname.add(firsthalf.createConstraint().horizontalAlign(Component.CENTER).heightPercentage(10),new Label("Asia Chung"));

        SpanLabel l = new SpanLabel("I never dreamed about success - I worked for it.");
        l.setTextBlockAlign(Component.CENTER);
        picname.add(firsthalf.createConstraint().widthPercentage(100).heightPercentage(15).horizontalAlign(CENTER), l);

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT), new Label("Grade:"));
        information.add(secondhalf.createConstraint().widthPercentage(50).horizontalAlign(Component.LEFT),new Label("Senior"));

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT), new Label("Sex:"));
        information.add(secondhalf.createConstraint().horizontalAlign(Component.LEFT), new Label("Female"));

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT),new Label("Dorm:"));
        information.add(secondhalf.createConstraint().horizontalAlign(Component.LEFT), new Label("Robbins"));

        Style stitle = hi.getToolbar().getTitleComponent().getUnselectedStyle();
        hi.getToolbar().hideToolbar();
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage edit = FontImage.createMaterial(FontImage.MATERIAL_CREATE, s);
        Toolbar tool = new Toolbar(true);

        hi.setToolbar(tool);

        Button editimagebutton = new Button("Change Profile Picture");
        editimagebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {



                System.out.println("Editing Image");
            }
        });

        Form editform = new Form("Edit Profile",BoxLayout.y());
        TableLayout editlayout = new TableLayout(10,1);
        editlayout.setGrowHorizontally(true);

        editform.add(new ScaleImageLabel(defaultpic));
        editform.add(editimagebutton);
        Container infocont = new Container(editlayout);


        TextField nametext = new TextField("", "Name", 20, TextArea.ANY);
        TextField biotext = new TextField("", "Biography", 40, TextArea.ANY);
        TextField dormtext = new TextField("", "Dorm", 20, TextArea.ANY);
        TextField gradetext = new TextField("", "Grade", 20, TextArea.ANY);
        TextField sextext = new TextField("", "Sex", 20, TextArea.ANY);

        Button savebutton = new Button("Save Changes");
        TableLayout.Constraint cn = editlayout.createConstraint();
        cn.setHorizontalAlign(Component.RIGHT);

        infocont.add("Name").add(nametext).add("Biography").add(biotext)
                .add("Dorm").add(dormtext).add("Grade").add(gradetext)
                .add("Sex").add(sextext).add(cn,savebutton);


        editform.add(infocont);






        Image im = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, UIManager.getInstance().getComponentStyle("Command"));
        Command editcommand = new Command("Edit", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Editing");
                editform.show();
                setBackCommand(editform);
            }
        };

        tool.addCommandToRightBar("Edit Profile",edit,editcommand);



        hi.add(wholelayout.createConstraint().heightPercentage(60),picname);
        hi.add(information);

        return(hi);

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

    protected void setBackCommand(Form f) {
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                whole.showBack();
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        f.getToolbar().addCommandToLeftBar(back);
        f.getToolbar().setTitleCentered(true);
        f.setBackCommand(back);
    }

}
