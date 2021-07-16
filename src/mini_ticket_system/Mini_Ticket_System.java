
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Mini_Ticket_System implements ActionListener, KeyListener{

    JLabel lbl_header,lbl_to, lbl_from, lbl_adults,lbl_child, lbl_single, lbl_return, lbl_display;
    JTextField txt_to, txt_from;
    JComboBox cb_adults, cb_child;
    JRadioButton r1,r2;
    JButton btn_total;
    String text1;
    double total;
    int adults_count, child_count, sum;
     
    public Mini_Ticket_System() {
        
        JFrame f = new JFrame("Mini Ticket System");
        
        lbl_header = new JLabel("Welcome to Mini Ticket System");
        lbl_header.setBounds(200, 50, 600, 30);
        lbl_header.setFont(new Font("Arial", Font.BOLD, 28));
	f.add(lbl_header);
        
       lbl_to = new JLabel("To");
       lbl_to.setBounds(200,130,50,30);
       f.add(lbl_to);
       
       txt_to = new JTextField();
       txt_to.setBounds(225,130,150,30);
       f.add(txt_to);
       txt_to.addKeyListener(this);  
       
       lbl_from = new JLabel("From");
       lbl_from.setBounds(400,130,50,30);
       f.add(lbl_from);
       
       txt_from = new JTextField();
       txt_from.setBounds(450,130,150,30);
       f.add(txt_from);
       txt_from.addKeyListener(this);  
       lbl_adults = new JLabel("Adults");
       lbl_adults.setBounds(200,200,50,30);
       f.add(lbl_adults);
       
       String a[] = {"1","2","3","4","5"};
       cb_adults = new JComboBox(a);
       cb_adults.setBounds(255,200,50,30);
       f.add(cb_adults);
       
       lbl_child = new JLabel("Child");
       lbl_child.setBounds(400,200,50,30);
       f.add(lbl_child);
       
       String b[] = {"0","1","2","3","4","5"};
       cb_child = new JComboBox(b);
       cb_child.setBounds(450,200,50,30);
       f.add(cb_child);
       
       r1=new JRadioButton(" Single");    
       r2=new JRadioButton(" Return");    
       r1.setBounds(250,250,100,50);    
       r2.setBounds(350,250,100,50);    
       ButtonGroup bg=new ButtonGroup();    
       bg.add(r1);bg.add(r2);    
       f.add(r1);f.add(r2); 
       
       btn_total = new JButton("Total");
       btn_total.setBounds(300,350,100,50);
       btn_total.addActionListener(this);
       f.add(btn_total);
       
       lbl_display = new JLabel();
       lbl_display.setBounds(250,400,500,50);
       f.add(lbl_display);
       f.setSize(800,800);  
       f.setLayout(null);  
       f.setVisible(true);  
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}  

   
    public static void main(String[] args) {
        
       Mini_Ticket_System m =new Mini_Ticket_System();
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
       
        String txt1 = txt_to.getText();
        String txt2 = txt_from.getText();
        if(txt1.length()!=0 && txt2.length()!=0)
        {
            adults_count= Integer.parseInt((String)cb_adults.getSelectedItem());
            child_count= Integer.parseInt((String) cb_child.getSelectedItem());
                if(r1.isSelected()){

                                if(child_count!=0){
                                    total = (adults_count* 10 + child_count *5);   
                                }
                                else{
                                    total = adults_count *10;   
                                }       
                                 String s=Double.toString(total);

                                lbl_display.setText("Total is "+ s);

                                  
                }
                else if(r2.isSelected())
                {
                             if(child_count!=0){
                                    total = (adults_count* 20 + child_count *10);   
                             }
                             else{
                                    total = adults_count *20;   
                                }  
                              String s=Double.toString(total);

                            lbl_display.setText("Total is "+ s);
                }
                else{
                    lbl_display.setText("Please select between Single or Return");
                }
                
               
        }
        else {
            lbl_display.setText("Please enter the values in text box");
        }
        
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    	char c1 = e.getKeyChar();

		if(Character.isLetter(c1) || Character.isWhitespace(c1)) {
			txt_to.setEditable(true);
			txt_from.setEditable(true);
        }
        else{
            txt_to.setEditable(false);
            txt_from.setEditable(false);
            
            lbl_display.setText("Please enter alphabets");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}