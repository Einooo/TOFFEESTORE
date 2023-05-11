import java.io.IOException;

public class SendOTP {
    public static void main(String[] args) {
        try {
            // Command to run the Python script
            String command = "python";
            // Path to the Python script
            String scriptPath = "C:\\Users\\muhan\\IdeaProjects\\TOFFEESTORE\\src\\otpscript.py";
            // Recipient's email
            String senderEmail = "muhannadeion1@gmail.com";
            String sender_password = "hbdlfemvukkbhyri";
            String recipientEmail = "adhamadelmoh@gmail.com" ;


            // Create the process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command, scriptPath, senderEmail, sender_password, recipientEmail);
            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
