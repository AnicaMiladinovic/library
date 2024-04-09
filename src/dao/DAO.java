package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modeli.Knjiga;
import modeli.Korisnik;
import modeli.Pozajmica;

public class DAO {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");
	}

	public ArrayList<Korisnik> vratiKorisnike() throws ClassNotFoundException, SQLException {
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();

		connect();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from korisnici");

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			String mejl = resultSet.getString("mejl");
			String password = resultSet.getString("password");
			String tip = resultSet.getString("tip");

			Korisnik k= new Korisnik(id, ime, prezime, mejl, password,tip);

			lista.add(k);
		}
		close();
		return lista;
	}
	
	public Korisnik vratiKorisnika(String mejl) throws SQLException, ClassNotFoundException {
		
		connect();
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("select * from korisnici where mejl=?");
		preparedStatement.setString(1, mejl);
		preparedStatement.execute();
		resultSet=preparedStatement.getResultSet();
		
		if(resultSet.next()) {
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			String usermejl = resultSet.getString("mejl");
			String password = resultSet.getString("password");
			String tip = resultSet.getString("tip");

			Korisnik k= new Korisnik(id, ime, prezime, usermejl, password,tip);
			close();
			return k;
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Nepostojeci korisnik");
		}
		close();
		return null;
		
		
		
	}
	
public Knjiga vratiKnjiguPoNazivu(String naziv ) throws SQLException, ClassNotFoundException {
		
		connect();
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("select * from knjige where naziv=?");
		preparedStatement.setString(1, naziv);
		preparedStatement.execute();
		resultSet=preparedStatement.getResultSet();
		
		if(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String autor = resultSet.getString("autor");
			String zanr = resultSet.getString("zanr");
			Boolean pozajmljena=resultSet.getBoolean("pozajmljena");

			Knjiga knjiga =new Knjiga(id, naziv, autor, zanr,pozajmljena);
			close();
			return knjiga;
			
		}
		close();
		return null;
		
		
		
	}
	
	public void obrisiKnjigu(int id) throws SQLException, ClassNotFoundException {
		
		connect();
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("delete from knjige where id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		close();		
		
	}
	
	public ArrayList<Korisnik> vratiKorisnikePSTM() throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<Korisnik> lista = new ArrayList<Korisnik>();

		connect();
		preparedStatement = connect.prepareStatement("select * from korisnici");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		//preparedStatement.setString(1, o.getJmbg());
		
		preparedStatement.execute();
		
		//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			String mejl = resultSet.getString("mejl");
			String password = resultSet.getString("password");
			String tip = resultSet.getString("tip");

			Korisnik k= new Korisnik(id, ime, prezime, mejl, password,tip);
			lista.add(k);
		}
		//****KRAJ		KRAJ OBRADE ResultSet-a	
		
		close();
		return lista;
	}

	public void unesiKorisnika(Korisnik k) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("insert into korisnici (ime, prezime, mejl, password) values (?, ?, ?, ?)");

		preparedStatement.setString(1, k.getIme());
		preparedStatement.setString(2, k.getPrezime());
		preparedStatement.setString(3, k.getMejl());
		preparedStatement.setString(4, k.getPassword());
		preparedStatement.executeUpdate();
		close();
	}
	
	public int unesiKorisnikaIVratiId(Korisnik k) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("insert into korisnici (ime, prezime, mejl, password) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, k.getIme());
		preparedStatement.setString(2, k.getPrezime());
		preparedStatement.setString(3, k.getMejl());
		preparedStatement.setString(4, k.getPassword());
		preparedStatement.executeUpdate();
		
		
		resultSet = preparedStatement.getResultSet();
		ResultSet keys = preparedStatement.getGeneratedKeys();    
		keys.next();  
		int id = keys.getInt(1);
		close();
		
		return id;
	}
	
	public ArrayList<Knjiga> vratiKnjige() throws ClassNotFoundException, SQLException {
		ArrayList<Knjiga> lista = new ArrayList<Knjiga>();

		connect();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from knjige");

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String naziv = resultSet.getString("naziv");
			String autor = resultSet.getString("autor");
			String zanr = resultSet.getString("zanr");
			Boolean pozajmljena=resultSet.getBoolean("pozajmljena");

			Knjiga knjiga =new Knjiga(id, naziv, autor, zanr,pozajmljena);

			lista.add(knjiga);
		}
		close();
		return lista;
	}
	
	public void vratiPozajmice(int id_pozajmice) throws ClassNotFoundException, SQLException {

		connect();
		preparedStatement = connect.prepareStatement("UPDATE `pozajmice` SET `datum_vracanja`=? WHERE id_pozajmice=?");
		preparedStatement.setDate(1, new java.sql.Date(new Date().getTime()));
		preparedStatement.setInt(2, id_pozajmice);
		preparedStatement.execute();
		resultSet=preparedStatement.getResultSet();

		
	}
	
	public ArrayList<Pozajmica> pozajmice(Korisnik k) throws ClassNotFoundException, SQLException{
		ArrayList<Pozajmica> lista = new ArrayList<Pozajmica>();
		connect();
		preparedStatement = connect.prepareStatement("select* from pozajmice where id_korisnika=? and datum_vracanja is NULL");
		preparedStatement.setInt(1, k.getId());
		preparedStatement.execute();
		resultSet=preparedStatement.getResultSet();
		while (resultSet.next()) {
			int id_pozajmice=resultSet.getInt("id_pozajmice");
			int id_knjige = resultSet.getInt("id_knjige");
			int id_korisnika = resultSet.getInt("id_korisnika");
			Date datum_iznajmljivanja = resultSet.getDate("datum_uzimanja");
			Date datum_vracanja = resultSet.getDate("datum_vracanja");

			Pozajmica pozajmica = new Pozajmica(id_pozajmice, id_knjige, id_korisnika, datum_iznajmljivanja, datum_vracanja);

			lista.add(pozajmica);
		}
		close();
		return lista;
		
	}
	public ArrayList<Pozajmica> moje_pozajmice(Korisnik k) throws ClassNotFoundException, SQLException{
		ArrayList<Pozajmica> lista = new ArrayList<Pozajmica>();
		connect();
		preparedStatement = connect.prepareStatement("select* from pozajmice where id_korisnika=?");
		preparedStatement.setInt(1, k.getId());
		preparedStatement.execute();
		resultSet=preparedStatement.getResultSet();
		while (resultSet.next()) {
			int id_pozajmice=resultSet.getInt("id_pozajmice");
			int id_knjige = resultSet.getInt("id_knjige");
			int id_korisnika = resultSet.getInt("id_korisnika");
			Date datum_iznajmljivanja = resultSet.getDate("datum_uzimanja");
			Date datum_vracanja = resultSet.getDate("datum_vracanja");

			Pozajmica pozajmica = new Pozajmica(id_pozajmice, id_knjige, id_korisnika, datum_iznajmljivanja, datum_vracanja);

			lista.add(pozajmica);
		}
		close();
		return lista;
		
	}
	
	
	public void unesiKnjigu(Knjiga k) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("insert into knjige (naziv, autor, zanr, pozajmljena) values (?, ?, ?, ?)");

		preparedStatement.setString(1, k.getNaziv());
		preparedStatement.setString(2, k.getAutor());
		preparedStatement.setString(3, k.getZanr());
		preparedStatement.setBoolean(4, false);
		preparedStatement.executeUpdate();
		close();
	}
	
	public void unesiPozajmicu(Knjiga k, Korisnik k1) throws SQLException, ClassNotFoundException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `pozajmice` (`id_knjige`, `id_korisnika`, `datum_uzimanja`, `datum_vracanja`) VALUES (?, ?, ?, NULL);");

		preparedStatement.setInt(1, k.getId());
		preparedStatement.setInt(2, k1.getId());
		preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
		preparedStatement.executeUpdate();
		close();
	}

	


	

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
