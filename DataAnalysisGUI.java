
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * DataAnalysisGUI Class = Tester class with  main method and GUI
 *
 * @author maro.oroh
 * @version Java 17.0.1
 * @since 2021-12-06
 */

class DrawSmiley extends JPanel
{
   public void paintComponent(Graphics g)
   {//from   w w w . j  a va 2s  .c om
      super.paintComponent(g);

      // draw the face
      g.setColor(Color.YELLOW);
      g.fillOval(10, 10, 200, 200);
      
      // draw the eyes
      g.setColor(Color.BLACK);
      g.fillOval(55, 65, 30, 30);
      g.fillOval(135, 65, 30, 30);
      
      // draw the mouth
      g.fillOval(50, 110, 120, 60);
      
      // "touch up" the mouth into a smile
      g.setColor(Color.YELLOW);
      g.fillRect(50, 110, 120, 30);
      g.fillOval(50, 120, 120, 40);
   } 
}
public class DataAnalysisGUI extends JFrame implements ActionListener{
     //Calculations c;
    
    JRadioButton rb1,rb2;   
    
    JButton jb;   
    
    static JFrame f, application;
    
    static JList b;
    
    static JLabel l;
    
    static JButton j;
    
    static JTextField t;
    
    static String z;
    
    DataAnalysisGUI(){      
        rb1=new JRadioButton("Perform Calculations");    
        rb1.setBounds(100,50,250,30);      
        rb2=new JRadioButton("I just wanna look at graph");    
        rb2.setBounds(100,100,250,30);    
        ButtonGroup bg=new ButtonGroup();    
        bg.add(rb1);bg.add(rb2);    
        jb=new JButton("click");    
        jb.setBounds(100,150,80,30);    
        jb.addActionListener(this);    
        add(rb1);add(rb2);add(jb);    
        setSize(400,400);    
        setLayout(null);    
        setVisible(true);   
        setLocationRelativeTo(null);
        
    }    
    
    
    public static void main(String[] args) {
        Calculations c = new Calculations();
        
        File selectedFile = null;
       // TODO Auto-generated method stub
       ReadFiles s = new ReadFiles();
       JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getName());
        }
       c.exists(selectedFile);
       c.Rows();
       c.convertCSV();
       c.PrintArray();
       c.createDateArray();
       c.createDataArray();
       c.printDArray();
       c.calcMethod();
       z = c.calcMethod();
        
        f = new JFrame("JTable Sample");
        Container content = f.getContentPane();
        String rows[][] = c.getArray();
        String columns[] = { "Date", "Open", "High", "Low", "Close", "Adj Close", "Volume" };
        JTable table = new JTable(rows, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        content.add(scrollPane, BorderLayout.CENTER);
        f.setSize(600, 800);
        f.setVisible(true);
        
        
        DrawSmiley panel = new DrawSmiley();
        
        panel.setBounds(600, 200, 60, 70);
        
        panel.setBounds(500, 20, 22, 22);
        f.add(panel);
        panel.setBounds(500, 20, 22, 22);
        //app.setSize(300, 300);
        f.setVisible(true);
        
        
 
        //f.show();
        new DataAnalysisGUI();
       
        
    }
    
     public void actionPerformed(ActionEvent e){    
        if(rb1.isSelected()){    
            JOptionPane.showMessageDialog(this,"Here are results"); 
            JOptionPane.showMessageDialog(this, z);
            
            
          
            
        }    
        if(rb2.isSelected()){    
            JOptionPane.showMessageDialog(this,"Enjoy the table");    
        }    
    }
 
    
}
    

