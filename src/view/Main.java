package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Home uf = new Home();
                JFrame jf = new JFrame("Digital Quest");
                jf.setContentPane(uf);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setSize(1000, 320);
                jf.setVisible(true);
                
            }
        });
        
        
        
    }
    
}
