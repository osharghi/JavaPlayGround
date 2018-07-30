import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import javax.swing.table.DefaultTableModel;

public class WebFrame extends JFrame {

    protected DefaultTableModel model;
    protected int runningCount;
    protected int completedCount;
    protected long elapsedTime;
    protected long startTime;
    protected JLabel runningLabel;
    protected JLabel completedLabel;
    protected JLabel elapsedLabel;
    private JProgressBar progressBar;
    private JButton singleFetchB;
    private JButton concurrentFetchB;
    private JButton stopButton;
    private JTextField workerLimit;
    private static ArrayList<String> urlList;
    private Launcher launcher;
    
    
    public static void main(String[] args) {
    	
        new WebFrame(args[0]);
        
    }
    
    public WebFrame(String fileName){
        urlList = new ArrayList<>();
        model = new DefaultTableModel(new String[] { "url", "status"}, 0); 
        JTable table = new JTable(model); 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        File file = new File(fileName);
        BufferedReader br = null;
        try {             
            br = new BufferedReader(new FileReader(file));
            String urlname;
            while ((urlname = br.readLine()) != null) {
                model.addRow(new String[] { urlname, ""}); 
                urlList.add(urlname);
            }
        }
        catch(Exception e){
                e.printStackTrace();
        }
        finally
        {
	        	try {
				if (br != null)
				{
					br.close();
				}
			} 
        		catch (IOException ex) 
        		{
				ex.printStackTrace();
			}

        }
        

        JScrollPane scrollpane = new JScrollPane(table); 
        scrollpane.setPreferredSize(new Dimension(600,300)); 
            
        singleFetchB = new JButton("Single Thread Fetch");
        concurrentFetchB = new JButton("Concurrent Fetch");
        stopButton = new JButton("Stop"); 
        stopButton.setEnabled(false);
        
        workerLimit = new JTextField();
        workerLimit.setPreferredSize(new Dimension(30,20));
        workerLimit.setMaximumSize(workerLimit.getPreferredSize());                
        
        Box Hbox1 = Box.createHorizontalBox();
        Hbox1.add(singleFetchB);
        Hbox1.add(Box.createHorizontalStrut(10));
        Hbox1.add(concurrentFetchB);             
        Hbox1.add(Box.createHorizontalStrut(20));
        Hbox1.add(workerLimit);
        Hbox1.add(Box.createHorizontalStrut(300));
        Hbox1.add(stopButton);

        runningLabel = new JLabel("Running: 0");
        completedLabel = new JLabel("Completed: 0");
        elapsedLabel = new JLabel("Elapsed: ");
                
        Box Hbox2 = Box.createHorizontalBox();        
        Hbox2.add(runningLabel);
        Hbox2.add(Box.createHorizontalStrut(20));
        Hbox2.add(completedLabel);
        Hbox2.add(Box.createHorizontalStrut(20));
        Hbox2.add(elapsedLabel);
        Hbox2.add(Box.createHorizontalStrut(20));
        
        progressBar = new JProgressBar(0, model.getRowCount());
        Box Hbox3 = Box.createHorizontalBox();
        Hbox3.add(progressBar);

        Box VBox = Box.createVerticalBox();      
        VBox.add(Hbox1);
        VBox.add(Box.createVerticalStrut(10));
        VBox.add(Hbox2);
        VBox.add(Box.createVerticalStrut(10));
        VBox.add(Hbox3);
        VBox.add(Box.createVerticalStrut(10));
                
        for (Component comp:VBox.getComponents())
        {
                ((JComponent)comp).setAlignmentX(Box.LEFT_ALIGNMENT);
        }
        
         singleFetchB.addActionListener(new ActionListener(){       
            public void actionPerformed(ActionEvent e){
                startTime = System.currentTimeMillis();
                stopButton.setEnabled(true);
                singleFetchB.setEnabled(false);
                concurrentFetchB.setEnabled(false);
                runningCount = 0;
                completedCount = 0;
                progressBar.setValue(0);
                runningLabel.setText("Running: 0");
                completedLabel.setText("Completed: 0");
                elapsedLabel.setText("Elapsed: ");
                
                //reset the table status
                for (int i = 0; i < model.getRowCount(); i++){ 
                    model.setValueAt("", i, 1);
                }
                
                launcher = new Launcher(urlList, 1);
                launcher.start();                
            }
        });
                 
        concurrentFetchB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startTime = System.currentTimeMillis();
                stopButton.setEnabled(true);
                singleFetchB.setEnabled(false);
                concurrentFetchB.setEnabled(false);          
                runningCount= 0;
                completedCount = 0;
                progressBar.setValue(0);
                runningLabel.setText("Running: 0");
                completedLabel.setText("Completed: 0");
                elapsedLabel.setText("Elapsed: ");
                
                                
                //reset the table status
                for (int i = 0; i < model.getRowCount(); i++){
                    model.setValueAt("", i, 1);
                }
                
                try{
                    int numWorkers = Integer.parseInt(workerLimit.getText());
                    launcher = new Launcher(urlList, numWorkers);
                    launcher.start();
                }
                catch(NumberFormatException f){
                    singleFetchB.setEnabled(true);
                    concurrentFetchB.setEnabled(true);
                    stopButton.setEnabled(false);
                    System.out.println("Enter an integer");
                }
            }
        });        
         
        stopButton.addActionListener(new ActionListener(){        
            public void actionPerformed(ActionEvent e){
                stopButton.setEnabled(false);
                singleFetchB.setEnabled(true);
                concurrentFetchB.setEnabled(true);
                launcher.interrupt();
            }
        });
        
        this.setTitle("WebLoader");
        this.setLayout(new BorderLayout());
        this.add(scrollpane, BorderLayout.NORTH);
        this.add(VBox, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    
    
    private class Launcher extends Thread 
    {
        ArrayList<String> urlList;
        Semaphore sem ;
        
        public Launcher(ArrayList<String> urls, int numWorkers){
            urlList = urls;
            sem = new Semaphore(numWorkers);            
        }
        
        @Override
        public void run() 
        {
            ArrayList<Thread> threads = new ArrayList<>();
            
            //increase running count on the JFrame to include Launcher thread
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() 
                {
                    runningLabel.setText("Running: " + (++runningCount));
                }
            });
            
            //loop that creates the WebWorker threads
            for (int i = 0; i < urlList.size(); i++) {
                WebWorker worker = new WebWorker(urlList.get(i), i, sem, WebFrame.this);
                worker.start();
                threads.add(worker);
            }
            
            for (Thread t :threads){
                try{
                    t.join();
                } 
                catch (InterruptedException e){
                    for (Thread h :threads){
                        h.interrupt();
                    }
                    break;
                }
            }
            
            //Decrease running count on the JFrame to include Launcher thread
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() 
                {
                    runningLabel.setText("Running: " + (--runningCount));
                }
            });
            
            singleFetchB.setEnabled(true);
            concurrentFetchB.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }
    
    public synchronized void completedThread(int row, String currentStatus){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {                    
                model.setValueAt(currentStatus, row, 1);
                completedLabel.setText("Completed: " + (++completedCount));
                progressBar.setValue(completedCount);
            }
        });
    }    
    
}
