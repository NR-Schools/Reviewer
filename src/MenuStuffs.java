
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class MenuStuffs extends JFrame {
    
    JMenuBar menubar;
    
    JMenu reg_items, rb_items, cm_1, cm_2, cm_3;
    JPopupMenu popMenu;
    
    JSeparator sep;
    JMenuItem reg_item_1, reg_item_2;
    JMenuItem pop_item_1, pop_item_2;
    
    JRadioButtonMenuItem rb_item_1, rb_item_2, rb_item_3;
    ButtonGroup bg;
    
    public MenuStuffs() {
        super();
        
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        reg_items = new JMenu("Normal");
        rb_items = new JMenu("RB");
        popMenu = new JPopupMenu();
        
        cm_1 = new JMenu("cm1");
        cm_2 = new JMenu("cm2");
        cm_3 = new JMenu("cm3");
        
        
        sep = new JSeparator();
        reg_item_1 = new JMenuItem("reg1");
        reg_item_2 = new JMenuItem("reg2");
        
        pop_item_1 = new JMenuItem("pop1");
        pop_item_2 = new JMenuItem("pop2");
        
        rb_item_1 = new JRadioButtonMenuItem("rb1");
        rb_item_2 = new JRadioButtonMenuItem("rb2");
        rb_item_3 = new JRadioButtonMenuItem("rb3");
        
        bg = new ButtonGroup();
        
        menubar = new JMenuBar();
        
        /////////////////////////////////////////////////////////
        
        pop_item_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Content", "Title", JOptionPane.WARNING_MESSAGE);
                
                int res = JOptionPane.showConfirmDialog(rootPane, "Confirm??");
                System.out.println(res);
                
                String text = JOptionPane.showInputDialog(rootPane, "select");
                System.out.println(text);
                
                int res2 = JOptionPane.showOptionDialog(rootPane, "options?", "Title", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"1", "2", "3"}, "1");
                System.out.println(res2);
            }
        });
        
        /////////////////////////////////////////////////////////
        
        menubar.add(reg_items);
        menubar.add(rb_items);
        menubar.add(popMenu);
        
        
        reg_items.add(reg_item_1);
        reg_items.add(sep);
        reg_items.add(reg_item_2);
        
        rb_items.add(rb_item_1);
        rb_items.addSeparator();
        rb_items.add(rb_item_2);
        rb_items.addSeparator();
        rb_items.add(rb_item_3);
        
        bg.add(rb_item_1);
        bg.add(rb_item_2);
        bg.add(rb_item_3);
        
        popMenu.add(pop_item_1);
        popMenu.add(pop_item_2);
        
        
        cm_2.add(cm_3);
        cm_1.add(cm_2);
        menubar.add(cm_1);
        
        
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        
        
        
        this.setJMenuBar(menubar);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuStuffs().setVisible(true);
            }
        });
    }
}
