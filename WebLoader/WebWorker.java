import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import javax.swing.*;

public class WebWorker extends Thread {
    
     private String urlString;
     private int row;
     private WebFrame webFrame;     
     private Semaphore sem;
     private String status;
     
     public WebWorker(String urlString, int row, Semaphore sem, WebFrame webFrame) {
     	
        this.urlString = urlString;
        this.row = row;       
        this.sem = sem;
        this.webFrame = webFrame;
     }
     
    @Override
    public void run() {
        
        try
        {
            sem.acquire();
            status = "Running";
            
            //Increase running count label on the JFrame
            webFrame.runningLabel.setText("Running: " + (++webFrame.runningCount));
                                    
            InputStream input = null;
            StringBuilder contents = null;
            
            //Setting the table status on the JFrame to "Running"
            webFrame.model.setValueAt(status, row, 1);
            
            
            try {
                URL url = new URL(urlString);
                URLConnection connection = url.openConnection();

                connection.setConnectTimeout(5000);
                connection.connect();

                input = connection.getInputStream();

                BufferedReader reader  = new BufferedReader(new InputStreamReader(input));

                char[] array = new char[1000];
                int len;
                contents = new StringBuilder(1000);
                
                while ((len = reader.read(array, 0, array.length)) > 0) {
                        contents.append(array, 0, len);
                        Thread.sleep(100);
                }
                
                try
                {
                		if (input != null) 
                			input.close();
                }
                catch(IOException ignored) 
                {
                	
                }
                
                Writer writer = null;
                
                try 
                {
                		String name = "Webpage" + (row + 1) + ".txt";
                		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf8"));
                		writer.write(contents.toString());
                
                } 
                catch(IOException e) 
                {
                    e.printStackTrace();
                    
                } 
                finally 
                {
                    try 
                    {
                        writer.close();
                    } 
                    catch(Exception ignored) 
                    {
                    		
                    }
                }
                
                status = "Completed";
                System.out.print(contents.toString());  //displays contents to console

            }
            catch(MalformedURLException ignored) {
            	
            		status = "URL error";
                System.out.println("Exception: " + ignored.toString());
            }
            catch(InterruptedException exception) {
            		status = "Interrupted while running";
            		System.out.println("In inerrupt 1");
                System.out.println("Exception: " + exception.toString());
            }
            catch(IOException ignored) {
            		status = "Input error";
                System.out.println("Exception: " + ignored.toString());
            }
            
            finally 
            {
            	
            		webFrame.completedThread(row, status);
            		//Decrease running count label on the JFrame
                webFrame.runningLabel.setText("Running: " + (--webFrame.runningCount));
                         
                sem.release();
                
                //Get the elpasedTime after the thread is done downloading
                webFrame.elapsedTime = System.currentTimeMillis() - webFrame.startTime;            
                webFrame.elapsedLabel.setText("Elapsed:" + webFrame.elapsedTime);
            	
            }
            
        }
        catch (InterruptedException e)
        {
        		System.out.println("In inerrupt 2");
        } 
    }
}
