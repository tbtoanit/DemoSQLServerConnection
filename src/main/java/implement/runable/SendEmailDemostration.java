package implement.runable;

public class SendEmailDemostration implements Runnable {
    public void sendEmail(){
        System.out.println("Email is sending....");
        for(int i = 0; i< 20; i++){
            System.out.println("Send emails step " + i);
        }
        System.out.println("Email has been successfully sent!");
    }

    public void run(){
        sendEmail();
    }
}
