package UberEats;


import static com.codename1.ui.CN.*;
import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.AX;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.mig.LC;
import com.codename1.ui.layouts.mig.MigLayout;
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
    private Form current;
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

        Form whole = new Form("Coffee with Friends", new BorderLayout());
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
        CoffeeRun coffeerun = new CoffeeRun();
        www.hales.iscool.chat ayy = new www.hales.iscool.chat();
        Form LOL = ayy.LogInForm();
        Form pleasework = coffeerun.forgodsake();
        tb.addTab(" tab", FontImage.MATERIAL_BOOK, 4, LOL);
        tb.addTab("Tab 1", FontImage.MATERIAL_ACCESSIBILITY, 4, profileForm());
        tb.addTab("Tab 3", FontImage.MATERIAL_ACCESS_ALARM, 4,pleasework);


        tb.getTabsContainer().setScrollableX(false);

        whole.add(BorderLayout.CENTER, tb);
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

}
