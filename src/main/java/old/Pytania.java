package oldVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Klasa s�u��ca do generowania obiekt�w, kt�re zawieraj� pytania, mo�liwe odpowiedzi, prawid�owe odpowiedzi oraz odpowiedz wskazana przez u�ytkownika
 * @author Adam
 * @version 1.0
 * */
public class Pytania {
    Pytania(){
        iloscOdpowiedzi = 3;

    }
    private Object test;
    private String pytanie;
    private ArrayList<String> odpowiedzi = new ArrayList<String>();
    private ArrayList<String> kategoriePytan = new ArrayList<String>();
    private String prawidlowaOdpowiedz;
    private String odpowiedzUzytkownika;
    private int iloscOdpowiedzi;
    private int sumaPunktow = 0;
    private int progZaliczenia = 60;
    private String info = "\nQUIZ z materia�u Szko�y Podoficerskiej SONDA" +
            "\nZa kazd� odpowied� otrzymujesz 1 punkt." +
            "\nPr�g zaliczenia wynosi " + progZaliczenia + " %" +
            "\nNaci�nij ENTER aby kontynu�owa�";


    /**
     *
     */
    public void getInfo(){
        System.out.println(info);
    }

    public void setPytanie (String x){
        pytanie = x;
    }

    public String getPytanie(){
        return pytanie;
    }

    public ArrayList getOdpowiedzi(){
        Collections.shuffle(odpowiedzi);
        return odpowiedzi;
    }

    public void setOdpowiedzi(String x){
        odpowiedzi.add(x);
    }

    public void setOdpowiedzi(String x,String y, String z){
        odpowiedzi.add(x);
        odpowiedzi.add(y);
        odpowiedzi.add(z);
    }

    public void setPrawidlowaOdpowiedz(String x){
        prawidlowaOdpowiedz = x;
    }

    public String getPrawidlowaOdpowiedz(){
        return prawidlowaOdpowiedz;
    }

    public int getSumaPunktow(){
        return sumaPunktow;
    }



    public void setSumaPunktow(){
        sumaPunktow++;
    }

    public Integer sumowaniePunktow(Integer x){
        int suma = 0;
        suma += x;
        return suma;
    }

    public void setOdpowiedzUzytkownika(char y){
        String x = String.valueOf(y);
        switch (x){
            case "1":
                odpowiedzUzytkownika = odpowiedzi.get(0);
                break;
            case "2":
                odpowiedzUzytkownika = odpowiedzi.get(1);
                break;
            case "3":
                odpowiedzUzytkownika = odpowiedzi.get(2);
                break;
            default:
                System.out.println("Niepoprawny wyb�r odpowiedzi");
        }
    }

    public String getOdpowiedzUzytkownika(){
        return odpowiedzUzytkownika;
    }

    public String sprawdzOdpowiedz(){
        if (prawidlowaOdpowiedz.equals(odpowiedzUzytkownika)){
            setSumaPunktow();
            return "Prawid�owa odpowied�, zdobywasz 1 punkt.";
        }
        else {
            return "Z�A ODPOWIED�! Prawid�owa: " + prawidlowaOdpowiedz;

        }
    }
    public void sprawdzOdpowiedzVer2(){
        if (prawidlowaOdpowiedz.equals(odpowiedzUzytkownika)){
            setSumaPunktow();
            System.out.println("PRAWIDLOWA ODPOWIEDZ");
        }
        else {
            System.out.println("Z�A ODPOWIED�! Prawid�owa: " + prawidlowaOdpowiedz);

        }
    }

    public void getKategoriePytan(){
        kategoriePytan.forEach((i) -> System.out.println(i));
    }


}
