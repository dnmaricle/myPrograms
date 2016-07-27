import java.util.concurrent.Callable;


public class Database implements Callable<Integer>{
    String stringToExecute = "";
    int rowsAffectedFromLastExecuteStatement = 0;
    Database(String pStringToExecute) {
        stringToExecute = pStringToExecute;
    }
    int ExecuteSqlString() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return 10;
    }

    @Override
    public Integer call() throws Exception {
        
       

        return ExecuteSqlString();
    }
}
