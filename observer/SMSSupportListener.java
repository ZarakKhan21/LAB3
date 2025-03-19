package observer;

public class SMSSupportListener {
    public void onSMSReceived(String message, String phoneNumber) {
        if (message.length() > 160) {
            System.out.println("Warning: SMS exceeds 160 characters! Please shorten the message.");
        } else {
            sendSMS(message, phoneNumber);
        }
    }

    private void sendSMS(String message, String phoneNumber) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}