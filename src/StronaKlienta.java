import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StronaKlienta implements ActionListener {
    JFrame frame = new JFrame();
    JLabel pokaz_ksiazki = new JLabel("Pokaz ksiazki w ksiegarni");
    JLabel wyszukaj_ksiazki = new JLabel("Wyszukaj ksiazke");
    JButton pokaz = new JButton("Pokaz ksiazki");
    JButton wyszukaj = new JButton("Wyszukaj ksiazki");


    StronaKlienta(){

        pokaz_ksiazki.setBounds(120,10,200,20);
        wyszukaj_ksiazki.setBounds(120,130,200,20);



        pokaz.setBounds(120,40,150,70);
        wyszukaj.setBounds(120,170,150,70);


        pokaz.addActionListener(this);
        wyszukaj.addActionListener(this);


        frame.add(pokaz_ksiazki);
        frame.add(wyszukaj_ksiazki);


        frame.add(pokaz);
        frame.add(wyszukaj);



        frame.setTitle("Klient");
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);


        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pokaz){
            PokazKsiazkiKlient pokazKsiazki = new PokazKsiazkiKlient();
        }
        if(e.getSource()==wyszukaj){
            WyszukajKsiazki wyszukajKsiazki = new WyszukajKsiazki();
        }
    }
}
