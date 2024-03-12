package proiect_practica_an2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Afisare {
    void AfisarePersoane(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT p.IdP, p.Nume, p.Prenume, p.CNP, p.Meserie AS [IdM], m.Meserii, p.LocDomiciliu AS [IdL], l.Localitati\n" +
"FROM (Persoane AS p INNER JOIN Meserii AS m ON p.Meserie=m.IdM) INNER JOIN Localitati AS l ON p.LocDomiciliu=l.IdL ORDER BY p.IdP";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Persoane:");
System.out.println("IdP, Nume, Prenume, CNP, IdM (Meserie), IdL (LocDomiciliu)");
while(rs.next())
System.out.println(
    rs.getInt("idP")+", " +
    rs.getString("Nume")+", " +
    rs.getString("Prenume")+", " +
    rs.getString("CNP")+", " +
    rs.getInt("IdM")+" (" +
    rs.getString("Meserii")+"), " +
    rs.getInt("LocDomiciliu")+" (" +
    rs.getString("Localitati")+"), "
    );
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareMeserii(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT * FROM Meserii ORDER BY IdM";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Meserii:");
System.out.println("IdM, Meserii");
while(rs.next())
System.out.println(
rs.getInt("idM")+", " +
rs.getString("Meserii"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareColaborari(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT c.IdC, c.persoane AS [IdP], p.Nume+' '+p.Prenume AS [NumePersoana], c.Emisiuni AS [IdEmis], e.NumeEmisiune\n" +
"FROM (colaborari AS c INNER JOIN Persoane AS p ON c.Persoane=p.IdP) INNER JOIN Emisiuni AS e ON c.Emisiuni=e.IdEmis ORDER BY c.IdC;";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Colaborari:");
System.out.println("IdC, IdP (NumePersoana), IdEmis (NumeEmisiune):");
while(rs.next())
System.out.println(
rs.getInt("idC")+", " +
rs.getInt("IdP") + " (" +
rs.getString("NumePersoana") + "), " +
rs.getInt("IdEmis") + " ("+
rs.getString("NumeEmisiune")+")"
);
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareDifuzari(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT d.IdDif, d.Emisiune, e.NumeEmisiune, d.Zi, d.OraInceput, d.OraSfarsit\n" +
"FROM Difuzari AS d INNER JOIN Emisiuni AS e ON d.Emisiune=e.IdEmis ORDER BY d.IdDif;";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Difuzari:");
System.out.println("IdDif, IdEmis (NumeEmisiune), Zi, OraInceput, OraSfarsit");
while(rs.next())
System.out.println(
rs.getInt("idDif")+", " +
rs.getInt("Emisiune") + " (" +
rs.getString("NumeEmisiune")+ "), " + 
rs.getDate("Zi") + ", " +
rs.getTime("OraInceput") + ", " +
rs.getTime("OraSfarsit"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareEmisiuni(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT e.IdEmis, e.NumeEmisiune, e.TipEmisiune AS [IdTipEmis], t.TipEmisiune, e.CoordonatorSef AS [IdSef], p.Nume+' '+p.Prenume AS [NumeSef], e.Locatie AS[IdS], s.Studio\n" +
"FROM ((Emisiuni AS e INNER JOIN Tipuri_emisiuni AS t ON e.TipEmisiune=t.IdTipEmis) INNER JOIN Persoane AS p ON e.CoordonatorSef=p.IdP) INNER JOIN Studiouri AS s ON e.Locatie=s.IdS ORDER BY e.IdEmis";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Emisiuni:");
System.out.println("IdEmis, NumeEmisiune, IdTipEmis (TipEmisiune), IdSef (NumeSef), IdLoc (Studio)");
while(rs.next())
System.out.println(
rs.getInt("idEmis")+", " +
rs.getString("NumeEmisiune") + ", " +
rs.getInt("IdTipEmis") + " (" +
rs.getString("TipEmisiune") + "), " +
rs.getInt("IdSef") + " (" +
rs.getString("NumeSef") + "), " +
rs.getInt("Locatie") + " (" +
rs.getString("Studio") + ")");
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareFirme(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT * FROM Firme ORDER BY IdF";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Firme:");
System.out.println("IdF, Firma");
while(rs.next())
System.out.println(rs.getInt("IdF")+", " +
rs.getString("Firma"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareLocalitati(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT * FROM Localitati ORDER BY IdL";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Localitati:");
System.out.println("IdL, Localitati");
while(rs.next())
System.out.println(
rs.getInt("IdL")+", " +
rs.getString("Localitati"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareStudiouri(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT * FROM Studiouri ORDER BY IdS";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Studiouri:");
System.out.println("IdS, Studio");
while(rs.next())
System.out.println(
rs.getInt("idS")+", " +
rs.getString("Studio"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareTipuri_emisiuni(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();

String sql = "SELECT * FROM Tipuri_Emisiuni ORDER BY IdTipEmis";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Tipuri_Emisiuni:");
System.out.println("IdTipEmis, TipEmisiune");
while(rs.next())
System.out.println(
rs.getInt("IdTipEmis")+", " +
rs.getString("TipEmisiune"));
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
    
    void AfisareSponsorizari(){
        String path = new java.io.File("test.accdb").getAbsolutePath();
String url = "jdbc:ucanaccess://"+path;
try{
Connection con = DriverManager.getConnection(url);
Statement stmt = con.createStatement();
// Afisam persoanele
String sql = "SELECT s.IdSp, s.Firme AS [IdF], f.Firma, s.EmisiuniS AS [IdEmis], e.NumeEmisiune, s.Suma\n" +
"FROM (Sponsorizari AS s INNER JOIN Firme AS f ON s.Firme=f.IdF) INNER JOIN Emisiuni AS e ON s.EmisiuniS = e.IdEmis ORDER BY s.IdSp";
ResultSet rs = stmt.executeQuery(sql);
System.out.println("Tabel Sponsorizari:");
System.out.println("IdSp, IdF (Firma), IdEmis (NumeEmisiune), Suma");
while(rs.next())
System.out.println(
rs.getInt("IdSp")+", " +
rs.getInt("IdF")+" (" +
rs.getString("Firma")+"), " +
rs.getInt("IdEmis")+" (" +
rs.getString("NumeEmisiune")+"), " +
rs.getInt("Suma")+" Ron");
// Inchidem conexiunea
} catch(SQLException e){
e.printStackTrace();
}
    }
}
