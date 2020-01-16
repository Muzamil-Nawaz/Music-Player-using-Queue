package dsaproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class DsaProject implements MouseListener{
    JLabel playLbl ;
    DsaProject(){
        JFrame mainFrame = new JFrame("Music Player");
        ImageIcon img = new ImageIcon("download.png");
        JLabel bgLabel = new JLabel(img);
        bgLabel.setSize(900,700);
        
        
        JLabel lbl = new JLabel(" Click this Icon to select music:");
        lbl.setFont(new Font("Algerian",Font.BOLD,20));
        lbl.setForeground(Color.black);
        lbl.setBounds(250,30,400,30);
        
        ImageIcon playImg = new ImageIcon("icon.png"); 
        playLbl = new JLabel(playImg);
        playLbl.setBounds(100,90,600,200);
        playLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playLbl.addMouseListener(this);
        
        
        mainFrame.add(playLbl);
        
        mainFrame.add(lbl);
            
        //mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setSize(800,700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(bgLabel);
        
        
    }
    public static void main(String[] args) {
        DsaProject demo = new DsaProject();


    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        new Player();
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
      
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
