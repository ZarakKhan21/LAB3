import observer.SMSSupportListener;

public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      HexaObserver hexaObserver = new HexaObserver(subject);
      OctalObserver octalObserver = new OctalObserver(subject);
      BinaryObserver binaryObserver = new BinaryObserver(subject);

      System.out.println("\nFirst state change: 15");
      subject.setState(15);

      // Detaching an observer
      subject.detach(octalObserver);

      System.out.println("\nSecond state change: 10");
      subject.setState(10);

      // SMS validation example
      SMSSupportListener smsListener = new SMSSupportListener();
      smsListener.onSMSReceived("This is a short SMS", "+1234567890"); // Valid SMS
      smsListener.onSMSReceived("This is a very long SMS message that exceeds the 160-character limit. "
            + "If it is too long, the system should warn the user to shorten the message.", "+1234567890"); // Too long
   }
}