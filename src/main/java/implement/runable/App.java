package implement.runable;

public class App {
    public static void main(String[] args) {
        try {
            SendEmailDemostration se = new SendEmailDemostration();
            SaveDataDemostration sa = new SaveDataDemostration();
            Thread t1 = new Thread(se);
            Thread t2 = new Thread(sa);
            t1.start();
            t1.join();
            t2.start();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
