import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Zamowienia implements ActionListener {

    JPanel panel = new JPanel();
    JScrollPane jScrollPane = new JScrollPane(panel);

    JFrame frame = new JFrame("Zamowienia");
    JButton zrealizuj[] = new JButton[1000];

    Path path = Paths.get("Zamowienia.txt");
    File file = new File("Zamowienia.txt");


    int x = 10;
    int y = 0;

    int z = 0;

    int c_imie = 0;
    int c_nazwisko = 0;
    int c_telefon = 0;
    int c_ilosc = 0;
    int c_autor = 0;
    int c_tytul = 0;
    int c_cena = 0;

    String[] imie = new String[1000];
    String[] nazwisko = new String[1000];
    String[] telefon = new String[1000];
    int[] ilosc = new int[1000];
    String[] autor = new String[1000];
    String[] tytul = new String[1000];
    int[] cena = new int[1000];

    JLabel[] imie_wyswietl = new JLabel[1000];
    JLabel[] nazwisko_wyswietl = new JLabel[1000];
    JLabel[] telefon_wyswietl = new JLabel[1000];
    JLabel[] ilosc_wyswietl = new JLabel[1000];
    JLabel[] autor_wyswietl = new JLabel[1000];
    JLabel[] tytul_wyswietl = new JLabel[1000];
    JLabel[] cena_wyswietl = new JLabel[1000];


    File temp = new File("temp2.txt");

    int width;
    int height;

    long linie;
    int i = 0;

    void Naglowek() {


        JLabel imie_wyswietl = new JLabel("Imie");
        JLabel nazwisko_wyswietl = new JLabel("Nazwisko");
        JLabel telefon_wyswietl = new JLabel("Telefon");
        JLabel ilosc_wyswietl = new JLabel("ilosc");
        JLabel autor_wyswietl = new JLabel("Autor");
        JLabel tytul_wyswietl = new JLabel("Tytul");
        JLabel cena_wyswietl = new JLabel("cena");

        imie_wyswietl.setBounds(x, y, 50, 30);
        nazwisko_wyswietl.setBounds(x = x + 70, y, 60, 30);
        telefon_wyswietl.setBounds(x = x + 80, y, 50, 30);
        ilosc_wyswietl.setBounds(x = x + 70, y, 50, 30);
        autor_wyswietl.setBounds(x = x + 50, y, 50, 30);
        tytul_wyswietl.setBounds(x = x + 155, y, 50, 30);
        cena_wyswietl.setBounds(x = x + 150, y, 50, 30);

        panel.add(imie_wyswietl);
        panel.add(nazwisko_wyswietl);
        panel.add(telefon_wyswietl);
        panel.add(ilosc_wyswietl);
        panel.add(autor_wyswietl);
        panel.add(tytul_wyswietl);
        panel.add(cena_wyswietl);
    }

    void Pokaz() {
         y=30;
        try {
            Scanner wczytaj = new Scanner(file);
            wczytaj.useDelimiter(":");
            linie = Files.lines(path).count();
            linie--;

            while (linie >= i) {


                imie[c_imie] = wczytaj.next();
                nazwisko[c_nazwisko] = wczytaj.next();
                telefon[c_telefon] = wczytaj.next();
                ilosc[c_ilosc] = Integer.parseInt(wczytaj.next());
                autor[c_autor] = wczytaj.next();
                tytul[c_tytul] = wczytaj.next();
                cena[c_cena] = Integer.parseInt(wczytaj.next());


                wczytaj.next();

                c_imie++;
                c_nazwisko++;
                c_telefon++;
                c_ilosc++;
                c_autor++;
                c_tytul++;
                c_cena++;

                i++;

                zrealizuj[z] = new JButton("zrealizuj");
                zrealizuj[z].setBounds(640, y, 100, 30);
                panel.add(zrealizuj[z]);
                zrealizuj[z].addActionListener(this);


                imie_wyswietl[z] = new JLabel(imie[z]);
                nazwisko_wyswietl[z] = new JLabel(nazwisko[z]);
                telefon_wyswietl[z] = new JLabel(telefon[z]);
                ilosc_wyswietl[z] = new JLabel(String.valueOf(ilosc[z]));
                autor_wyswietl[z] = new JLabel(autor[z]);
                tytul_wyswietl[z] = new JLabel(tytul[z]);
                cena_wyswietl[z] = new JLabel(String.valueOf(cena[z]));


                imie_wyswietl[z].setBounds(10, y, 70, 30);
                nazwisko_wyswietl[z].setBounds(80, y, 70, 30);
                telefon_wyswietl[z].setBounds(160, y, 70, 30);
                ilosc_wyswietl[z].setBounds(240, y, 30, 30);
                autor_wyswietl[z].setBounds(280, y, 150, 30);
                tytul_wyswietl[z].setBounds(440, y, 150, 30);
                cena_wyswietl[z].setBounds(600, y, 30, 30);


                panel.add(imie_wyswietl[z]);
                panel.add(nazwisko_wyswietl[z]);
                panel.add(telefon_wyswietl[z]);
                panel.add(ilosc_wyswietl[z]);
                panel.add(autor_wyswietl[z]);
                panel.add(tytul_wyswietl[z]);
                panel.add(cena_wyswietl[z]);


                y = y + 35;
                z++;
            }
            panel.setPreferredSize(new Dimension(720, y));


        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Plik nie istnieje lub wystąpił błąd odczytu");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void Set() {
        frame.setTitle("Zamowienia");
        frame.setResizable(false);
        frame.setLocation(400, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 420);

        panel.setLayout(null);


        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    }

    void Zrealizuj(int b){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

            String lineToRemove = ":" + imie[b] + ":" + nazwisko[b] + ":" + telefon[b] +":" + ilosc[b] + ":" + autor[b] + ":" + tytul[b] + ":" +cena[b] + ":";
            String currentLine;


            while((currentLine = reader.readLine()) != null){
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            FileChannel src = new FileInputStream(temp).getChannel();
            FileChannel dest = new FileOutputStream(file).getChannel();
            dest.transferFrom(src, 0, src.size());

            frame.dispose();
            new Zamowienia();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    Zamowienia() {
        Naglowek();

        Set();
        Pokaz();

        frame.add(jScrollPane);
        frame.setContentPane(jScrollPane);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int b = 0; b < i; b++) {
            if (e.getSource() == zrealizuj[b]) {
                int wybor = JOptionPane.showConfirmDialog(jScrollPane, "czy napewno chcesz zrealizować zamówienie " + tytul[b]);
                if (wybor == 0) {
                    Zrealizuj(b);
                }
            }
        }
    }
}

