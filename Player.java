package dsaproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Player implements MouseListener,ActionListener {
    JLabel songName;
    LinkedQueue lq;
    AudioStream audio;
    InputStream music;
    JLabel play ,next , prev,pause;
    ImageIcon img2,img3;
    int okToRemove;
    String str;
    JFrame player;
    File f;
    Player(){
        player = new JFrame("Player");
        player.setSize(500,500);
        player.setLayout(null);
        player.setDefaultCloseOperation(player.EXIT_ON_CLOSE);
        player.setLocationRelativeTo(null);
        player.setResizable(false);
        
      try{
      
        JFileChooser selectMusic = new JFileChooser();
        int i = selectMusic.showOpenDialog(selectMusic);
        if( i == JFileChooser.APPROVE_OPTION);
        f = selectMusic.getSelectedFile();
        str = f.getPath();
        if(!str.contains(".wav"))
            JOptionPane.showMessageDialog(null," Please Enter .wav Music File");
        else if(str.contains(".wav")){
            JOptionPane.showMessageDialog(null," Enjoy Your Music");
            playMusic(str);
        }
           
            
        
      
      }catch(NullPointerException e){
        JOptionPane.showMessageDialog(null," Please Select Any Music File");
      }        
        
        
        JLabel playing = new JLabel("Playing :");
        playing.setBounds(30,30,200,30);
        playing.setForeground(Color.CYAN);
        playing.setFont(new Font("New Times Roman",Font.BOLD, 20));
        player.add(playing);
        
        
        
        try{
        songName = new JLabel();
        songName.setBounds(50, 70, 300,30);
        songName.setText(f.getName());
        songName.setForeground(Color.WHITE);
        player.add(songName);
        }
        catch(Exception e){
        }
        
        
        img2 = new ImageIcon("play.jpg");
        play = new JLabel(img2);
        play.addMouseListener(this);
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        play.setBounds(100,200,80,80);
        player.add(play);
        play.setVisible(false);
        
        
        
        img3 = new ImageIcon("pause.jpg");
        pause = new JLabel(img3);
        pause.setBounds(100,200,80,80);
        pause.addMouseListener(this);
        player.add(pause);
        pause.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        
        
        
        
        ImageIcon img = new ImageIcon("playerBg.jpg");
        JLabel bgimg = new JLabel(img);
        bgimg.setSize(500,500);
      
        
        
        
  
        
        ImageIcon backImg  = new ImageIcon("back.jpg");
        prev = new JLabel(backImg);
        prev.setBounds(100,200,80,80);
        prev.addMouseListener(this);
        prev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prev.setBounds(200,200,80,80);
        player.add(prev);
        
        ImageIcon nextImg = new ImageIcon("next.jpg");
        next = new JLabel(nextImg);
        next.setBounds(300,200,80,80);
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        next.addMouseListener(this);
        player.add(next);
        
        
        File folder = new File("C:\\Users\\MUZAMIL NAWAZ\\Documents\\NetBeansProjects\\DsaProject\\Songs");
        File [] songNames = folder.listFiles();
        System.out.println(songNames[2].getName());
        
        lq = new LinkedQueue();
        for(int j= 0; j<songNames.length; j++){
            lq.add(songNames[j]);
            
        }
        JButton back = new JButton("<<==");
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        back.setBounds(30,400,100,30);
        player.add(back);
        back.addActionListener(this);
        player.setVisible(true);
        player.add(bgimg);      
    }
     
 
    public  void playMusic(String filePath){
       
        try{
        music = new FileInputStream(new File(filePath));
        audio = new AudioStream(music);
        AudioPlayer.player.start(audio);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
      
    public static void main(String [] args){
        Player demo = new Player();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == play){
             pause.setVisible(true);
             play.setVisible(false);
             AudioPlayer.player.start(audio);   
            
                               
            }
        if(me.getSource()== pause){
           play.setVisible(true);
           pause.setVisible(false);
          
           AudioPlayer.player.stop(audio);
            
           
        }    
        if(me.getSource()== next){
            
            AudioPlayer.player.stop(audio);
            //String [] arr = str.split("\\");
            System.out.print(str+"\n queue :"+lq.head.next.obj);
            
            
            Object obj = lq.goForward(str,lq);
            str = obj.toString();
            String separator = "\\";
            String[] arr=str.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            

           
            songName.setText(arr[arr.length-1]);
           
         
            playMusic(str);
        }
           if(me.getSource()== prev){
            
                AudioPlayer.player.stop(audio);
              
                Object obj = lq.goBackward(str,lq);
                str = obj.toString();
                
                String separator = "\\";
                String[] arr=str.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
               
             
                songName.setText(arr[arr.length-1]);
                playMusic(str);
        }
        
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        player.setVisible(false);
        AudioPlayer.player.stop(audio);
        new DsaProject();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
