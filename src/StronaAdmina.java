import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StronaAdmina implements ActionListener {
    JFrame frame = new JFrame();
    JButton pokaz = new JButton("Pokaz ksiazki");
    JButton dodaj = new JButton("Dodaj ksiazke");
    JButton zamowienia = new JButton("Pokaz zamowienia");

   void Ustawienie(){
        pokaz.setBounds(40,50,160,90);
        dodaj.setBounds(210,50,160,90);
        zamowienia.setBounds(380,50,160,90);

        pokaz.addActionListener(this);
        dodaj.addActionListener(this);
        zamowienia.addActionListener(this);

        frame.add(pokaz);
        frame.add(dodaj);
        frame.add(zamowienia);

        frame.setTitle("Admin");
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600,250);

    }

    StronaAdmina(){
    Ustawienie();


    frame.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pokaz){
            new PokazKsiazkiAdmin();
        }
        if(e.getSource()==dodaj){
            new Dodaj();
        }
        if(e.getSource()==zamowienia){
            new Zamowienia();
        }
    }
}
