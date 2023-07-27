import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Logowanie implements ActionListener, KeyListener {
    JFrame frame = new JFrame();
    JButton loguj = new JButton("loguj");
    JTextField login = new JTextField("");
    JPasswordField haslo = new JPasswordField("");
    JLabel WprLogin = new JLabel("Wprowadz login");
    JLabel WprHaslo = new JLabel("Wprowadz haslo");





    Logowanie(){
        WprLogin.setBounds(130,0,100,50);
        WprHaslo.setBounds(130,50,100,50);

        loguj.setBounds(120,130,100,50);
        haslo.setBounds(100,90,150,20);
        login.setBounds(100,40,150,20);

        login.addKeyListener(this);
        haslo.addKeyListener(this);
        loguj.addKeyListener(this);
        loguj.addActionListener(this);



        frame.add(WprHaslo);
        frame.add(WprLogin);
        frame.add(loguj);
        frame.add(login);
        frame.add(haslo);

        frame.setLocation(600,200);
        frame.setTitle("Panel Logowania");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(380,250);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loguj){
            String Login = login.getText();
            String Haslo = String.valueOf(haslo.getPassword());

            if (Objects.equals(Login, "admin") && Objects.equals(Haslo, "1234")){
                new StronaAdmina();
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(frame, "wprowadziles bledne dane");
                login.setText("");
                haslo.setText("");
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            String Login = login.getText();
            String Haslo = String.valueOf(haslo.getPassword());

            if (Objects.equals(Login, "admin") && Objects.equals(Haslo, "1234")){
               new StronaAdmina();
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(frame, "wprowadziles bledne dane");
                login.setText("");
                haslo.setText("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
