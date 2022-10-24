
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class TimerEvents extends JFrame {
    
    public TimerEvents() {
        super();
        
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        javax.swing.Timer time = new javax.swing.Timer(10_000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("(javax.swing.Timer) This prints every 10 sec");
            }
        });
        time.setRepeats(true);
        time.start();
        
        java.util.Timer time2 = new java.util.Timer();
        time2.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("(java.util.Timer) This prints every 2 sec");
            }
        }, 0, 2_000);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimerEvents().setVisible(true);
            }
        });
    }
}
