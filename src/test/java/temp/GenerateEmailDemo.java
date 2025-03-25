package temp;

import java.util.Date;

public class GenerateEmailDemo {
    public static void main(String[] args) {
        Date date = new Date();
        String dateString = date.toString();
       String noSpaceString = dateString.replaceAll("\\s", "");
        String noSpaceAndnoColonsString = noSpaceString.replaceAll(":","");
        String emailWithTimeStamp = noSpaceAndnoColonsString+"@gmail.com";
        System.out.println(emailWithTimeStamp);
    }
}
