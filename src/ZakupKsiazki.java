import javax.swing.*;

public class ZakupKsiazki {
    JFrame frame =  new JFrame();

    JLabel PodajID = new JLabel("wpisz ID książki do zakupu:");
    JLabel PodajImie = new JLabel("Wpisz swoje imie");
    JLabel PodajNaziwsko = new JLabel("Wpisz swoje nazwisko:");

    JTextField WpiszID = new JTextField();
    JTextField WpiszImie = new JTextField();
    JTextField WpiszNazwisko = new JTextField();

    JButton Zamow = new JButton("Zamów!");

    ZakupKsiazki(){

        PodajID.setBounds(100,10,200,30);
        WpiszID.setBounds(100,40,200,30);

        PodajImie.setBounds(100,70,200,30);
        WpiszImie.setBounds(100,100,200,30);

        PodajNaziwsko.setBounds(100,130,200,30);
        WpiszNazwisko.setBounds(100,160,200,30);

        Zamow.setBounds(150,200,100,50);

        frame.add(PodajID);
        frame.add(PodajImie);
        frame.add(PodajNaziwsko);
        frame.add(WpiszID);
        frame.add(WpiszImie);
        frame.add(WpiszNazwisko);
        frame.add(Zamow);

        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setTitle("Zakup");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
