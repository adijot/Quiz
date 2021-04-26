package oldVersion;

import java.io.*;
import java.util.*;

/**
 * Klasa odpowiedzialna za Quiz
 * @author Adam
 * @version 1.0
 */
public class quizBezGUI {
    public static void czyscEkran(){
    }

    /**
     * Metoda do poprawnego odczytywania pliku z pytaniami
     * @param sciezkaPliku Nazwa pliku z pytaniami
     * @return Zwraca odpowiednia sciezke
     */
    public static String katalogProjektu(String sciezkaPliku){
        String sciezkaProjektu = System.getProperty("user.dir");
        if (sciezkaProjektu.contains("out") || sciezkaProjektu.contains("production")){
            return sciezkaProjektu + "\\" + sciezkaPliku;
        }
        else
            return sciezkaProjektu + "\\src\\" + sciezkaPliku;
    }

    static public ArrayList<String> czytajPlik(String sciezkaPliku) throws Exception{
        try {
            BufferedReader wejscie = new BufferedReader(new FileReader(new File(katalogProjektu(sciezkaPliku))));
            System.out.println("Pomy�lnie otwarto plik z pytaniami: " + katalogProjektu(sciezkaPliku) + "\n");
            String pojedyncaLinia = wejscie.readLine();
            int iloscLini = 0;
            ArrayList<String> zawartoscPliku = new ArrayList<String>();
            while (pojedyncaLinia != null){
                zawartoscPliku.add(pojedyncaLinia);
                pojedyncaLinia = wejscie.readLine();
            }
            return zawartoscPliku;
        }
        catch (FileNotFoundException e){
            System.out.println("Brak pliku " + katalogProjektu(sciezkaPliku) );
        }
        catch (Exception e){
            System.out.println("Inny b��d ");
        }
        return null;
    }

    static public void czytajPlik() throws Exception{
        String sciezkaPliku = "koncowe.txt";
        try {
            BufferedReader wejscie = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+sciezkaPliku)));
        }
        catch (FileNotFoundException e){
            System.out.println("Brak pliku " + sciezkaPliku );
        }
        catch (Exception e){
            System.out.println("Inny b��d ");
        }

    }

    static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner wejscie = new Scanner(System.in);
        try
        {
            wejscie.nextLine();
        }
        catch(Exception e)
        {}
    }

    public static void main(String[] args) throws Exception {
        czyscEkran();
        int sumaPunktowUzytkownika = 0;
        ArrayList<String> bazaPytan = new ArrayList<>();
        bazaPytan = czytajPlik("oldVersion/pytania.txt");
        ArrayList<Pytania> listaPytan = new ArrayList<Pytania>();

        // tworzenie pytan
        for (int i = 0; i < bazaPytan.size(); i += 5){
            Pytania pytaniaQuiz = new Pytania();
            pytaniaQuiz.setPytanie(bazaPytan.get(i));
            pytaniaQuiz.setOdpowiedzi(bazaPytan.get(i+1), bazaPytan.get(i+2), bazaPytan.get(i+3));
            pytaniaQuiz.setPrawidlowaOdpowiedz(bazaPytan.get(i+4));
            listaPytan.add(pytaniaQuiz);
        }
        Collections.shuffle(listaPytan);

        // wy�wietlanie pyta�
        for (int i = 0; i < listaPytan.size(); i++){
            czyscEkran();
            System.out.println("\n" + (i + 1) + ") " + listaPytan.get(i).getPytanie());
            ArrayList<String> listaOdp = new ArrayList<>();
            listaOdp = listaPytan.get(i).getOdpowiedzi();
            for (int x = 0; x < listaOdp.size(); x++){
                int nrPytania = x + 1;
                System.out.println("\t" + nrPytania + ". "+ listaOdp.get(x));
            }
            Scanner wejscie = new Scanner(System.in);
            System.out.print("\nWybierz prawid�ow� odpowied� (1, 2 lub 3): ");
            char odp = wejscie.next().charAt(0);
            listaPytan.get(i).setOdpowiedzUzytkownika(odp);
            System.out.println(listaPytan.get(i).sprawdzOdpowiedz());
            sumaPunktowUzytkownika += listaPytan.get(i).getSumaPunktow();
            System.out.println("\nSuma punkt�w: " + sumaPunktowUzytkownika );
        }
        czyscEkran();

        pressAnyKeyToContinue();

    }
}
