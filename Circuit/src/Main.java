import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JProgressBar;
//Submit this solution to use the callable...
//do what we just did, but with the callable instead of the runnable
//How do you get a future?
//May want to even delete runnable out to see if you've done this right

public class Main {

    private JFrame frame;
    private JTextField txtUseAssemblerrocksSelect;
    Thread myThread;
    Database myDb;
    public JButton btnExecuteSql;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        txtUseAssemblerrocksSelect = new JTextField();
        txtUseAssemblerrocksSelect.setText("USE AssemblerRocks\r\nSELECT *\r\nFROM Student");
        txtUseAssemblerrocksSelect.setBounds(67, 11, 297, 84);
        frame.getContentPane().add(txtUseAssemblerrocksSelect);
        txtUseAssemblerrocksSelect.setColumns(10);
        
        btnExecuteSql = new JButton("Execute SQL");
        btnExecuteSql.addActionListener(new BtnExecuteSqlActionListener());
        btnExecuteSql.setBounds(196, 170, 109, 23);
        frame.getContentPane().add(btnExecuteSql);
    }
    private class BtnExecuteSqlActionListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            btnExecuteSql.setEnabled(false);
            btnExecuteSql.setText("Checking...");
            
           
          //  myThread = new Thread(myDb);
           
            //Thread myThreadHound = new Thread(new HoundCatcher()); // <--must create an instance of the business logic
            //myThread.start();
           // myThreadHound.start();
            
            
            myDb = new Database(txtUseAssemblerrocksSelect.getText());
            
            ExecutorService executor = Executors.newCachedThreadPool();
            
            Future<Integer> future = executor.submit(new Database(txtUseAssemblerrocksSelect.getText()));
            
            executor.shutdown();
            
            try {
                JOptionPane.showMessageDialog(null, "Statement Executed. "
                        + "Rows affected: " + future.get());
            } catch (HeadlessException | InterruptedException
                    | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            btnExecuteSql.setEnabled(true);
            btnExecuteSql.setText("Execute Sql");
            
            
    }
        
    
   /* class HoundCatcher implements Runnable{

        public void run() {
            try {
                myThread.join();
                btnExecuteSql.setEnabled(false);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Statement Executed. "
                    + "Rows affected: " + myDb.rowsAffectedFromLastExecuteStatement);
        }
        }*/
    }
}
