package UberEats;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.util.Base64;

import java.util.Map;


public class SMS {
    String accountSID = "AC1984c5cc8066bda61cd46e7ff4ea398f";
    String authToken = "81a9d96a87f0cbc798a10a173bfca4ce";
    String fromPhone = "+16174053512";
    String destinationPhone = "+16178428656";
    String bodymessage;

    public void sendmessage(String phonenumber,String message){
        bodymessage = message;
        destinationPhone = phonenumber;
        Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                queryParam("To", destinationPhone).
                queryParam("From", fromPhone).
                queryParam("Body", bodymessage).
                header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                getAsJsonMap();
    }



}
