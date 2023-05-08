import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class user {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

    public user(String name, String email, String password, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public abstract void register();

    public abstract boolean login(String email, String password);

    public static boolean isValid(String email, String password) {

        String emailRegex = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+$";
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,20}";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return emailMatcher.matches() && passwordMatcher.matches();
    }

}



