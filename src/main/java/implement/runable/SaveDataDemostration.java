package implement.runable;

public class SaveDataDemostration implements Runnable {
    public void saveData(){
        System.out.println("Saving information....");
        for(int i = 0; i< 20; i++){
            System.out.println("Saving information step " + i);
        }
        System.out.println("Successfully saved data!");
    }

    public void run(){
        saveData();
    }
}
