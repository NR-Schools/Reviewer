
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class MouseEvents extends JFrame {
    
    public MouseEvents() {
        super();
        
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited\n");
            }
        });
        
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged\n");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved\n");
            }
        });
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MouseEvents().setVisible(true);
            }
        });
    }
}
