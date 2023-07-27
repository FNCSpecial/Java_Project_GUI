import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Dodaj implements ActionListener {

    void Tworzenie() {
        new File("Ksiazki.txt");
    }

    int WpiszID() {
        int noweID = 0;
        try {
            File plikID = new File("id.txt");
            if(plikID.createNewFile()) {
                try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("id.txt", false)))) {
                    out.println(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                else{

               try{
                   Scanner odczytID = new Scanner(plikID);
                noweID = odczytID.nextInt();
            } catch (IOException e) {
                e.printStackTrace();
            }

            }




            } catch (IOException ex) {
            ex.printStackTrace();
        }




        return noweID;
    }


    JFrame frame = new JFrame();

    JLabel PodajTytul = new JLabel("Podaj Tytuł:");
    JLabel PodajAutora = new JLabel("Podaj Autora:");
    JLabel PodajCene = new JLabel("Podaj Cene:");
    JLabel PodajIlosc = new JLabel("PodajIlosc");



    JTextField WpiszTytul = new JTextField("");
    JTextField WpiszAutora = new JTextField("");
    JTextField WpiszCene = new JTextField();
    JTextField WpiszIlosc = new JTextField();

    JButton Dodaj = new JButton("Dodaj");



    Dodaj(){


        PodajTytul.setBounds(100,30,200,30);
        WpiszTytul.setBounds(100,70,200,30);

        PodajAutora.setBounds(100,100,200,30);
        WpiszAutora.setBounds(100,130,200,30);

        PodajCene.setBounds(100,160,200,30);
        WpiszCene.setBounds(100,190,200,30);

        PodajIlosc.setBounds(100,220,200,30);
        WpiszIlosc.setBounds(100,250,200,30);

        Dodaj.setBounds(150,290,100,50);
        Dodaj.addActionListener(this);


        frame.add(PodajTytul);
        frame.add(WpiszTytul);

        frame.add(PodajAutora);
        frame.add(WpiszAutora);

        frame.add(PodajCene);
        frame.add(WpiszCene);

        frame.add(PodajIlosc);
        frame.add(WpiszIlosc);

        frame.add(Dodaj);


        frame.setTitle("Dodaj");
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setVisible(true);
    }

    boolean Walidacja() {
        String Tytul,Autor;


       try {
           Integer.parseInt(WpiszCene.getText());
        }
       catch (NumberFormatException nfe){
            return false;
       }

       try {
           Integer.parseInt(WpiszIlosc.getText());
       }
       catch (NumberFormatException nfe){
           return false;
       }



        Tytul = WpiszTytul.getText();
        Autor = WpiszAutora.getText();


        if(Tytul.matches(".*\\d.*")){
            return false;
        }
        return !Autor.matches(".*\\d.*");
    }


    void Wpisanie (){

        int ID,Cena,Ilosc;
        String Tytul,Autor;

        ID = WpiszID();
        ID ++;

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("id.txt", false)))) {
            out.println(ID);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Cena = Integer.parseInt(WpiszCene.getText());
        Ilosc = Integer.parseInt(WpiszIlosc.getText());

        Tytul = WpiszTytul.getText();
        Autor = WpiszAutora.getText();

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Ksiazki.txt", true)))) {
            out.println(":"+ID+":"+Cena+":"+Ilosc+":"+Tytul+":"+Autor+":");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Dodaj){

            if(Walidacja()){
                Tworzenie();
                Wpisanie();
                JOptionPane.showMessageDialog(frame,"Dodano!");
            }
            else {
                JOptionPane.showMessageDialog(frame,"Podaj poprawne wartosci!");
            }

        }
    }
}
