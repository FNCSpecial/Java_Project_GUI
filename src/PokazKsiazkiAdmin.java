import javax.swing.*;
import javax.tools.JavaFileObject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class PokazKsiazkiAdmin implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
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
    String[] tytul = new String[1000];

    long linie;

    JButton[] edytujbutton = new JButton[1000];
    JButton[] dostarczButton = new JButton[1000];
    JButton[] usunButton = new JButton[1000];
    JLabel[] id_wyswietl = new JLabel[1000];
    JLabel[] ilosc_wyswietl = new JLabel[1000];
    JLabel[] cena_wyswietl = new JLabel[1000];
    JLabel[] autor_wyswietl = new JLabel[1000];
    JLabel[] tytul_wyswietl = new JLabel[1000];


    Path path = Paths.get("Ksiazki.txt");

    File file = new File("Ksiazki.txt");


    Path path1 = Paths.get("temp.txt");
    File temp = new File("temp.txt");


    void Naglowek() {


        JLabel id_tabela = new JLabel("id:");
        JLabel cena_tabela = new JLabel("cena:");
        JLabel ilosc_tabela = new JLabel("ilosc:");
        JLabel tytul_tabela = new JLabel("tytul:");
        JLabel autor_tabela = new JLabel("autor:");

        id_tabela.setBounds(10, 0, 30, 30);
        cena_tabela.setBounds(30, 0, 30, 30);
        ilosc_tabela.setBounds(65, 0, 30, 30);
        tytul_tabela.setBounds(100, 0, 30, 30);
        autor_tabela.setBounds(250, 0, 40, 30);

        panel.add(id_tabela);
        panel.add(cena_tabela);
        panel.add(ilosc_tabela);
        panel.add(tytul_tabela);
        panel.add(autor_tabela);
    }

    void Set() {
        frame.setTitle("Pokaz");
        frame.setResizable(false);
        frame.setLocation(600, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(740, 420);

        panel.setLayout(null);


        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    }

    void Pokaz() {

        try {
            Scanner wczytaj = new Scanner(file);
            wczytaj.useDelimiter(":");
            linie = Files.lines(path).count();
            linie--;

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

                edytujbutton[z] = new JButton("edytuj");
                edytujbutton[z].setBounds(400, y, 80, 30);
                panel.add(edytujbutton[z]);
                edytujbutton[z].addActionListener(this);

                dostarczButton[z] = new JButton("dostawa");
                dostarczButton[z].setBounds(490, y, 80, 30);
                panel.add(dostarczButton[z]);
                dostarczButton[z].addActionListener(this);

                usunButton[z] = new JButton("X");
                usunButton[z].setBounds(580, y, 50, 30);
                usunButton[z].setBackground(Color.red);
                panel.add(usunButton[z]);
                usunButton[z].addActionListener(this);


                id_wyswietl[z] = new JLabel(String.valueOf(id[z]));
                cena_wyswietl[z] = new JLabel(String.valueOf(cena[z]));
                ilosc_wyswietl[z] = new JLabel(String.valueOf(ilosc[z]));
                tytul_wyswietl[z] = new JLabel(tytul[z]);
                autor_wyswietl[z] = new JLabel(autor[z]);


                id_wyswietl[z].setBounds(10, y, 30, 30);
                cena_wyswietl[z].setBounds(40, y, 30, 30);
                ilosc_wyswietl[z].setBounds(70, y, 30, 30);
                tytul_wyswietl[z].setBounds(100, y, 150, 30);
                autor_wyswietl[z].setBounds(250, y, 150, 30);


                panel.add(id_wyswietl[z]);
                panel.add(ilosc_wyswietl[z]);
                panel.add(cena_wyswietl[z]);
                panel.add(autor_wyswietl[z]);
                panel.add(tytul_wyswietl[z]);


                y = y + 35;
                z++;
            }
            panel.setPreferredSize(new Dimension(420, y));


        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Plik nie istnieje lub wystąpił błąd odczytu");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    PokazKsiazkiAdmin() {
        Set();
        Naglowek();
        Pokaz();


        frame.add(jScrollPane);
        frame.setContentPane(jScrollPane);
        frame.setVisible(true);
    }

    void Edytuj(int b){
        int nowacena = cena[b];
        int nowailosc = ilosc[b];
        String nowytytul;
        String nowyautor;

       try {
           nowacena = Integer.parseInt(JOptionPane.showInputDialog(frame, "podaj nowa cene"));
       }
       catch (NumberFormatException e){
           e.printStackTrace();
       }

        try {
            nowailosc = Integer.parseInt(JOptionPane.showInputDialog(frame,"podaj nowa ilosc"));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        nowytytul = JOptionPane.showInputDialog(frame,"podaj nowy tytul");
        nowyautor = JOptionPane.showInputDialog(frame,"podaj nowego autora");
        try {
            Scanner sc = new Scanner(new File(String.valueOf(path)));
            StringBuilder buffer = new StringBuilder();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()).append(System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();
            String oldLine = ":" + id[b] + ":" + cena[b] + ":" + ilosc[b] + ":" + tytul[b] + ":" + autor[b] + ":";
            String newline = ":" + id[b] + ":" + nowacena + ":" + nowailosc + ":" + nowytytul + ":" + nowyautor + ":";
            fileContents = fileContents.replaceAll(oldLine,newline);
            FileWriter writer = new FileWriter(String.valueOf(path));
            writer.append(fileContents);
            writer.flush();
        } catch (IOException e1) {
            System.out.println("blad");
        }
        JOptionPane.showMessageDialog(jScrollPane, "zedytowano");
        frame.dispose();
        new PokazKsiazkiAdmin();
    }

    void Dostawa(int b) {
        int nowailosc;


        try {
            nowailosc = Integer.parseInt(JOptionPane.showInputDialog(frame, "podaj ile ksiazek chcesz dostarczyc"));
        } catch (NumberFormatException e) {
            nowailosc = 0;
        }
        if (nowailosc <= 0) {
            JOptionPane.showMessageDialog(frame, "podaj ilosc wieksza od 0");
        } else {
            nowailosc = nowailosc + ilosc[b];
            try {
                Scanner sc = new Scanner(new File(String.valueOf(path)));
                StringBuilder buffer = new StringBuilder();
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine()).append(System.lineSeparator());
                }
                String fileContents = buffer.toString();
                sc.close();
                String oldLine = ":" + id[b] + ":" + cena[b] + ":" + ilosc[b] + ":" + tytul[b] + ":" + autor[b] + ":";
                String newline = ":" + id[b] + ":" + cena[b] + ":" + nowailosc + ":" + tytul[b] + ":" + autor[b] + ":";
                fileContents = fileContents.replaceAll(oldLine, newline);
                FileWriter writer = new FileWriter(String.valueOf(path));
                writer.append(fileContents);
                writer.flush();
            } catch (IOException e1) {
                System.out.println("blad");
            }
            JOptionPane.showMessageDialog(jScrollPane, "dostarczono");
            frame.dispose();
            new PokazKsiazkiAdmin();
        }
    }

    void Usun(int b){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

            String lineToRemove = ":" + id[b] + ":" + cena[b] + ":" + ilosc[b] + ":" + tytul[b] + ":" + autor[b] + ":";
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
           new PokazKsiazkiAdmin();
            }

        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int b = 0; b < i; b++) {
            if (e.getSource() == edytujbutton[b]) {
                int wybor = JOptionPane.showConfirmDialog(jScrollPane, "czy napewno chcesz edytowac ksiazke " + tytul[b]);
                if (wybor == 0) {
                    Edytuj(b);
                }
            }


            if (e.getSource() == dostarczButton[b]) {
                int wybor = JOptionPane.showConfirmDialog(jScrollPane, "czy napewno chcesz dostarczyc ksiazke " + tytul[b]);
                if (wybor == 0) {
                    Dostawa(b);
                }
            }


            if (e.getSource() == usunButton[b]) {
                int wybor = JOptionPane.showConfirmDialog(jScrollPane, "czy napewno chcesz usunac ksiazke " + tytul[b]);
                if (wybor == 0) {
                    Usun(b);
                }
            }

        }
    }
}