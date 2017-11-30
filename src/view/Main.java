package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    static Home home;
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Home home = new Home();
                JFrame jf = new JFrame("Digital Quest");
                jf.setContentPane(home);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setSize(670, 430);
                jf.setVisible(true);
                
            }
        });
        
        
        
    }
    
}
