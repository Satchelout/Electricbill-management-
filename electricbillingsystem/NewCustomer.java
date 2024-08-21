
package electricbillingsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField tname,taddress,tstate,tcity,temail,tphone;
    JButton next ,cancel;
    JLabel lblmeter;
    NewCustomer() {
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading = new JLabel("New Customer ");
        heading.setBounds(170,20,200,40);
        heading.setFont(new Font("System",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name :");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        tname=new JTextField();
        tname.setBounds(240,80,200,20);
        p.add(tname);
        
        JLabel lblmeterno = new JLabel("Meter Number  :");
        lblmeterno.setBounds(100,120,100,20);
        p.add(lblmeterno);
        lblmeter = new JLabel(" ");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);
        
        Random ran=new Random();
        long number =ran.nextLong() % 1000000;
        lblmeter.setText("    "+ Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        taddress=new JTextField();
        taddress.setBounds(240,160,200,20);
        p.add(taddress);
        
        JLabel lblstate = new JLabel("State :");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        tstate=new JTextField();
        tstate.setBounds(240,240,200,20);
        p.add(tstate);
        
        JLabel lblcity = new JLabel("City :");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        tcity=new JTextField();
        tcity.setBounds(240,200,200,20);
        p.add(tcity);
        
        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        temail=new JTextField();
        temail.setBounds(240,280,200,20);
        p.add(temail);
        
        JLabel lblphone = new JLabel("Phone No. :");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        tphone=new JTextField();
        tphone.setBounds(240,320,200,20);
        p.add(tphone);
        
        next =new JButton("Next");
        next.setBounds(120,390,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        cancel =new JButton("Cancel");
        cancel.setBounds(250,390,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 =i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name =tname.getText();
            String meter =lblmeter.getText();
            String address=taddress.getText();
            String city=tcity.getText();
            String state =tstate.getText();
            String email=temail.getText();
            String phone_no=tphone.getText();
            
            
            String query1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone_no+"')";
            String query2="insert into login values('"+meter+"','','"+name+"','','')";
            
            try {
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
                
                
                
                new Meterinfo(meter);
            }catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }else {
            setVisible(false);
        }
    }
    public static void main(String args[]) {
        new NewCustomer();
        
    }
} 
