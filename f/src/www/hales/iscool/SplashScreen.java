package www.hales.iscool;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import java.io.IOException;

public class SplashScreen extends Form {

    public SplashScreen() {

        try {
            this.getUnselectedStyle().setBgImage(Image.createImage("/coffee.JPG"));
            //this.add(Image.createImage("/coffee.png"));
            this.add(new InfiniteProgress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
