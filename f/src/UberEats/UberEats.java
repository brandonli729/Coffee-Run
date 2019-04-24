package UberEats;


import static com.codename1.ui.CN.*;
import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.AX;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.*;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.mig.LC;
import com.codename1.ui.layouts.mig.MigLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.cofferun.CoffeeRun;

public class UberEats {
    private Image defaultpic;
    private Form current,whole;
    private Resources theme;
    private Label img;
    public AutoCompleteTextField slotorder, friendsnames;

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

        tb.addTab("Log-in Form",FontImage.MATERIAL_HOME,4,loginform());
        //tb.addTab("Splashscreen",FontImage.MATERIAL_WALLPAPER,4,asiaform);
        //tb.addTab("Log-In", FontImage.MATERIAL_LOCK, 4, LOL);
        tb.addTab("Home", FontImage.MATERIAL_HOME,4,letsdothis);
        tb.addTab("User Profile", FontImage.MATERIAL_ACCESSIBILITY, 4, profileForm());
        tb.addTab("Make a Run", FontImage.MATERIAL_SHOPPING_CART, 4,pleasework);
        tb.addTab("Payment",FontImage.MATERIAL_ATTACH_MONEY,4,moneytransfer());

        tb.getTabsContainer().setScrollableX(false);


        whole.show();
    }

    public Form loginform()
    {
        GridLayout loginlayout = new GridLayout(4,1);
        Form logmein = new Form();
        Container pleasework = new Container(loginlayout);
        TextField username = new TextField("","Username");
        TextField password = new TextField("","Password");
        Button signin = new Button("Sign In");

        Button createprofile = new Button ("Don't have an account?");


        Button editimagebutton = new Button("Add Profile Picture");
        editimagebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                //SMS textAsia = new SMS();
                //textAsia.sendmessage("8573893527","Hi stooopid");

                System.out.println("just a change");
            }
        });

        Form createform = new Form("Create Profile",BoxLayout.y());
        TableLayout editlayout = new TableLayout(10,1);
        editlayout.setGrowHorizontally(true);

        createform.add(new ScaleImageLabel(defaultpic));
        createform.add(editimagebutton);
        Container infocont = new Container(editlayout);


        TextField nametext = new TextField("", "Name", 20, TextArea.ANY);
        TextField usernametext = new TextField("","Username",20,TextArea.ANY);
        TextField passwordtext = new TextField("","Password",30,TextArea.ANY);
        passwordtext.setConstraint(TextField.PASSWORD);

        TextField biotext = new TextField("", "Biography", 40, TextArea.ANY);
        

        Button savebutton = new Button("Create Profile");
        savebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Save Profile");
                try {
                    ArrayList<String> namestring = new ArrayList<String>();
                    StringTokenizer tokenizer = new StringTokenizer(nametext.getText());
                    while (tokenizer.hasMoreTokens()) {
                        namestring.add(tokenizer.nextToken());

                    }
                    System.out.println("First Name:" + namestring.get(0));
                    System.out.println("Last Name:" + namestring.get(1));

                    ReadJsonAddUser("https://crippin-coffee.herokuapp.com/addUser", usernametext.getText(), passwordtext.getText(), namestring.get(0), namestring.get(1), biotext.getText());

                } catch(Exception e){
                    System.out.println("All Fields aren't filled out");


                }

                whole.showBack();
            }
        });
        TableLayout.Constraint cn = editlayout.createConstraint();
        cn.setHorizontalAlign(Component.RIGHT);

        infocont.add("Name").add(nametext).add("Username").add(usernametext).add("Password").add(passwordtext).add("Biography").add(biotext)
                .add(cn,savebutton);


        createform.add(infocont);

        createprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Creating Profile");
                createform.show();
                setBackCommand(createform);
            }
        });

        pleasework.add(username);
        pleasework.add(password);
        pleasework.add(signin);
        pleasework.add(createprofile);

        logmein.add(pleasework);

        return(logmein);

    }
    public Form moneytransfer()
    {
        GridLayout moneytransferlayout = new GridLayout(3,1);
        Form moneytransferform = new Form(moneytransferlayout);
        Container pleasegod = new Container(moneytransferlayout);
        friendsnames=new AutoCompleteTextField("Bob", "Jill", "Joe");
        Button transfergo=new Button("make transfer");
        TextField transferamount=new TextField("transfer amount");

        pleasegod.add(friendsnames);
        pleasegod.add(transferamount);
        pleasegod.add(transfergo);


        transfergo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Exchanging Money");
                String transfermoney = new String(transferamount.getText());
                double transfertruevalue;
                double transfernegativevalue;

                try{
                    transfertruevalue = Double.parseDouble(transfermoney);
                    transfernegativevalue = transfertruevalue * -1;
                    System.out.println("Double translation worked"+transfertruevalue);
                } catch (NumberFormatException e){
                    System.out.println("Textfield value is not a number");
                    transfertruevalue = 0;
                    transfernegativevalue = 0;
                }
                System.out.println(transfertruevalue);
                ReadJsonExchangeMoney("https://crippin-coffee.herokuapp.com/exchangeMoney","zankner",transfernegativevalue);
            }
        });
        moneytransferform.add(pleasegod);
        return(moneytransferform);


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


        String userbio = new String("I never dreamed about success - I worked for it.");
        String usergrade = new String("Senior");
        String userfirstname = new String("Asia");
        String userdorm = new String("Robbins");
        String userlastname = new String("Chung");
        String usersex = new String("Female");

        Container picname = new Container(firsthalf);
        picname.add(firsthalf.createConstraint().heightPercentage(50),new ScaleImageLabel(defaultpic));
        picname.add(firsthalf.createConstraint().horizontalAlign(Component.CENTER).heightPercentage(10),new Label(userfirstname+" "+userlastname));


        SpanLabel l = new SpanLabel(userbio);
        l.setTextBlockAlign(Component.CENTER);
        picname.add(firsthalf.createConstraint().widthPercentage(100).heightPercentage(15).horizontalAlign(CENTER), l);

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT), new Label("Grade:"));
        information.add(secondhalf.createConstraint().widthPercentage(50).horizontalAlign(Component.LEFT),new Label(usergrade));

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT), new Label("Sex:"));
        information.add(secondhalf.createConstraint().horizontalAlign(Component.LEFT), new Label(usersex));

        information.add(secondhalf.createConstraint().widthPercentage(50).heightPercentage(20).horizontalAlign(Component.RIGHT),new Label("Dorm:"));
        information.add(secondhalf.createConstraint().horizontalAlign(Component.LEFT), new Label(userdorm));

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

                //SMS textAsia = new SMS();
                //textAsia.sendmessage("8573893527","Hi stooopid");

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
        savebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Save Profile");
                ArrayList<String> namestring = new ArrayList<String>();
                StringTokenizer tokenizer = new StringTokenizer(nametext.getText());
                while(tokenizer.hasMoreTokens()) {
                    namestring.add(tokenizer.nextToken());

                }
                System.out.println("First Name:"+namestring.get(0));
                System.out.println("Last Name:"+namestring.get(1));
                ReadJsonEditProfile("https://crippin-coffee.herokuapp.com/editUser","zankner",namestring.get(0),namestring.get(1),biotext.getText(),gradetext.getText(),sextext.getText(),dormtext.getText());
            }
        });
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

    public void ReadJsonAddUser(String inputUrl, String userid, String password, String firstname, String lastname, String bio)
    {
        ConnectionRequest req=new ConnectionRequest();
        String newinput = inputUrl+"?userId="+userid+"&password="+password+"&userFirst="+firstname+"&userLast="+lastname+"&bio="+bio;

        req.setUrl(newinput);

        req.setPost(false);
        // req.addRequestHeader("numSlots","4");
        //req.addRequestHeader("privacy", "false");
        // req.addRequestHeader("destination","Starbucks");
        //string key, string value?
        req.setHttpMethod("GET");
        NetworkManager.getInstance().addToQueueAndWait(req);
        JSONParser parser=new JSONParser();
        try {
            Hashtable result =parser.parse(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println("test"+result);
            System.out.println(parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()))));
            Map response=parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println( "hope"+response.get("result"));


            LinkedHashMap allItems = new LinkedHashMap();
            allItems=(LinkedHashMap)response.get("result");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadJsonExchangeMoney(String inputUrl, String userid, Double value)
    {
        ConnectionRequest req=new ConnectionRequest();
        String newinput = inputUrl+"?userId="+userid+"&dinero="+value;
        req.setUrl(newinput);

        req.setPost(false);
        // req.addRequestHeader("numSlots","4");
        //req.addRequestHeader("privacy", "false");
        // req.addRequestHeader("destination","Starbucks");
        //string key, string value?
        req.setHttpMethod("GET");
        NetworkManager.getInstance().addToQueueAndWait(req);
        JSONParser parser=new JSONParser();
        try {
            Hashtable result =parser.parse(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println("test"+result);
            System.out.println(parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()))));
            Map response=parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println( "hope"+response.get("result"));


            LinkedHashMap allItems = new LinkedHashMap();
            allItems=(LinkedHashMap)response.get("result");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadJsonEditProfile(String inputUrl, String userid, String firstname, String lastname, String bio, String grade, String sex, String dorm) {
        ConnectionRequest req=new ConnectionRequest();
        String newinput = inputUrl+"?userId="+userid+"&userFirst="+firstname+"&userLast="+lastname+"&bio="+bio+"&grade="+grade+"&sex="+sex+"&dorm="+dorm;

        req.setUrl(newinput);

        req.setPost(false);
        // req.addRequestHeader("numSlots","4");
        //req.addRequestHeader("privacy", "false");
        // req.addRequestHeader("destination","Starbucks");
        //string key, string value?
        req.setHttpMethod("GET");
        NetworkManager.getInstance().addToQueueAndWait(req);
        JSONParser parser=new JSONParser();
        try {
            Hashtable result =parser.parse(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println("test"+result);
            System.out.println(parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()))));
            Map response=parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData())));
            System.out.println( "hope"+response.get("result"));


            LinkedHashMap allItems = new LinkedHashMap();
            allItems=(LinkedHashMap)response.get("result");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //return (null);
    }

}
