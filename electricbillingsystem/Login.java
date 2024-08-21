package electricbillingsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,cancel,signup;
    JTextField username,password;
    Choice logginin;
    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("User Name :");
        lblusername.setBounds(300,20,100,20);
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(400,20,150,20);
        add(username);
        
        
        
        JLabel lblpassword=new JLabel("Password :");
        lblpassword.setBounds(300,60,100,20);
        add(lblpassword);
        
        password=new JTextField();
        password.setBounds(400,60,150,20);
        add(password);
        
        JLabel logininas=new JLabel("Login in as :");
        logininas.setBounds(300,100,100,20);
        add(logininas);
        
        logginin =new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400,100,150,20);
        add(logginin);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        login = new JButton("Login",new ImageIcon(i2));
        login.setBounds(330,160,100,20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel",new ImageIcon(i4));
        cancel.setBounds(450,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        signup = new JButton("Signup");
        signup.setBounds(390,200,100,20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i6 = i5.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i7=new ImageIcon(i6);
        JLabel image=new JLabel(i7);
        image.setBounds(0,0,250,250);
        add(image);
        
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login) {
            String susername=username.getText();
            String spassword=password.getText();
            String user = logginin.getSelectedItem();
            
            try {
                Conn c=new Conn();
                String query = "select * from login where username ='"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    String meter=rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                }else {
                    JOptionPane.showMessageDialog(null, "invalid Login");
                    username.setText("");
                    password.setText("");
                    
                }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()==signup) {
            setVisible(false);
            
            new Signup();
        }else if(ae.getSource()==cancel) {
           setVisible(false); 
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
