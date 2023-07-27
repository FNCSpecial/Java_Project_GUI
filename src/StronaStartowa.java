import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class StronaStartowa implements ActionListener {




    public boolean visible = false;


    boolean Visible(boolean visible){

        if (visible == true ){
            visible = false;
        }
        else  {
            visible = true;
        }
      return visible;
    }


        JFrame frame = new JFrame();
        JButton klient = new JButton("Klient");
        JButton admin = new JButton("Admin");
        JLabel witaj = new JLabel("Witaj w aplikacji Ksiegarnia ");
        JLabel wybierz = new JLabel("wybierz czy jestes klientem czy administratorem");




    StronaStartowa(){
        klient.setBounds(50,80,150,70);
        admin.setBounds(210,80,150,70);

        klient.addActionListener(this);
        admin.addActionListener(this);

        witaj.setBounds(120,10,200,30);
        wybierz.setBounds(70,30,300,30);



        frame.add(witaj);
        frame.add(wybierz);
        frame.add(klient);
        frame.add(admin);



        frame.setTitle("Ksiegarnia");
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,220);
        frame.setLayout(null);
        frame.setVisible(Visible(visible));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==klient){
           LogowanieKlienta logowanieKlienta = new LogowanieKlienta();

        }
        if (e.getSource()==admin){
            Logowanie logowanie = new Logowanie();

        }
    }
}
