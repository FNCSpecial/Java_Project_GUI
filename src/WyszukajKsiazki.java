import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class WyszukajKsiazki implements ActionListener {
    JFrame frame = new JFrame();
    JLabel PodajTytul = new JLabel("Podaj tytul lub autora ksiazki : ");
    JTextField WpiszTytul = new JTextField();
    JButton Wyszukaj = new JButton("Wyszukaj");

    JLabel[] szukane_wyswietl = new JLabel[1000];
    String[] szukane = new String[1000];

    File file = new File("Ksiazki.txt");
    Path path = Paths.get("Ksiazki.txt");

    File file1 = new File ("Wyszukane.txt");
    Path path1 = Paths.get("Wyszukane.txt");

    void Pokaz(){


        if(file1.length()!=0){

            int i = 0;
            int y = 100;
            long libcza_lini = 0;



            try {
                Scanner wczytaj = new Scanner(file1);
                libcza_lini = Files.lines(path1).count();
                libcza_lini--;

                while (libcza_lini >= i) {
                    szukane[i] = wczytaj.nextLine();
                    szukane_wyswietl[i] =  new JLabel(szukane[i]);
                    szukane_wyswietl[i].setBounds(10,y,800,40);
                    frame.add(szukane_wyswietl[i]);
                    //  System.out.println(szukane[i]);
                    //  System.out.println(szukane_wyswietl[i]);

                    y=y+50;

                    i++;
                }


            }

            catch (IOException e ) {
                e.printStackTrace();
            }




            File file = new File("Wyszukane.txt");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            writer.print("");
            writer.close();
        }






    }

    WyszukajKsiazki(){

        PodajTytul.setBounds(50,10,200,30);
        WpiszTytul.setBounds(50,50,200,30);
        Wyszukaj.setBounds(250,50, 90,30);

        Wyszukaj.addActionListener(this);

        frame.add(PodajTytul);
        frame.add(WpiszTytul);
        frame.add(Wyszukaj);


        Pokaz();
        frame.setTitle("Wyszukaj");
        frame.setResizable(false);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setVisible(true);
    }


    void Szukanie(){


        String name = WpiszTytul.getText();
        Scanner scanner;
        try {
            scanner = new Scanner(file).useDelimiter(",");

            while (scanner.hasNext()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(name)) {
                        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Wyszukane.txt", true)))) {
                            out.println(lineFromFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Wyszukaj){
            Szukanie();
            frame.dispose();
           new WyszukajKsiazki();

        }
    }
}
