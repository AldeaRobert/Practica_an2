package proiect_practica_an2;


import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.sql.*;  
import javax.swing.*;
import java.sql.Date;  
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

public class Modificare {
    FunctiiDate f=new FunctiiDate();
    void ModificarePersoane(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Persoane set Nume=?,Prenume=?,CNP=?,Meserie=?,LocDomiciliu=? WHERE IdP=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0 = "SELECT p.IdP, p.Nume, p.Prenume, p.CNP, p.Meserie AS [IdM], m.Meserii, p.LocDomiciliu AS [IdL], l.Localitati\n" +
"FROM (Persoane AS p INNER JOIN Meserii AS m ON p.Meserie=m.IdM) INNER JOIN Localitati AS l ON p.LocDomiciliu=l.IdL";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);
DefaultListModel List0 = new DefaultListModel<>();

int id=1;
while(rs0.next()){
    if(rs0.getInt("idP")==id){
        List0.addElement(
            rs0.getInt("idP")+", " +
            rs0.getString("Nume")+", " +
            rs0.getString("Prenume")+", " +
            rs0.getString("CNP")+", " +
            rs0.getInt("IdM")+" (" +
            rs0.getString("Meserii")+"), " +
            rs0.getInt("LocDomiciliu")+" (" +
            rs0.getString("Localitati")+"), "
            );
        id++;
    }
    else{
        while(id!=rs0.getInt("idP")){
            List0.addElement(id+", Missing id "+id);
            id++;
        }
        List0.addElement(
            rs0.getInt("idP")+", " +
            rs0.getString("Nume")+", " +
            rs0.getString("Prenume")+", " +
            rs0.getString("CNP")+", " +
            rs0.getInt("IdM")+" (" +
            rs0.getString("Meserii")+"), " +
            rs0.getInt("LocDomiciliu")+" (" +
            rs0.getString("Localitati")+"), "
            );
        id++;
    }
}
rs0.close();

JList<String> List02 = new JList<>(List0);  
JScrollPane Pane0 = new JScrollPane();
Pane0.setViewportView(List02);
List02.setLayoutOrientation(JList.VERTICAL);
Pane0.setBounds(35,55,430,255);AddDif.add(Pane0);
JLabel numeList0 = new JLabel("Lista Persoane");
JLabel numeContinutLista0 = new JLabel("IdP, Nume, Prenume, CNP, IdM(Meserie), IdL(Loc Domiciliu)");
numeContinutLista0.setBounds(35,35,400,20);AddDif.add(numeContinutLista0);
numeList0.setBounds(150,15,100,20);AddDif.add(numeList0);
numeList0.setBounds(150,15,100,20);AddDif.add(numeList0);

String sq2="SELECT * FROM persoane";
ResultSet rs2 = stmt.executeQuery(sq2);

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
PaneA.setBounds(260,380,190,100);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Id Meserie");
numeListA.setBounds(270,362,100,20);AddDif.add(numeListA);

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
PaneB.setBounds(500,380,190,100);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id LocDomiciliu");
numeListB.setBounds(510,362,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(400,540,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(250,540,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,380,100,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Nume");
numeLabel.setBounds(170,380,100,20);AddDif.add(numeLabel);

JTextField prenume = new JTextField();
prenume.setBounds(50,420,100,20);AddDif.add(prenume);
JLabel prenumeLabel = new JLabel("Prenume");
prenumeLabel.setBounds(170,420,100,20);AddDif.add(prenumeLabel);

JTextField cnp = new JTextField();
cnp.setBounds(50,460,100,20);AddDif.add(cnp);
JLabel CNPLabel = new JLabel("CNP");
CNPLabel.setBounds(170,460,100,20);AddDif.add(CNPLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(720,640);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Persoane");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
List02.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Persoane WHERE IdP="+(List02.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("Nume"));
        prenume.setText(rsx.getString("Prenume"));
        cnp.setText(rsx.getString("CNP"));
        ListA2.setSelectedIndex(rsx.getInt("Meserie")-1);
        ListB2.setSelectedIndex(rsx.getInt("LocDomiciliu")-1);
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()&&!prenume.getText().isEmpty()&&!cnp.getText().isEmpty()){
        if(List02.getSelectedIndex()!= -1 && ListA2.getSelectedIndex() != -1&&ListB2.getSelectedIndex() != -1){
            
            try {
                int meserie=ListA2.getSelectedIndex();
                int loc=ListB2.getSelectedIndex();
            
                pstmt.setString(1,nume.getText());
                pstmt.setString(2,prenume.getText());
                pstmt.setString(3,cnp.getText());
                pstmt.setInt(4,meserie+1);
                pstmt.setInt(5,loc+1);
                pstmt.setInt(6,List02.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID urile nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});
while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}}
   
    void ModificareMeserii(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Meserii set Meserii=? WHERE IdM=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0="SELECT * FROM Meserii";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);

DefaultListModel ListA = new DefaultListModel<>();
int id=1;
while(rs0.next()){
    if(rs0.getInt("idM")==id){
        ListA.addElement(
            rs0.getInt("IdM")+", " +
            rs0.getString("Meserii"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idM")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs0.getInt("IdM")+", " +
            rs0.getString("Meserii"));
        id++;
    }
}
rs0.close();
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
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(325,365,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(125,365,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,325,150,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Meserie");
numeLabel.setBounds(220,325,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(550,450);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Meserii");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Meserii WHERE IdM="+(ListA2.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("Meserii"));
    }
    catch (SQLException ex) {
    }
}
);

AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1){
            
            try {
                pstmt.setString(1,nume.getText());
                pstmt.setInt(2,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID ul nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});
while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}}
    
    void ModificareColaborari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Colaborari set Persoane=?,Emisiuni=? WHERE IdC=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0 = "SELECT c.IdC, c.persoane AS [IdP], p.Nume+' '+p.Prenume AS [NumePersoana], c.Emisiuni AS [IdEmis], e.NumeEmisiune\n" +
"FROM (colaborari AS c INNER JOIN Persoane AS p ON c.Persoane=p.IdP) INNER JOIN Emisiuni AS e ON c.Emisiuni=e.IdEmis ORDER BY c.IdC;";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);
DefaultListModel List0 = new DefaultListModel<>();

int id=1;
while(rs0.next()){
    if(rs0.getInt("idC")==id){
        List0.addElement(
            rs0.getInt("idC")+", " +
            rs0.getInt("IdP") + " (" +
            rs0.getString("NumePersoana") + "), " +
            rs0.getInt("IdEmis") + " ("+
            rs0.getString("NumeEmisiune")+")"
            );
        id++;
    }
    else{
        
        while(id!=rs0.getInt("idC")){
            List0.addElement(id+", Missing id "+id);
            id++;
        }
        List0.addElement(
            rs0.getInt("idC")+", " +
            rs0.getInt("IdP") + " (" +
            rs0.getString("NumePersoana") + "), " +
            rs0.getInt("IdEmis") + " ("+
            rs0.getString("NumeEmisiune")+")"
            );
        id++;
    }
}
rs0.close();

JList<String> List02 = new JList<>(List0);  
JScrollPane Pane0 = new JScrollPane();
Pane0.setViewportView(List02);
List02.setLayoutOrientation(JList.VERTICAL);
Pane0.setBounds(35,55,430,255);AddDif.add(Pane0);
JLabel numeList0 = new JLabel("Lista Colaborari");
JLabel numeContinutLista0 = new JLabel("IdC, IdP(Nume Persoana), IdEmis(Nume Emisiune)");
numeContinutLista0.setBounds(35,35,400,20);AddDif.add(numeContinutLista0);
numeList0.setBounds(150,15,200,20);AddDif.add(numeList0);

DefaultListModel ListA = new DefaultListModel<>();
String sq3="SELECT IdP, Nume+' '+Prenume AS [NumePers] From Persoane ORDER BY IdP;";//Id Pers
ResultSet rs4 = stmt.executeQuery(sq3);

id=1;
while(rs4.next()){
    if(rs4.getInt("idP")==id){
        ListA.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idP")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(rs4.getInt("IdP")+" ("+rs4.getString("NumePers")+")");
        id++;
    }
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(50,360,190,140);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Id Persoane");
numeListA.setBounds(60,342,100,20);AddDif.add(numeListA);

DefaultListModel ListB = new DefaultListModel<>();
String sq4="SELECT IdEmis,NumeEmisiune FROM Emisiuni ORDER BY IdEmis";//Id Emisiuni
ResultSet rs5 = stmt.executeQuery(sq4);

id=1;
while(rs5.next()){
    if(rs5.getInt("idEmis")==id){
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs5.getInt("idEmis")){
            ListB.addElement(id+", Missing id "+id);
            id++;
        }
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
}

JList<String> ListB2 = new JList<>(ListB);  
JScrollPane PaneB = new JScrollPane();
PaneB.setViewportView(ListB2);
ListB2.setLayoutOrientation(JList.VERTICAL);
PaneB.setBounds(260,360,190,140);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id Emisiuni");
numeListB.setBounds(270,342,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,540,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(100,540,100,25);AddDif.add(panel2);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,640);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Colaborari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
List02.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Colaborari WHERE IdC="+(List02.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        ListA2.setSelectedIndex(rsx.getInt("Persoane")-1);
        ListB2.setSelectedIndex(rsx.getInt("Emisiuni")-1);
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(List02.getSelectedIndex()!= -1 && ListA2.getSelectedIndex() != -1&&ListB2.getSelectedIndex() != -1){
        try {
            int meserie=ListA2.getSelectedIndex();
            int loc=ListB2.getSelectedIndex();
            
            pstmt.setInt(1,meserie+1);
            pstmt.setInt(2,loc+1);
            pstmt.setInt(3,List02.getSelectedIndex()+1);
            pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
            //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
    }
    else
        System.out.println("Id ul nu a fost selectat. Modificare anulata.\n");});
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

    void ModificareDifuzari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Difuzari set Emisiune=?,Zi=?,OraInceput=?,OraSfarsit=? WHERE IdDif=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0 ="SELECT d.IdDif, d.Emisiune, e.NumeEmisiune, d.Zi, d.OraInceput, d.OraSfarsit\n" +
"FROM Difuzari AS d INNER JOIN Emisiuni AS e ON d.Emisiune=e.IdEmis ORDER BY d.IdDif;";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);
DefaultListModel List0 = new DefaultListModel<>();

int id=1;
while(rs0.next()){
    if(rs0.getInt("idDif")==id){
        List0.addElement(
            rs0.getInt("idDif")+", " +
            rs0.getInt("Emisiune") + " (" +
            rs0.getString("NumeEmisiune")+ "), " + 
            rs0.getDate("Zi") + ", " +
            rs0.getTime("OraInceput") + ", " +
            rs0.getTime("OraSfarsit"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idDif")){
            List0.addElement(id+", Missing id "+id);
            id++;
        }
        List0.addElement(
            rs0.getInt("idDif")+", " +
            rs0.getInt("Emisiune") + " (" +
            rs0.getString("NumeEmisiune")+ "), " + 
            rs0.getDate("Zi") + ", " +
            rs0.getTime("OraInceput") + ", " +
            rs0.getTime("OraSfarsit"));
        id++;
    }
}
rs0.close();

JList<String> List02 = new JList<>(List0);  
JScrollPane Pane0 = new JScrollPane();
Pane0.setViewportView(List02);
List02.setLayoutOrientation(JList.VERTICAL);
Pane0.setBounds(35,55,430,255);AddDif.add(Pane0);
JLabel numeList0 = new JLabel("Lista Difuzari");
JLabel numeContinutLista0 = new JLabel("IdDif, IdEmis(Nume Emisiune), Zi, OraInceput, OraSfarsit");
numeContinutLista0.setBounds(35,35,400,20);AddDif.add(numeContinutLista0);
numeList0.setBounds(150,15,200,20);AddDif.add(numeList0);

DefaultListModel ListB = new DefaultListModel<>();
String sq4="SELECT IdEmis,NumeEmisiune FROM Emisiuni ORDER BY IdEmis";//Id Emisiuni
ResultSet rs5 = stmt.executeQuery(sq4);

id=1;
while(rs5.next()){
    if(rs5.getInt("idEmis")==id){
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs5.getInt("idEmis")){
            ListB.addElement(id+", Missing id "+id);
            id++;
        }
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
}
int xDate=0,yDate=310;

JList<String> ListB2 = new JList<>(ListB);  
JScrollPane PaneB = new JScrollPane();
PaneB.setViewportView(ListB2);
ListB2.setLayoutOrientation(JList.VERTICAL);
PaneB.setBounds(260+xDate,30+yDate,200,110);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id Emisiuni");
numeListB.setBounds(270+xDate,10+yDate,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300+xDate,150+yDate,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(100+xDate,150+yDate,100,25);AddDif.add(panel2);

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

FormatZi.setBounds(50+xDate,10+yDate,100,20);AddDif.add(FormatZi);
ziDD.setBounds(50+xDate,30+yDate,20,20);AddDif.add(ziDD);
ziMM.setBounds(80+xDate,30+yDate,20,20);AddDif.add(ziMM);
ziYYYY.setBounds(110+xDate,30+yDate,34,20);AddDif.add(ziYYYY);

Symb1.setBounds(72+xDate,30+yDate,4,20);AddDif.add(Symb1);
Symb11.setBounds(102+xDate,30+yDate,4,20);AddDif.add(Symb11);

Zi.setBounds(160+xDate,30+yDate,30,20);AddDif.add(Zi);

FormatOraI.setBounds(50+xDate,50+yDate,100,20);AddDif.add(FormatOraI);
OraIhh.setBounds(50+xDate,70+yDate,20,20);AddDif.add(OraIhh);
OraImm.setBounds(80+xDate,70+yDate,20,20);AddDif.add(OraImm);
OraIss.setBounds(110+xDate,70+yDate,20,20);AddDif.add(OraIss);

Symb2.setBounds(73+xDate,70+yDate,4,20);AddDif.add(Symb2);
Symb22.setBounds(103+xDate,70+yDate,4,20);AddDif.add(Symb22);

OraInceput.setBounds(160+xDate,70+yDate,100,20);AddDif.add(OraInceput);

FormatOraF.setBounds(50+xDate,90+yDate,100,20);AddDif.add(FormatOraF);
OraFhh.setBounds(50+xDate,110+yDate,20,20);AddDif.add(OraFhh);
OraFmm.setBounds(80+xDate,110+yDate,20,20);AddDif.add(OraFmm);
OraFss.setBounds(110+xDate,110+yDate,20,20);AddDif.add(OraFss);

Symb3.setBounds(73+xDate,110+yDate,4,20);AddDif.add(Symb3);
Symb33.setBounds(103+xDate,110+yDate,4,20);AddDif.add(Symb33);

OraFinal.setBounds(160+xDate,110+yDate,100,20);AddDif.add(OraFinal);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(540,540);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Difuzari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);

List02.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Difuzari WHERE IdDif="+(List02.getSelectedIndex()+1);
        ResultSet rsx = stmt.executeQuery(sqx);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        rsx.next();
        ListB2.setSelectedIndex(rsx.getInt("Emisiune")-1);
        Calendar c = Calendar.getInstance();
        c.setTime(rsx.getDate("Zi"));
        ziDD.setText(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
        ziMM.setText(String.valueOf(c.get(Calendar.MONTH)+1));
        ziYYYY.setText(String.valueOf(c.get(Calendar.YEAR)));
        OraIss.setText(rsx.getString("OraInceput").substring(17,19));
        OraImm.setText(rsx.getString("OraInceput").substring(14,16));
        OraIhh.setText(rsx.getString("OraInceput").substring(11,13));
        OraFss.setText(rsx.getString("OraSfarsit").substring(17,19));
        OraFmm.setText(rsx.getString("OraSfarsit").substring(14,16));
        OraFhh.setText(rsx.getString("OraSfarsit").substring(11,13));
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!OraFhh.getText().isEmpty()&&!OraFmm.getText().isEmpty()&&!OraFss.getText().isEmpty()
            &&!OraIhh.getText().isEmpty()&&!OraImm.getText().isEmpty()&&!OraIss.getText().isEmpty()
            &&!ziDD.getText().isEmpty()&&!ziMM.getText().isEmpty()&&!ziYYYY.getText().isEmpty()
            ){
        if(f.ValidDate(ziDD.getText(),ziMM.getText(),ziYYYY.getText())&&f.ValidOra(OraIss.getText(),OraImm.getText(),OraIhh.getText())&&f.ValidOra(OraFss.getText(),OraFmm.getText(),OraFhh.getText())&&f.ValidOraDif(OraIss.getText(),OraImm.getText(),OraIhh.getText(),OraFss.getText(),OraFmm.getText(),OraFhh.getText())){
            
            if(List02.getSelectedIndex()!= -1 &&ListB2.getSelectedIndex() != -1){
                try {
                    int loc=ListB2.getSelectedIndex();

                    pstmt.setDate(2,Date.valueOf(ziYYYY.getText()+'-'+ziMM.getText()+'-'+ziDD.getText()));
                    pstmt.setTime(3,Time.valueOf(OraIhh.getText()+':'+OraImm.getText()+':'+OraIss.getText()));
                    pstmt.setTime(4,Time.valueOf(OraFhh.getText()+':'+OraFmm.getText()+':'+OraFss.getText()));

                    pstmt.setInt(1,loc+1);
                    pstmt.setInt(5,List02.getSelectedIndex()+1);
                    pstmt.executeUpdate();
                }
                catch (SQLException ex) {
                    System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                    //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
            else
                System.out.println("Id urile nu a fost selectate. Modificare anulata.\n");
        }
        else
            System.out.println("Data, OraInceput sau OraFinala este invalida sau OraInceput este dupa OraFinal.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol sau datele introduse sunt invalide. Modificare anulata.\n");
});
    
while(true){
    if(exit.isSelected()||Add.isSelected())
        break;
    System.out.print("");}  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void ModificareEmisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);
String sql="UPDATE Emisiuni set NumeEmisiune=?,TipEmisiune=?,CoordonatorSef=?,Locatie=? WHERE IdEmis=?";
PreparedStatement pstmt=con.prepareStatement(sql);
Statement stmt = con.createStatement();
String sq2 = "SELECT e.IdEmis, e.NumeEmisiune, e.TipEmisiune AS [IdTipEmis], t.TipEmisiune, e.CoordonatorSef AS [IdSef], p.Nume+' '+p.Prenume AS [NumeSef], e.Locatie AS[IdS], s.Studio\n" +
"FROM ((Emisiuni AS e INNER JOIN Tipuri_emisiuni AS t ON e.TipEmisiune=t.IdTipEmis) INNER JOIN Persoane AS p ON e.CoordonatorSef=p.IdP) INNER JOIN Studiouri AS s ON e.Locatie=s.IdS";
ResultSet rs = stmt.executeQuery(sq2);
DefaultListModel ListA = new DefaultListModel<>();
int id=1,yDate=310;
while(rs.next()){
    if(rs.getInt("idEmis")==id){
        ListA.addElement(
            rs.getInt("idEmis")+", " +
            rs.getString("NumeEmisiune") + ", " +
            rs.getInt("IdTipEmis") + " (" +
            rs.getString("TipEmisiune") + "), " +
            rs.getInt("IdSef") + " (" +
            rs.getString("NumeSef") + "), " +
            rs.getInt("Locatie") + " (" +
            rs.getString("Studio") + ")");
        id++;
    }
    else{
        while(id!=rs.getInt("idEmis")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs.getInt("idEmis")+", " +
            rs.getString("NumeEmisiune") + ", " +
            rs.getInt("IdTipEmis") + " (" +
            rs.getString("TipEmisiune") + "), " +
            rs.getInt("IdSef") + " (" +
            rs.getString("NumeSef") + "), " +
            rs.getInt("Locatie") + " (" +
            rs.getString("Studio") + ")");
        id++;
    }
}
rs.close();
JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,530,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Emisiuni");
JLabel numeContinutListaA = new JLabel("IdEmis, NumeEmisiune, IdTipEmis(Tip Emisiune), IdP(Nume Sef), IdS(Studio)");
numeContinutListaA.setBounds(35,35,500,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

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
scrollPaneTipEmis.setBounds(50,35+yDate,140,90);AddDif.add(scrollPaneTipEmis);

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
scrollPaneP.setBounds(220,35+yDate,200,90);AddDif.add(scrollPaneP);

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
scrollPaneS.setBounds(450,35+yDate,240,90);AddDif.add(scrollPaneS);

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

NumeEmisiune.setBounds(50,150+yDate,140,20);AddDif.add(NumeEmisiune);
NumeEmisiuneLabel.setBounds(200,150+yDate,140,20);AddDif.add(NumeEmisiuneLabel);

IdTipEmisListName.setBounds(60,10+yDate,100,20);AddDif.add(IdTipEmisListName);
IdPListName.setBounds(260,10+yDate,100,20);AddDif.add(IdPListName);
IdSListName.setBounds(500,10+yDate,120,20);AddDif.add(IdSListName);

Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(390,150+yDate,100,25);AddDif.add(panel2);
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(550,150+yDate,100,25);AddDif.add(panel);
AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(750,550);
AddDif.setTitle("JDBC Practica/ Adaugare in Tabel/ Emisiuni");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Emisiuni WHERE IdEmis="+(ListA2.getSelectedIndex()+1);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        NumeEmisiune.setText(rsx.getString("NumeEmisiune"));
        IdTipEmisList2.setSelectedIndex(rsx.getInt("TipEmisiune")-1);
        IdPList2.setSelectedIndex(rsx.getInt("CoordonatorSef")-1);
        IdSList2.setSelectedIndex(rsx.getInt("Locatie")-1);
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!NumeEmisiune.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1&&IdTipEmisList2.getSelectedIndex() != -1&&IdPList2.getSelectedIndex() != -1&&IdSList2.getSelectedIndex() != -1)
            {int alegTipEmis=IdTipEmisList2.getSelectedIndex();
            int alegP=IdPList2.getSelectedIndex();
            int alegS=IdSList2.getSelectedIndex();
            try {
                pstmt.setString(1,NumeEmisiune.getText());
                pstmt.setInt(2,alegTipEmis+1);
                pstmt.setInt(3,alegP+1);
                pstmt.setInt(4,alegS+1);
                pstmt.setInt(5,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");
        }
            }
        else
            System.out.println("Nu au fost selectate toate ID urile. Modificare anulata.\n");
    }
    else
        System.out.println("Campul a fost lasat gol. Modificare anulata.\n");});
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

    void ModificareFirme(){    
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Firme set Firma=? WHERE IdF=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0="SELECT * FROM Firme";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);

DefaultListModel ListA = new DefaultListModel<>();
int id=1;
while(rs0.next()){
    if(rs0.getInt("idF")==id){
        ListA.addElement(
            rs0.getInt("IdF")+", " +
            rs0.getString("Firma"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idF")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs0.getInt("IdF")+", " +
            rs0.getString("Firma"));
        id++;
    }
}
rs0.close();
JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Firme");
JLabel numeContinutListaA = new JLabel("IdF, Firma");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(325,365,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(125,365,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,325,200,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Firma");
numeLabel.setBounds(270,325,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(550,450);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Firme");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);



ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Firme WHERE IdF="+(ListA2.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("Firma"));
    }
    catch (SQLException ex) {
    }
}
);

Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1){
            
            try {
                pstmt.setString(1,nume.getText());
                pstmt.setInt(2,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID ul nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void ModificareLocalitati(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Localitati set Localitati=? WHERE IdL=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0="SELECT * FROM Localitati";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);

DefaultListModel ListA = new DefaultListModel<>();
int id=1;
while(rs0.next()){
    if(rs0.getInt("idL")==id){
        ListA.addElement(
            rs0.getInt("IdL")+", " +
            rs0.getString("Localitati"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idL")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs0.getInt("IdL")+", " +
            rs0.getString("Localitati"));
        id++;
    }
}
rs0.close();
JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Localitati");
JLabel numeContinutListaA = new JLabel("IdL, Localitati");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(325,365,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(125,365,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,325,150,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Localitati");
numeLabel.setBounds(220,325,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(550,450);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Localitati");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Localitati WHERE IdL="+(ListA2.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("Localitati"));
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1){
            
            try {
                pstmt.setString(1,nume.getText());
                pstmt.setInt(2,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID ul nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void ModificareStudiouri(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Studiouri set Studio=? WHERE IdS=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0="SELECT * FROM Studiouri";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);

DefaultListModel ListA = new DefaultListModel<>();
int id=1;
while(rs0.next()){
    if(rs0.getInt("idS")==id){
        ListA.addElement(
            rs0.getInt("IdS")+", " +
            rs0.getString("Studio"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idS")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs0.getInt("IdS")+", " +
            rs0.getString("Studio"));
        id++;
    }
}
rs0.close();
JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Studiouri");
JLabel numeContinutListaA = new JLabel("IdS, Studio");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);
numeListA.setBounds(150,15,100,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(325,365,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(125,365,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,325,200,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("Studio");
numeLabel.setBounds(270,325,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(550,450);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Studiouri");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Studiouri WHERE IdS="+(ListA2.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("Studio"));
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1){
            
            try {
                pstmt.setString(1,nume.getText());
                pstmt.setInt(2,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID ul nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void ModificareTipuri_emisiuni(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Tipuri_emisiuni set TipEmisiune=? WHERE IdTipEmis=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0="SELECT * FROM Tipuri_emisiuni";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);

DefaultListModel ListA = new DefaultListModel<>();
int id=1;
while(rs0.next()){
    if(rs0.getInt("idTipEmis")==id){
        ListA.addElement(
            rs0.getInt("IdTipEmis")+", " +
            rs0.getString("TipEmisiune"));
        id++;
    }
    else{
        while(id!=rs0.getInt("idTipEmis")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(
            rs0.getInt("IdTipEmis")+", " +
            rs0.getString("TipEmisiune"));
        id++;
    }
}
rs0.close();
JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(35,55,430,255);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Lista Tipuri_emisiuni");
JLabel numeContinutListaA = new JLabel("IdTipEmis, TipEmisiune");
numeContinutListaA.setBounds(35,35,300,20);AddDif.add(numeContinutListaA);
numeListA.setBounds(150,15,200,20);AddDif.add(numeListA);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(325,365,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(125,365,100,25);AddDif.add(panel2);

JTextField nume = new JTextField();
nume.setBounds(50,325,150,20);AddDif.add(nume);
JLabel numeLabel = new JLabel("TipEmisiune");
numeLabel.setBounds(220,325,100,20);AddDif.add(numeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(550,450);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Tipuri_emisiuni");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
ListA2.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Tipuri_emisiuni WHERE IdTipEmis="+(ListA2.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        nume.setText(rsx.getString("TipEmisiune"));
    }
    catch (SQLException ex) {
    }
}
);

Add.addActionListener((ActionEvent e) -> {
    if(!nume.getText().isEmpty()){
        if(ListA2.getSelectedIndex() != -1){
            
            try {
                pstmt.setString(1,nume.getText());
                pstmt.setInt(2,ListA2.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID ul nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol. Modificare anulata.\n");});while(true){
        if(exit.isSelected()||Add.isSelected())
            break;
        System.out.print("");
        }  
    AddDif.dispose();

} catch(SQLException e){
e.printStackTrace();
}
   }
    
    void ModificareSponsorizari(){
    String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
JFrame AddDif= new JFrame(); 
Connection con = DriverManager.getConnection(url);

String sql="UPDATE Sponsorizari set Firme=?,EmisiuniS=?,Suma=? WHERE IdSp=?";
PreparedStatement pstmt=con.prepareStatement(sql);

String sq0 = "SELECT s.IdSp, s.Firme AS [IdF], f.Firma, s.EmisiuniS AS [IdEmis], e.NumeEmisiune, s.Suma\n" +
"FROM (Sponsorizari AS s INNER JOIN Firme AS f ON s.Firme=f.IdF) INNER JOIN Emisiuni AS e ON s.EmisiuniS = e.IdEmis";
Statement stmt = con.createStatement();
ResultSet rs0 = stmt.executeQuery(sq0);
DefaultListModel List0 = new DefaultListModel<>();

int id=1;
while(rs0.next()){
    if(rs0.getInt("idSp")==id){
        List0.addElement(
            rs0.getInt("IdSp")+", " +
            rs0.getInt("IdF")+" (" +
            rs0.getString("Firma")+"), " +
            rs0.getInt("IdEmis")+" (" +
            rs0.getString("NumeEmisiune")+"), " +
            rs0.getInt("Suma")+" Ron");
        id++;
    }
    else{
        while(id!=rs0.getInt("idSp")){
            List0.addElement(id+", Missing id "+id);
            id++;
        }
        List0.addElement(
            rs0.getInt("IdSp")+", " +
            rs0.getInt("IdF")+" (" +
            rs0.getString("Firma")+"), " +
            rs0.getInt("IdEmis")+" (" +
            rs0.getString("NumeEmisiune")+"), " +
            rs0.getInt("Suma")+" Ron");
        id++;
    }
}
rs0.close();

JList<String> List02 = new JList<>(List0);  
JScrollPane Pane0 = new JScrollPane();
Pane0.setViewportView(List02);
List02.setLayoutOrientation(JList.VERTICAL);
Pane0.setBounds(35,55,430,255);AddDif.add(Pane0);
JLabel numeList0 = new JLabel("Lista Sponsorizari");
JLabel numeContinutLista0 = new JLabel("IdSp, IdF(Nume Firma), IdEmis(Nume Emisiune), Suma");
numeContinutLista0.setBounds(35,35,400,20);AddDif.add(numeContinutLista0);
numeList0.setBounds(150,15,200,20);AddDif.add(numeList0);

DefaultListModel ListA = new DefaultListModel<>();
String sq3="SELECT IdF,Firma FROM Firme ORDER BY IdF";//Id Meserii
ResultSet rs4 = stmt.executeQuery(sq3);

id=1;
while(rs4.next()){
    if(rs4.getInt("idF")==id){
        ListA.addElement(rs4.getInt("IdF")+" ("+rs4.getString("Firma")+")");
        id++;
    }
    else{
        
        while(id!=rs4.getInt("idF")){
            ListA.addElement(id+", Missing id "+id);
            id++;
        }
        ListA.addElement(rs4.getInt("IdF")+" ("+rs4.getString("Firma")+")");
        id++;
    }
}

JList<String> ListA2 = new JList<>(ListA);  
JScrollPane PaneA = new JScrollPane();
PaneA.setViewportView(ListA2);
ListA2.setLayoutOrientation(JList.VERTICAL);
PaneA.setBounds(50,400,190,100);AddDif.add(PaneA);
JLabel numeListA = new JLabel("Id Firma");
numeListA.setBounds(60,382,100,20);AddDif.add(numeListA);

DefaultListModel ListB = new DefaultListModel<>();
String sq4="SELECT IdEmis,NumeEmisiune FROM Emisiuni ORDER BY IdEmis";//Id Emisiuni
ResultSet rs5 = stmt.executeQuery(sq4);

id=1;
while(rs5.next()){
    if(rs5.getInt("idEmis")==id){
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
    else{
        
        while(id!=rs5.getInt("idEmis")){
            ListB.addElement(id+", Missing id "+id);
            id++;
        }
        ListB.addElement(rs5.getInt("IdEmis")+" ("+rs5.getString("NumeEmisiune")+")");
        id++;
    }
}

JList<String> ListB2 = new JList<>(ListB);  
JScrollPane PaneB = new JScrollPane();
PaneB.setViewportView(ListB2);
ListB2.setLayoutOrientation(JList.VERTICAL);
PaneB.setBounds(260,400,190,100);AddDif.add(PaneB);
JLabel numeListB = new JLabel("Id Emisiuni");
numeListB.setBounds(270,382,100,20);AddDif.add(numeListB);

AddDif.setLayout(null);
JPanel panel = new JPanel(null);
JPanel panel2 = new JPanel(null);

JToggleButton exit=new JToggleButton("Inchidere"); 
exit.setBounds(0,0,100,25);panel.add(exit);
panel.setBounds(300,540,100,25);AddDif.add(panel);

JToggleButton Add = new JToggleButton("Modifica");
Add.setBounds(0,0,100,25);panel2.add(Add);
panel2.setBounds(100,540,100,25);AddDif.add(panel2);

JTextField prenume = new JTextField();
prenume.setBounds(50,350,100,20);AddDif.add(prenume);
JLabel prenumeLabel = new JLabel("Suma");
prenumeLabel.setBounds(170,350,100,20);AddDif.add(prenumeLabel);

AddDif.setVisible(true);
AddDif.setResizable(false);
AddDif.setSize(500,640);
AddDif.setTitle("JDBC Practica/ Modificare tuplu/ Specializari");
AddDif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
AddDif.setLocation(dim.width/2-AddDif.getSize().width/2, dim.height/2-AddDif.getSize().height/2);
List02.addListSelectionListener((ActionEventf) ->{
    try{
        String sqx="SELECT * FROM Sponsorizari WHERE IdSp="+(List02.getSelectedIndex()+1);
        //ListA2.setSelectedIndex(id);
        ResultSet rsx = stmt.executeQuery(sqx);
        rsx.next();
        prenume.setText(rsx.getString("Suma"));
        ListA2.setSelectedIndex(rsx.getInt("Firme")-1);
        ListB2.setSelectedIndex(rsx.getInt("EmisiuniS")-1);
    }
    catch (SQLException ex) {
    }
}
);
Add.addActionListener((ActionEvent e) -> {
    if(!prenume.getText().isEmpty()&&Integer.parseInt(prenume.getText())<=99999999&&Integer.parseInt(prenume.getText())>=1){
        if(List02.getSelectedIndex()!= -1 && ListA2.getSelectedIndex() != -1&&ListB2.getSelectedIndex() != -1){
            
            try {
                int meserie=ListA2.getSelectedIndex();
                int loc=ListB2.getSelectedIndex();
            
                pstmt.setString(3,prenume.getText());
                pstmt.setInt(1,meserie+1);
                pstmt.setInt(2,loc+1);
                pstmt.setInt(4,List02.getSelectedIndex()+1);
                pstmt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Eroare ,datele introducere nu respecta regulile de integritate referentiala sau chiei semantice. Introducere anulata\n");}
                //Logger.getLogger(Adaugare.class.getName()).log(Level.SEVERE, null, ex);}
            }
        else
            System.out.println("ID urile nu au fost selectate. Modificare anulata.\n");
    }
    else
        System.out.println("Cel putin un camp a fost lasat gol sau datele introduse sunt invalide. Modificare anulata.\n");});
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
}