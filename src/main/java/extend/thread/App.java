package extend.thread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SendEmailDemostration se = new SendEmailDemostration();
        SaveDataDemostration sa = new SaveDataDemostration();
        se.start();
        sa.start();
    }
}
