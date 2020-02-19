package stanislaw.appdemo.utilities;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppdemoUtils {
    public static boolean checkEmailOrPassword(String pattern, String pStr){

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pStr);
        return m.matches();
    }

    public static String authorizationStringGenerator(){
        String randomString ="";
        String signs = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789";

        Random random = new Random();

        for(int i = 0; i < 38; i++){
            int randomNumber = random.nextInt(signs.length());
            randomString += signs.substring(randomNumber, randomNumber+1);
        }

        return randomString;
    }

}
