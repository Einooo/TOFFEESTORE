import java.io.*;
import java.net.*;
import java.util.*;

public class OTPSender {
    // Replace with your MSG91 API key, sender name, and OTP message template
    private static final String AUTH_KEY = "YOUR_AUTH_KEY";
    private static final String SENDER_ID = "YOUR_SENDER_ID";
    private static final String OTP_MESSAGE_TEMPLATE = "Your OTP is %s";

    public static void main(String[] args) throws Exception {
        String otp = generateOTP();
        String messageBody = String.format(OTP_MESSAGE_TEMPLATE, otp);

        String to = "YOUR_MOBILE_NUMBER";
        String url = "https://api.msg91.com/api/sendhttp.php";

        String data = "authkey=" + AUTH_KEY + "&mobiles=" + to + "&message=" + URLEncoder.encode(messageBody, "UTF-8") + "&sender=" + SENDER_ID + "&route=4&country=91";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("OTP message sent. Response code: " + responseCode);
    }

    private static String generateOTP() {
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }
}
