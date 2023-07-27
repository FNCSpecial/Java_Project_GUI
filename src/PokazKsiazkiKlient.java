import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class PokazKsiazkiKlient implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel=new JPanel();
    JScrollPane jScrollPane = new JScrollPane(panel);


    int i = 0;
    int y = 30;
    int z = 0;
    int c_id = 0;
    int c_cena = 0;
    int c_ilosc = 0;
    int c_autor = 0;
    int c_tytul = 0;

    int[] id = new int[1000];
    int[] cena = new int[1000];
    int[] ilosc = new int[1000];
    String[] autor = new String[1000];
    String[] tytul= new String[1000];

    String imie;
    String nazwisko;
    String telefon;

    long linie ;

    JButton[] zamowbutton = new JButton[1000];
    JLabel[] id_wyswietl = new JLabel[1000];
    JLabel[] ilosc_wyswietl = new JLabel[1000];
    JLabel[] cena_wyswietl = new JLabel[1000];
    JLabel[] autor_wyswietl = new JLabel[1000];
    JLabel[] tytul_wyswietl = new JLabel[1000];



    Path path = Paths.get("Ksiazki.txt");

    File file = new File("Ksiazki.txt");
    File klient = new File("Klient.txt");
    File zamowienia = new File("Zamowienia.txt");

    void Naglowek(){


       // JLabel id_tabela = new JLabel("id:");
        JLabel cena_tabela = new JLabel("cena:");
        JLabel ilosc_tabela = new JLabel("ilosc:");
        JLabel tytul_tabela = new JLabel("tytul:");
        JLabel autor_tabela = new JLabel("autor:");

      //  id_tabela.setBounds(10,0,30,30);
        cena_tabela.setBounds(10,0,30,30);
        ilosc_tabela.setBounds(50,0,30,30);
        tytul_tabela.setBounds(100,0,30,30);
        autor_tabela.setBounds(250,0,40,30);

       // panel.add(id_tabela);
        panel.add(cena_tabela);
        panel.add(ilosc_tabela);
        panel.add(tytul_tabela);
        panel.add(autor_tabela);
    }

    void Set(){
        frame.setTitle("Pokaz");
        frame.setResizable(false);
        frame.setLocation(600, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(540, 420);

        panel.setLayout(null);





        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    }

    void Pokaz() {

        try {
            Scanner wczytaj = new Scanner(file);
            wczytaj.useDelimiter(":");
            linie = Files.lines(path).count();
            linie --;

            while (linie >= i) {

                id[c_id] = Integer.parseInt(wczytaj.next());
                cena[c_cena] = Integer.parseInt(wczytaj.next());
                ilosc[c_ilosc] = Integer.parseInt(wczytaj.next());
                tytul[c_tytul] = wczytaj.next();
                autor[c_autor] = wczytaj.next();

                wczytaj.next();

                c_id++;
                c_cena++;
                c_ilosc++;
                c_autor++;
                c_tytul++;

                i++;

                zamowbutton[z] = new JButton("zamow");
                zamowbutton[z].setBounds(400, y, 80, 30);
                panel.add(zamowbutton[z]);
                zamowbutton[z].addActionListener(this);



            //    id_wyswietl[z] = new JLabel(String.valueOf(id[z]));
                cena_wyswietl[z] = new JLabel(String.valueOf(cena[z]));
                ilosc_wyswietl[z] = new JLabel(String.valueOf(ilosc[z]));
                tytul_wyswietl[z] = new JLabel(tytul[z]);
                autor_wyswietl[z] = new JLabel(autor[z]);


           ///     id_wyswietl[z].setBounds(10,y,30,30);
                cena_wyswietl[z].setBounds(10,y,30,30);
                ilosc_wyswietl[z].setBounds(50,y,30,30);
                tytul_wyswietl[z].setBounds(100,y,150,30);
                autor_wyswietl[z].setBounds(250,y,150,30);


            //    panel.add(id_wyswietl[z]);
                panel.add(ilosc_wyswietl[z]);
                panel.add(cena_wyswietl[z]);
                panel.add(autor_wyswietl[z]);
                panel.add(tytul_wyswietl[z]);




                y = y+35;
                z++;
            }
            panel.setPreferredSize(new Dimension(420,y));


        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Plik nie istnieje lub wystąpił błąd odczytu");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    void Klient(){
        try {
            Scanner wczytaj = new Scanner(klient);
            wczytaj.useDelimiter(":");
            imie=wczytaj.next();
            nazwisko=wczytaj.next();
            telefon=wczytaj.next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void Zamow(int b) {
        Klient();
        int ilosc_ksiazek;
        try {
            ilosc_ksiazek = Integer.parseInt(JOptionPane.showInputDialog(jScrollPane, "Podaj ilosc jaka chcesz zamowic"));
        } catch (Exception e1) {
            ilosc_ksiazek = 0;
        }

        if (ilosc_ksiazek > ilosc[b] || ilosc_ksiazek <= 0) {
            JOptionPane.showMessageDialog(jScrollPane, "nie mamy tyle na stanie lub podales liczbne mniejsza lub rowna 0");
        }
        else {

            int ilosc_po_zamowieniu = ilosc[b] - ilosc_ksiazek;

            try {
                Scanner sc = new Scanner(new File(String.valueOf(path)));
                StringBuilder buffer = new StringBuilder();
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine()).append(System.lineSeparator());
                }
                String fileContents = buffer.toString();
                sc.close();
                String oldLine = ":" + id[b] + ":" + cena[b] + ":" + ilosc[b] + ":" + tytul[b] + ":" + autor[b] + ":";
                String newLine = ":" + id[b] + ":" + cena[b] + ":" + ilosc_po_zamowieniu + ":" + tytul[b] + ":" + autor[b] + ":";
                fileContents = fileContents.replaceAll(oldLine, newLine);
                FileWriter writer = new FileWriter(String.valueOf(path));
                writer.append(fileContents);
                writer.flush();
            } catch (IOException e1) {
                System.out.println("blad");
            }
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Zamowienia.txt", true)))) {
                out.println(":"+imie+":"+nazwisko+":"+telefon+":"+ilosc_ksiazek+":"+autor[b]+":"+tytul[b]+":"+cena[b]*ilosc_ksiazek+":");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(jScrollPane, "zamowiono");

            frame.dispose();
            new PokazKsiazkiKlient();
        }

    }

    PokazKsiazkiKlient() {

        Set();
        Naglowek();
        Pokaz();


        frame.add(jScrollPane);
        frame.setContentPane(jScrollPane);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int b=0; b<i ; b++){
           if(e.getSource()==zamowbutton[b]){
             int wybor  = JOptionPane.showConfirmDialog(jScrollPane,"czy napewno chcesz zamówić książkę "+tytul[b]);
             if(wybor ==0){
                 Zamow(b);
             }
           }
       }
    }
}

