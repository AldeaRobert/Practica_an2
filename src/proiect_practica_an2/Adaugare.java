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

public class Adaugare {
    void AdaugarePersoane(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO persoane VALUES(?,?,?,?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM persoane";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdP")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdP")+1;
    }
final int cod=ffff;

DefaultListModel ListA = new DefaultListModel<>();
String sq3="SELECT IdM,Meserii FROM Meserii ORDER BY IdM";//Id Meserii
ResultSet rs4 = stmt.executeQuery(sq3);

id=1;
while(rs4.next()){
    if(rs4.getInt("idM")==id){
        ListA.addElement(rs4.getInt("IdM")+" ("+rs4.getString("Meserii")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idM")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(rs4.getInt("IdM")+" ("+rs4.getString("Meserii")+")");
        id++;
    }
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(260,35,190,100);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Id Meserie");
numeListA.setBounds(270,17,100,20);AddDif.add(numeListA);

DefaultListModel ListB = new DefaultListModel<>();
String sq4="SELECT IdL,Localitati FROM Localitati ORDER BY IdL";//Id Localitati
ResultSet rs5 = stmt.executeQuery(sq4);

id=1;
while(rs5.next()){
    if(rs5.getInt("idL")==id){
        ListB.addElement(rs5.getInt("IdL")+" ("+rs5.getString("Localitati")+")");
        id++;
    }
    else{
        
        while(id!=rs5.getInt("idL")){
            ListB.addElement(id+", Missing id "+id);
            id++;
        }
        ListB.addElement(rs5.getInt("IdL")+" ("+rs5.getString("Localitati")+")");
        id++;
    }
}

JList<String> ListB2 = new JList<>(ListB);  
JScrollPane PaneB = new JScrollPane();
PaneB.setViewportView(ListB2);
ListB2.setLayoutOrientation(JList.VERTICAL);
PaneB.setBounds(500,35,190,100);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id LocDomiciliu");
numeListB.setBounds(510,17,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(400,150,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(250,150,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,30,100,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Nume");
numeLabel.setBounds(170,30,100,20);AddDif.add(numeLabel);

JTextField prenume = new JTextField();
prenume.setBounds(50,70,100,20);AddDif.add(prenume);
JLabel prenumeLabel = new JLabel("Prenume");
prenumeLabel.setBounds(170,70,100,20);AddDif.add(prenumeLabel);

JTextField cnp = new JTextField();
cnp.setBounds(50,110,100,20);AddDif.add(cnp);
JLabel CNPLabel = new JLabel("CNP");
CNPLabel.setBounds(170,110,100,20);AddDif.add(CNPLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(720,240);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Persoane");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()&&!prenume.getText().isEmpty()&&!cnp.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1&&ListB2.getSelectedIndex() != -1)
            { int meserie=ListA2.getSelectedIndex();
            int loc=ListB2.getSelectedIndex();
            try {
                pstmt.setInt(1,cod);
                pstmt.setString(2,nume.getText());
                pstmt.setString(3,prenume.getText());
                pstmt.setString(4,cnp.getText());
                pstmt.setInt(5,meserie+1);
                pstmt.setInt(6,loc+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID urile nu au fost selectate. Introducere Anulata.");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Introducere Anulata.");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}}
   
    void AdaugareMeserii(){
    JFrame AddDif = new JFrame();
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO meserii VALUES(?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Meserii";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdM")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdM")+1;}
final int cod=ffff;

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(175,70,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(50,70,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,40,225,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Meserie");
numeLabel.setBounds(60,20,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(325,155);
AddDif.setTitle("JDBC Adaugare/ Meserii");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        try {
            pstmt.setInt(1,cod );
            pstmt.setString(2,nume.getText());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareColaborari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Colaborari VALUES(?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sql2="SELECT * FROM colaborari Order By IdC";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sql2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdC")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdC")+1;}
final int cod=ffff;

String sq2="SELECT IdP, Nume+' '+Prenume AS [NumePers] From Persoane ORDER BY IdP;";//IdPersoane
ResultSet rs4 = stmt.executeQuery(sq2);

DefaultListModel IdPList = new DefaultListModel<>();
id=1;
while(rs4.next()){
    if(rs4.getInt("idP")==id){
        IdPList.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idP")){
            IdPList.addElement(id+", Missing id "+id);
            id++;
        }
        IdPList.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
}

JList<String> IdPList2 = new JList<>(IdPList);  
JScrollPane scrollPaneP = new JScrollPane();
scrollPaneP.setViewportView(IdPList2);
IdPList2.setLayoutOrientation(JList.VERTICAL);
scrollPaneP.setBounds(40,35,190,90);AddDif.add(scrollPaneP);

String sql23="SELECT IdEmis, NumeEmisiune From Emisiuni ORDER BY IdEmis;";//IdEmisiuni
ResultSet rs3 = stmt.executeQuery(sql23);

DefaultListModel IdEmisList = new DefaultListModel<>();
id=1;
while(rs3.next()){
    if(rs3.getInt("idEmis")==id){
        IdEmisList.addElement(rs3.getInt("IdEmis")+" ("+rs3.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs3.getInt("idEmis")){
            IdEmisList.addElement(id+", Missing id "+id);
            id++;
        }
        IdEmisList.addElement(rs3.getInt("IdEmis")+" ("+rs3.getString("NumeEmisiune")+")");
        id++;
    }
}

JList<String> IdEmisList2 = new JList<>(IdEmisList);  
JScrollPane scrollPaneEmis = new JScrollPane();
scrollPaneEmis.setViewportView(IdEmisList2);
IdEmisList2.setLayoutOrientation(JList.VERTICAL);
scrollPaneEmis.setBounds(260,35,190,90);AddDif.add(scrollPaneEmis);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JLabel IdPListName = new JLabel("Id Persoana");
JLabel IdEmisListName = new JLabel("Id Emisiune");
JToggleButton Add = new JToggleButton("Add");
JToggleButton exit=new JToggleButton("Inchidere");

IdPListName.setBounds(70,10,100,20);AddDif.add(IdPListName);
IdEmisListName.setBounds(300,10,120,20);AddDif.add(IdEmisListName);

Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(100,150,100,25);AddDif.add(panel2);
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(310,150,100,25);AddDif.add(panel);
AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,240);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Colaborari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(IdEmisList2.getSelectedIndex() !=-1&&IdPList2.getSelectedIndex() !=-1)
        {int alegP=IdPList2.getSelectedIndex();
        int alegE=IdEmisList2.getSelectedIndex();
        try {
            pstmt.setInt(3,cod );
            pstmt.setInt(1,alegP+1);
            pstmt.setInt(2,alegE+1);
            pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
        }
    else
        System.out.println("Nu au fost selectate toate ID urile. Introducere Anulata.");
    });
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }

    void AdaugareDifuzari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Difuzari VALUES(?,?,?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sql2="SELECT d.IdDif, d.Emisiune, e.NumeEmisiune, d.Zi, d.OraInceput, d.OraSfarsit\n" +
"FROM Difuzari AS d INNER JOIN Emisiuni AS e ON d.Emisiune=e.IdEmis ORDER BY d.IdDif;";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sql2);
String sql23="SELECT IdEmis, NumeEmisiune From Emisiuni;";
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdDif")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdDif")+1;
}

int cod=ffff;
DefaultListModel IdEmisList = new DefaultListModel<>();
ResultSet rs3 = stmt.executeQuery(sql23);
id=1;
while(rs3.next()){
    if(rs3.getInt("idEmis")==id){
        IdEmisList.addElement(rs3.getInt("IdEmis")+" ("+rs3.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs3.getInt("idEmis")){
            IdEmisList.addElement(id+", Missing id "+id);
            id++;
        }
        IdEmisList.addElement(rs3.getInt("IdEmis")+" ("+rs3.getString("NumeEmisiune")+")");
        id++;
    }
}
JFrame AddDif= new JFrame(); 

JList<String> IdEmisList2 = new JList<>(IdEmisList);  
JScrollPane scrollPane = new JScrollPane();
scrollPane.setViewportView(IdEmisList2);
IdEmisList2.setLayoutOrientation(JList.VERTICAL);
AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JToggleButton exit=new JToggleButton("Inchidere"); 
JPanel panel2 = new JPanel(null);

JTextField ziDD = new JTextField(2);
JTextField ziMM = new JTextField(2);
JTextField ziYYYY = new JTextField(4);
JTextField OraIss = new JTextField(2);
JTextField OraImm = new JTextField(2);
JTextField OraIhh = new JTextField(2);
JTextField OraFss = new JTextField(2);
JTextField OraFmm = new JTextField(2);
JTextField OraFhh = new JTextField(2);

JLabel Zi = new JLabel("Zi");
JLabel FormatZi = new JLabel("DD  -  MM  -  YYYY");
JLabel Symb1 = new JLabel("-");
JLabel Symb11 = new JLabel("-");
JLabel OraInceput = new JLabel("OraInceput");
JLabel FormatOraI = new JLabel("hh  :  mm  :  ss");
JLabel Symb2 = new JLabel(":");
JLabel Symb22 = new JLabel(":");
JLabel OraFinal = new JLabel("OraFinal");
JLabel FormatOraF = new JLabel("hh  :  mm  :  ss");
JLabel Symb3 = new JLabel(":");
JLabel Symb33 = new JLabel(":");
JLabel IdEmisListName = new JLabel("Id Emisiune");
JToggleButton Add = new JToggleButton("Add");

FormatZi.setBounds(50,10,100,20);AddDif.add(FormatZi);
ziDD.setBounds(50,30,20,20);AddDif.add(ziDD);
ziMM.setBounds(80,30,20,20);AddDif.add(ziMM);
ziYYYY.setBounds(110,30,34,20);AddDif.add(ziYYYY);

Symb1.setBounds(72,30,4,20);AddDif.add(Symb1);
Symb11.setBounds(102,30,4,20);AddDif.add(Symb11);

Zi.setBounds(160,30,30,20);AddDif.add(Zi);

FormatOraI.setBounds(50,50,100,20);AddDif.add(FormatOraI);
OraIhh.setBounds(50,70,20,20);AddDif.add(OraIhh);
OraImm.setBounds(80,70,20,20);AddDif.add(OraImm);
OraIss.setBounds(110,70,20,20);AddDif.add(OraIss);

Symb2.setBounds(73,70,4,20);AddDif.add(Symb2);
Symb22.setBounds(103,70,4,20);AddDif.add(Symb22);

OraInceput.setBounds(160,70,100,20);AddDif.add(OraInceput);

FormatOraF.setBounds(50,90,100,20);AddDif.add(FormatOraF);
OraFhh.setBounds(50,110,20,20);AddDif.add(OraFhh);
OraFmm.setBounds(80,110,20,20);AddDif.add(OraFmm);
OraFss.setBounds(110,110,20,20);AddDif.add(OraFss);

Symb3.setBounds(73,110,4,20);AddDif.add(Symb3);
Symb33.setBounds(103,110,4,20);AddDif.add(Symb33);

OraFinal.setBounds(160,110,100,20);AddDif.add(OraFinal);

IdEmisListName.setBounds(270,10,100,20);AddDif.add(IdEmisListName);
scrollPane.setBounds(260,30,200,110);AddDif.add(scrollPane);
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(100,150,100,25);AddDif.add(panel2);
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,150,100,25);AddDif.add(panel);
AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,240);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Difuzari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!OraFhh.getText().isEmpty()&&!OraFmm.getText().isEmpty()&&!OraFss.getText().isEmpty()&&!OraIhh.getText().isEmpty()&&!OraImm.getText().isEmpty()&&!OraIss.getText().isEmpty()&&!ziDD.getText().isEmpty()&&!ziMM.getText().isEmpty()&&!ziYYYY.getText().isEmpty()){
        if(IdEmisList2.getSelectedIndex() != -1)
            { int aleg=IdEmisList2.getSelectedIndex();
            try {
                pstmt.setInt(1,cod);
                pstmt.setInt(2,aleg+1);
                pstmt.setDate(3,Date.valueOf(ziYYYY.getText()+'-'+ziMM.getText()+'-'+ziDD.getText()));
                pstmt.setTime(4,Time.valueOf(OraIhh.getText()+':'+OraImm.getText()+':'+OraIss.getText()));
                pstmt.setTime(5,Time.valueOf(OraFhh.getText()+':'+OraFmm.getText()+':'+OraFss.getText()));
                pstmt.executeUpdate();
                System.out.println("Introducere reusita\n");
            } catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");
                }
            }
        else
            System.out.println("Nu a fost selectat un ID. Introducere Anulata.");
    }
    else
        System.out.println("Un Camp a fost lasat gol. Introducere Anulata.");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareEmisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Emisiuni VALUES(?,?,?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sql2="SELECT * FROM Emisiuni ORDER BY IdEmis";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sql2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdEmis")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdEmis")+1;}
int cod=ffff;
String sql23="SELECT IdTipEmis, TipEmisiune From Tipuri_emisiuni ORDER BY IdTipEmis;";//IdTipEmisiune
ResultSet rs3 = stmt.executeQuery(sql23);

DefaultListModel IdTipEmisList = new DefaultListModel<>();
id=1;
while(rs3.next()){
    if(rs3.getInt("idTipEmis")==id){
        IdTipEmisList.addElement(rs3.getInt("idTipEmis")+" ("+rs3.getString("TipEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs3.getInt("idTipEmis")){
            IdTipEmisList.addElement(id+", Missing id "+id);
            id++;
        }
        IdTipEmisList.addElement(rs3.getInt("idTipEmis")+" ("+rs3.getString("TipEmisiune")+")");
        id++;
    }
}

JList<String> IdTipEmisList2 = new JList<>(IdTipEmisList);  
JScrollPane scrollPaneTipEmis = new JScrollPane();
scrollPaneTipEmis.setViewportView(IdTipEmisList2);
IdTipEmisList2.setLayoutOrientation(JList.VERTICAL);
scrollPaneTipEmis.setBounds(50,35,140,90);AddDif.add(scrollPaneTipEmis);

String sql234="SELECT IdP, Nume+' '+Prenume AS [NumePers] From Persoane ORDER BY IdP;";//IdPersoane
ResultSet rs4 = stmt.executeQuery(sql234);

DefaultListModel IdPList = new DefaultListModel<>();

id=1;
while(rs4.next()){
    if(rs4.getInt("idP")==id){
        IdPList.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idP")){
            IdPList.addElement(id+", Missing id "+id);
            id++;
        }
        IdPList.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
}

JList<String> IdPList2 = new JList<>(IdPList);  
JScrollPane scrollPaneP = new JScrollPane();
scrollPaneP.setViewportView(IdPList2);
IdPList2.setLayoutOrientation(JList.VERTICAL);
scrollPaneP.setBounds(220,35,200,90);AddDif.add(scrollPaneP);

String sql2345="SELECT IdS, Studio From Studiouri ORDER BY IdS;";//IdStudiouri
ResultSet rs5 = stmt.executeQuery(sql2345);

DefaultListModel IdSList = new DefaultListModel<>();

id=1;
while(rs5.next()){
    if(rs5.getInt("idS")==id){
        IdSList.addElement(rs5.getInt("IdS")+" ("+rs5.getString("Studio")+")");
        id++;
    }
    else{
        
        while(id!=rs5.getInt("idS")){
            IdSList.addElement(id+", Missing id "+id);
            id++;
        }
        IdSList.addElement(rs5.getInt("IdS")+" ("+rs5.getString("Studio")+")");
        id++;
    }
}

JList<String> IdSList2 = new JList<>(IdSList);  
JScrollPane scrollPaneS = new JScrollPane();
scrollPaneS.setViewportView(IdSList2);
IdSList2.setLayoutOrientation(JList.VERTICAL);
scrollPaneS.setBounds(450,35,240,90);AddDif.add(scrollPaneS);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JTextField NumeEmisiune = new JTextField();

JLabel NumeEmisiuneLabel = new JLabel("Nume emisiune");
JLabel IdTipEmisListName = new JLabel("Id Tip Emisiune");
JLabel IdPListName = new JLabel("Id Sef (persoana)");
JLabel IdSListName = new JLabel("Id Locatie (Studio)");
JToggleButton Add = new JToggleButton("Add");
JToggleButton exit=new JToggleButton("Inchidere");

NumeEmisiune.setBounds(50,150,140,20);AddDif.add(NumeEmisiune);
NumeEmisiuneLabel.setBounds(200,150,140,20);AddDif.add(NumeEmisiuneLabel);

IdTipEmisListName.setBounds(60,10,100,20);AddDif.add(IdTipEmisListName);
IdPListName.setBounds(260,10,100,20);AddDif.add(IdPListName);
IdSListName.setBounds(500,10,120,20);AddDif.add(IdSListName);

Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(390,150,100,25);AddDif.add(panel2);
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(550,150,100,25);AddDif.add(panel);
AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(750,240);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Emisiuni");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!NumeEmisiune.getText().isEmpty()){
        if(IdTipEmisList2.getSelectedIndex() != -1||IdPList2.getSelectedIndex() != -1||IdSList2.getSelectedIndex() != -1)
            {int alegTipEmis=IdTipEmisList2.getSelectedIndex();
            int alegP=IdPList2.getSelectedIndex();
            int alegS=IdSList2.getSelectedIndex();
            try {
                pstmt.setInt(1,cod);
                pstmt.setString(2,NumeEmisiune.getText());
                pstmt.setInt(3,alegTipEmis+1);
                pstmt.setInt(4,alegP+1);
                pstmt.setInt(5,alegS+1);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");
        }
            }
        else
            System.out.println("Nu au fost selectate toate ID urile. Introducere Anulata.");
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }

    void AdaugareFirme(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Firme VALUES(?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Firme ORDER BY IdF";
Statement stmt = con.createStatement();
JFrame AddDif = new JFrame();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdF")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdF")+1;}
int cod=ffff;

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(175,70,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(50,70,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,40,225,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Firma");
numeLabel.setBounds(60,20,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(325,155);
AddDif.setTitle("JDBC Adaugare/ Firma");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        try {
            pstmt.setInt(1,cod );
            pstmt.setString(2,nume.getText());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareLocalitati(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Localitati VALUES(?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Localitati ORDER BY IdL";
Statement stmt = con.createStatement();JFrame AddDif = new JFrame();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdL")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdL")+1;}
final int cod=ffff;

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(175,70,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(50,70,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,40,225,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Localitate");
numeLabel.setBounds(60,20,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(325,155);
AddDif.setTitle("JDBC Adaugare/ Localitate");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        try {
            pstmt.setInt(1,cod );
            pstmt.setString(2,nume.getText());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareStudiouri(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Studiouri VALUES(?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Studiouri ORDER BY IdS";
Statement stmt = con.createStatement();JFrame AddDif = new JFrame();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdS")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdS")+1;}
final int cod=ffff;

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(175,70,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(50,70,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,40,225,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Studio");
numeLabel.setBounds(60,20,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(325,155);
AddDif.setTitle("JDBC Adaugare/ Studio");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        try {
            pstmt.setInt(1,cod );
            pstmt.setString(2,nume.getText());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareTipuri_emisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Tipuri_emisiuni VALUES(?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Tipuri_emisiuni ORDER BY IdTipEmis";
Statement stmt = con.createStatement();JFrame AddDif = new JFrame();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdTipEmis")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdTipEmis")+1;}
int cod=ffff;

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(175,70,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(50,70,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,40,225,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Tip emisiune");
numeLabel.setBounds(60,20,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(325,155);
AddDif.setTitle("JDBC Adaugare/ Tip Emisiune");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        try {
            pstmt.setInt(1,cod );
            pstmt.setString(2,nume.getText());
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});
    while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void AdaugareSponsorizari(){
    JFrame AddDif = new JFrame();
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
String sql="INSERT INTO Sponsorizari VALUES(?,?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql);
String sq2="SELECT * FROM Sponsorizari ORDER BY IdSp";
Statement stmt = con.createStatement();
ResultSet rs2 = stmt.executeQuery(sq2);
int ffff=0,id=1;
while(rs2.next()){
    if(id!=rs2.getInt("IdSp")){
        ffff=id;
        break;}
    id++;
    ffff=rs2.getInt("IdSp")+1;}
final int cod=ffff;

String sq3="SELECT IdF,Firma FROM firme ORDER BY IdF";//Id Firma
ResultSet rs3 = stmt.executeQuery(sq3);

DefaultListModel ListA = new DefaultListModel<>();
id=1;
while(rs3.next()){
    if(rs3.getInt("idF")==id){
        ListA.addElement(rs3.getInt("IdF")+" ("+rs3.getString("Firma")+")");
        id++;
    }
    else{
        
        while(id!=rs3.getInt("idF")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(rs3.getInt("IdF")+" ("+rs3.getString("Firma")+")");
        id++;
    }
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(157,35,253,100);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Id Firma");
numeListA.setBounds(170,17,100,20);AddDif.add(numeListA);

String sq4="SELECT IdEmis,NumeEmisiune FROM Emisiuni ORDER BY IdEmis";//Id Emisiuni
ResultSet rs4 = stmt.executeQuery(sq4);

DefaultListModel ListB = new DefaultListModel<>();
id=1;
while(rs4.next()){
    if(rs4.getInt("idEmis")==id){
        ListB.addElement(rs4.getInt("IdEmis")+" ("+rs4.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idEmis")){
            ListB.addElement(id+", Missing id "+id);
            id++;
        }
        ListB.addElement(rs4.getInt("IdEmis")+" ("+rs4.getString("NumeEmisiune")+")");
        id++;
    }
}

JList<String> ListB2 = new JList<>(ListB);  
JScrollPane PaneB = new JScrollPane();
PaneB.setViewportView(ListB2);
ListB2.setLayoutOrientation(JList.VERTICAL);
PaneB.setBounds(430,35,190,100);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id Emisiune");
numeListB.setBounds(440,17,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(315,150,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Add");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(150,150,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(40,70,100,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Suma (Ron)");
numeLabel.setBounds(50,50,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(670,240);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Sponsorizari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1&&ListB2.getSelectedIndex() != -1)
            { int meserie=ListA2.getSelectedIndex();
            int loc=ListB2.getSelectedIndex();
            try {
                pstmt.setInt(1,cod);
                pstmt.setString(4,nume.getText());
                pstmt.setInt(2,meserie+1);
                pstmt.setInt(3,loc+1);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
            }
        else
            System.out.println("ID urile nu au fost selectate. Introducere Anulata.");
    }
    else
        System.out.println("Campul a fost lasat gol. Introducere Anulata.");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();
} catch(SQLException e){
e.printStackTrace();
}
   }
}
