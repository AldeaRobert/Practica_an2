package proiect_practica_an2;


import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.sql.*;  
import javax.swing.*;
import java.sql.Date;  
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Afisare_mare {
    void AfisarePersoane(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq = "SELECT p.IdP, p.Nume, p.Prenume, p.CNP, p.Meserie AS [IdM], m.Meserii, p.LocDomiciliu AS [IdL], l.Localitati\n" +
"FROM (Persoane AS p INNER JOIN Meserii AS m ON p.Meserie=m.IdM) INNER JOIN Localitati AS l ON p.LocDomiciliu=l.IdL";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq);
DefaultListModel ListA = new DefaultListModel<>();

while(rs.next()){
        ListA.addElement(
            rs.getInt("idP")+", " +
            rs.getString("Nume")+", " +
            rs.getString("Prenume")+", " +
            rs.getString("CNP")+", " +
            rs.getInt("IdM")+" (" +
            rs.getString("Meserii")+"), " +
            rs.getInt("LocDomiciliu")+" (" +
            rs.getString("Localitati")+")"
            );
}


JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Persoane");
JLabel numeContinutListaA = new JLabel("IdP, Nume, Prenume, CNP, IdM(Meserie), IdL(Loc Domiciliu)");
numeContinutListaA.setBounds(35,35,400,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Persoane");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
   
    void AfisareMeserii(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT * FROM Meserii";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("IdM")+", " +
            rs.getString("Meserii"));
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Meserii");
JLabel numeContinutListaA = new JLabel("IdM, Meserii");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Meserii");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareColaborari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT c.IdC, c.persoane AS [IdP], p.Nume+' '+p.Prenume AS [NumePersoana], c.Emisiuni AS [IdEmis], e.NumeEmisiune\n" +
"FROM (colaborari AS c INNER JOIN Persoane AS p ON c.Persoane=p.IdP) INNER JOIN Emisiuni AS e ON c.Emisiuni=e.IdEmis ORDER BY c.IdC;";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("idC")+", " +
            rs.getInt("IdP") + " (" +
            rs.getString("NumePersoana") + "), " +
            rs.getInt("IdEmis") + " ("+
            rs.getString("NumeEmisiune")+")"
            );
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Colaborari");
JLabel numeContinutListaA = new JLabel("IdC, IdP(Nume persoana), IdEmis(Nume emisiune)");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);
AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Colaborari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }

    void AfisareDifuzari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT d.IdDif, d.Emisiune, e.NumeEmisiune, d.Zi, d.OraInceput, d.OraSfarsit\n" +
"FROM Difuzari AS d INNER JOIN Emisiuni AS e ON d.Emisiune=e.IdEmis;";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("idDif")+", " +
            rs.getInt("Emisiune") + " (" +
            rs.getString("NumeEmisiune")+ "), " + 
            rs.getDate("Zi") + ", " +
            rs.getTime("OraInceput") + ", " +
            rs.getTime("OraSfarsit"));
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Difuzari");
JLabel numeContinutListaA = new JLabel("IdDif, IdEmis(Nume Emisiune), Zi, OraInceput, OraSfarsit");
numeContinutListaA.setBounds(35,35,400,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Difuzari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareEmisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT e.IdEmis, e.NumeEmisiune, e.TipEmisiune AS [IdTipEmis], t.TipEmisiune, e.CoordonatorSef AS [IdSef], p.Nume+' '+p.Prenume AS [NumeSef], e.Locatie AS[IdS], s.Studio\n" +
"FROM ((Emisiuni AS e INNER JOIN Tipuri_emisiuni AS t ON e.TipEmisiune=t.IdTipEmis) INNER JOIN Persoane AS p ON e.CoordonatorSef=p.IdP) INNER JOIN Studiouri AS s ON e.Locatie=s.IdS";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();

while(rs.next()){
        ListA.addElement(
            rs.getInt("idEmis")+", " +
            rs.getString("NumeEmisiune") + ", " +
            rs.getInt("IdTipEmis") + " (" +
            rs.getString("TipEmisiune") + "), " +
            rs.getInt("IdSef") + " (" +
            rs.getString("NumeSef") + "), " +
            rs.getInt("Locatie") + " (" +
            rs.getString("Studio") + ")");
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,530,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Emisiuni");
JLabel numeContinutListaA = new JLabel("IdEmis, NumeEmisiune, IdTipEmis(Tip Emisiune), IdP(Nume Sef), IdS(Studio)");
numeContinutListaA.setBounds(35,35,500,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(400,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(600,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Emisiuni");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }

    void AfisareFirme(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT * FROM Firme";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();

while(rs.next()){
        ListA.addElement(
            rs.getInt("IdF")+", " +
            rs.getString("Firma"));
        
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Firme");
JLabel numeContinutListaA = new JLabel("IdF, Firma");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Firma");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareLocalitati(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT * FROM Localitati";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("IdL")+", " +
            rs.getString("Localitati"));
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Localitati");
JLabel numeContinutListaA = new JLabel("IdL, Localitati");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Localitati");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareStudiouri(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT * FROM Studiouri";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();

while(rs.next()){
        ListA.addElement(
            rs.getInt("IdS")+", " +
            rs.getString("Studio"));
        
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Studiuri");
JLabel numeContinutListaA = new JLabel("IdS, Studiouri");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Studiouri");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareTipuri_emisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT * FROM Tipuri_emisiuni";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("IdTipEmis")+", " +
            rs.getString("TipEmisiune"));
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Tipuri de emisiuni");
JLabel numeContinutListaA = new JLabel("IdTipEmis, TipEmisiune");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,200,20);AddDif.add(numeListA);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Tipuri de emisiuni");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareSponsorizari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sq2 = "SELECT s.IdSp, s.Firme AS [IdF], f.Firma, s.EmisiuniS AS [IdEmis], e.NumeEmisiune, s.Suma\n" +
"FROM (Sponsorizari AS s INNER JOIN Firme AS f ON s.Firme=f.IdF) INNER JOIN Emisiuni AS e ON s.EmisiuniS = e.IdEmis";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
while(rs.next()){
        ListA.addElement(
            rs.getInt("IdSp")+", " +
            rs.getInt("IdF")+" (" +
            rs.getString("Firma")+"), " +
            rs.getInt("IdEmis")+" (" +
            rs.getString("NumeEmisiune")+"), " +
            rs.getInt("Suma")+" Ron");
        
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Sponsorizari");
JLabel numeContinutListaA = new JLabel("IdSp, IdF(Nume firma), IdEmis(Nume emisiune, Suma)");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,200,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,325,100,25);AddDif.add(panel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,400);
AddDif.setTitle("JDBC Practica/ Stergere tuplu/ Sponsorizari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

    while(true){
        if(exit.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
    }
}
