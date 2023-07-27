import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class LogowanieKlienta implements ActionListener {
    JFrame frame = new JFrame("Logowanie Klienta");
    JButton zaloguj = new JButton("Zaloguj");
    JLabel podajNumerTel = new JLabel("Podaj telefon");
    JLabel podajImie  = new JLabel("Podaj imie");
    JLabel podajNazwisko = new JLabel("Podaj nazwisko");

    JTextField wpisztelefon = new JTextField();
    JTextField wpiszimie = new JTextField();
    JTextField wpisznazwisko = new JTextField();


    String imie, nazwisko;
    String telefon;





    void ustawienie(){
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);

        podajNumerTel.setBounds(160,0,100,30);
        wpisztelefon.setBounds(120,30,150,30);
        podajImie.setBounds(160,60,100,30);
        wpiszimie.setBounds(120,90,150,30);
        podajNazwisko.setBounds(150,120,150,30);
        wpisznazwisko.setBounds(120,150,150,30);



        zaloguj.setBounds(120,200,150,50);
        zaloguj.addActionListener(this);


        frame.add(podajNumerTel);
        frame.add(podajImie);
        frame.add(podajNazwisko);
        frame.add(wpisztelefon);
        frame.add(wpiszimie);
        frame.add(wpisznazwisko);
        frame.add(zaloguj);

    }

   boolean Walidacja(){


       try {
           imie = wpiszimie.getText();
           nazwisko = wpisznazwisko.getText();
           telefon = wpisztelefon.getText();

           try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Klient.txt", false)))) {
               out.println(":"+imie+":"+nazwisko+":"+telefon+":");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
           catch(NumberFormatException nfe){
           return false;
       }

       if(imie.matches(".*\\d.*")){
           return false;
       }
       if(nazwisko.matches(".*\\d.*")){
           return false;
       }
       return telefon.length() == 9 && telefon.matches("[0-9]+");


   }

    LogowanieKlienta(){
        ustawienie();

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == zaloguj){

            if(Walidacja()) {
                new StronaKlienta();
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(frame,"Podaj prawidłowe dane!");
            }
        }
    }
}
