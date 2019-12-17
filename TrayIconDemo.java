import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
 
public class TrayIconDemo {
 
    public static void main(String[] args) throws AWTException  {
         
        TrayIconDemo td = new TrayIconDemo();
        td.displayTray();
 
    }
 
    public void displayTray() throws AWTException{
        //Obtain only one instance of the SystemTray object
    	PopupMenu popup = new PopupMenu();
    	MenuItem errorItem = new MenuItem("Error");
       
            MenuItem exitItem = new MenuItem("Exit");
    	
    	
        SystemTray tray = SystemTray.getSystemTray();
        //Creating a tray icon
        ImageIcon icon = new ImageIcon(getClass().getResource("notification.png"));
     System.out.println("kaushik"+icon);
        Image image = icon.getImage();
        System.out.println("pawan"+image);
        //System.out.println(image);
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        
        ;
       
     /*   displayMenu.add(warningItem);
        displayMenu.add(infoItem);
        displayMenu.add(noneItem); */
        popup.add(errorItem);
        popup.addSeparator();
        popup.add(exitItem);
        
        trayIcon.setPopupMenu(popup);
        tray.add(trayIcon);
        trayIcon.displayMessage("Hello, World", "notification demo", MessageType.INFO);
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
            //    errorItem.addActionListener(listener);
               
                    exitItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	System.out.println("HelloIndia123");
                            tray.remove(trayIcon);
                            System.exit(0);
                        }
                    });
            }
        };
        
       
    }
}