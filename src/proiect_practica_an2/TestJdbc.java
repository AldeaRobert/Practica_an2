package proiect_practica_an2;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class TestJdbc {
public static void main(String [] args){

Afisare afisare=new Afisare();
Adaugare adaugare=new Adaugare();
Stergere stergere=new Stergere ();
Modificare modificare=new Modificare();
Afisare_mare afisare_mare=new Afisare_mare();
int x=0;
while(x==0){
    String[] op1 = new String[] {"1","2","3","4","X"};
    int rasp1 = JOptionPane.showOptionDialog(null, "Ce doriti sa faceti?\n1 - Afisare tabel\n2 - Adaugare in tabel\n3 - Stergere din tabel\n4 - Modificare tabel\nX - Inchide program", "Baza de date Practica/ Meniu principal",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op1, op1[0]);
    if(rasp1>=0){
        switch(rasp1+1){
            case(1):{
                int z=0;
                while(z==0){
                    String[] op2 = new String[] {"1","2","3","4","5","6","7","8","9","10","X"};
                    int rasp2 = JOptionPane.showOptionDialog(null, "Ce tabel doriti sa afisati?\n1 - Tabel Persoane\n2 - Tabel Meserii\n3 - Tabel Colaborari\n4 - Tabel Difuzari"
                        + "\n5 - Tabel Emisiuni\n6 - Tabel Firme\n7 - Tanel Localitati\n8 - Tabel Studiouri\n9 - Tabel Tipuri_emisiuni\n10 - Tabel Sponsorizari\nX - Inapoi la meniul principal",
                        "Baza de date Practica/ Afisare tabel",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op2, op2[0]);
                    if(rasp2>=0){
                        switch (rasp2+1){
                            case 1:{
                                afisare_mare.AfisarePersoane();
                                break;}
                            case 2:{
                                afisare_mare.AfisareMeserii();
                                break;}
                            case 3:{
                                afisare_mare.AfisareColaborari();
                                break;}
                            case 4:{
                                afisare_mare.AfisareDifuzari();
                                break;}
                            case 5:{
                                afisare_mare.AfisareEmisiuni();
                                break;}
                            case 6:{
                                afisare_mare.AfisareFirme();
                                break;}
                            case 7:{
                                afisare_mare.AfisareLocalitati();
                                break;}
                            case 8:{
                                afisare_mare.AfisareStudiouri();
                                break;}
                            case 9:{
                                afisare_mare.AfisareTipuri_emisiuni();
                                break;}
                            case 10:{
                                afisare_mare.AfisareSponsorizari();
                                break;}
                            case 11:{
                                z=1;
                                break;}
                            }
                    }else{z=1;x=1;} 
                }
                break;
            }
            case(2):{
                int z=0;
                while(z==0){
                    String[] op3 = new String[] {"1","2","3","4","5","6","7","8","9","10","X"};
                    int rasp3 = JOptionPane.showOptionDialog(null, "In ce tabel doriti sa adaugati ceva?\n1 - Tabel Persoane\n2 - Tabel Meserii\n3 - Tabel Colaborari\n4 - Tabel Difuzari"
                        + "\n5 - Tabel Emisiuni\n6 - Tabel Firme\n7 - Tabel Localitati\n8 - Tabel Studiouri\n9 - Tabel Tipuri_emisiuni\n10 - Tabel Sponsorizari\nX - Inapoi la meniul principal",
                        "Baza de date Practica/ Adaugare in tabel",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op3, op3[0]);
                    if(rasp3>=0){
                        switch (rasp3+1){
                            case 1:{
                                afisare.AfisarePersoane();
                                adaugare.AdaugarePersoane();
                                break;}
                            case 2:{
                                afisare.AfisareMeserii();
                                adaugare.AdaugareMeserii();
                                break;}
                            case 3:{
                                afisare.AfisareColaborari();
                                adaugare.AdaugareColaborari();
                                break;}
                            case 4:{
                                afisare.AfisareDifuzari();
                                adaugare.AdaugareDifuzari();
                                break;}
                            case 5:{
                                afisare.AfisareEmisiuni();
                                adaugare.AdaugareEmisiuni();
                                break;}
                            case 6:{
                                afisare.AfisareFirme();
                                adaugare.AdaugareFirme();
                                break;}
                            case 7:{
                                afisare.AfisareLocalitati();
                                adaugare.AdaugareLocalitati();
                                break;}
                            case 8:{
                                afisare.AfisareStudiouri();
                                adaugare.AdaugareStudiouri();
                                break;}
                            case 9:{
                                afisare.AfisareTipuri_emisiuni();
                                adaugare.AdaugareTipuri_emisiuni();
                                break;}
                            case 10:{
                                afisare.AfisareSponsorizari();
                                adaugare.AdaugareSponsorizari();
                                break;}
                            case 11:{
                                z=1;
                                break;}
                            }
                    }else{z=1;x=1;} 
                }
                break;
            }
            case(3):{
                int z=0;
                while(z==0){
                    String[] op3 = new String[] {"1","2","3","4","5","6","7","8","9","10","X"};
                    int rasp3 = JOptionPane.showOptionDialog(null, "Din ce tabel doriti sa eliminati ceva?\n1 - Tabel Persoane\n2 - Tabel Meserii\n3 - Tabel Colaborari\n4 - Tabel Difuzari"
                        + "\n5 - Tabel Emisiuni\n6 - Tabel Firme\n7 - Tanel Localitati\n8 - Tabel Studiouri\n9 - Tabel Tipuri_emisiuni\n10 - Tabel Sponsorizari\nX - Inapoi la meniul principal",
                        "Baza de date Practica/ Eliminare tuplu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op3, op3[0]);
                    if(rasp3>=0){
                        switch (rasp3+1){
                            case 1:{
                                stergere.StergerePersoane();
                                break;}
                            case 2:{
                                stergere.StergereMeserii();
                                break;}
                            case 3:{
                                stergere.StergereColaborari();
                                break;}
                            case 4:{
                                stergere.StergereDifuzari();
                                break;}
                            case 5:{
                                stergere.StergereEmisiuni();
                                break;}
                            case 6:{
                                stergere.StergereFirme();
                                break;}
                            case 7:{
                                stergere.StergereLocalitati();
                                break;}
                            case 8:{
                                stergere.StergereStudiouri();
                                break;}
                            case 9:{
                                stergere.StergereTipuri_emisiuni();
                                break;}
                            case 10:{
                                stergere.StergereSponsorizari();
                                break;}
                            case 11:{
                                z=1;
                                break;}
                            }
                    }else{z=1;x=1;} 
                }
                break;
            }
            case(4):{
                int z=0;
                while(z==0){
                    String[] op3 = new String[] {"1","2","3","4","5","6","7","8","9","10","X"};
                    int rasp3 = JOptionPane.showOptionDialog(null, "In ce tabel doriti sa modificati ceva?\n1 - Tabel Persoane\n2 - Tabel Meserii\n3 - Tabel Colaborari\n4 - Tabel Difuzari"
                        + "\n5 - Tabel Emisiuni\n6 - Tabel Firme\n7 - Tabel Localitati\n8 - Tabel Studiouri\n9 - Tabel Tipuri_emisiuni\n10 - Tabel Sponsorizari\nX - Inapoi la meniul principal",
                        "Baza de date Practica/ Modificare tuplu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op3, op3[0]);
                    if(rasp3>=0){
                        switch (rasp3+1){
                            case 1:{
                                modificare.ModificarePersoane();
                                break;}
                            case 2:{
                                modificare.ModificareMeserii();
                                break;}
                            case 3:{
                                modificare.ModificareColaborari();
                                break;}
                            case 4:{
                                modificare.ModificareDifuzari();
                                break;}
                            case 5:{
                                modificare.ModificareEmisiuni();
                                break;}
                            case 6:{
                                modificare.ModificareFirme();
                                break;}
                            case 7:{
                                modificare.ModificareLocalitati();
                                break;}
                            case 8:{
                                modificare.ModificareStudiouri();
                                break;}
                            case 9:{
                                modificare.ModificareTipuri_emisiuni();
                                break;}
                            case 10:{
                                modificare.ModificareSponsorizari();
                                break;}
                            case 11:{
                                z=1;
                                break;}
                            }
                    }else{z=1;x=1;} 
                }
                break;
            }
            case(5):{
                x=1;
                break;
            }
        }
    }
    else{x=1;}
}
}}