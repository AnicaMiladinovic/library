package modeli;

public class Korisnik {
	
	private int id;
	private String ime;
	private String prezime;
	private String mejl;
	private String password;
	private String tip;
	
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Korisnik(int id ,String ime, String prezime, String mejl, String password,String tip) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.mejl = mejl;
		this.password = password;
		this.tip=tip;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getMejl() {
		return mejl;
	}
	public void setMejl(String mejl) {
		this.mejl = mejl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", mejl=" + mejl + ", password=" + password + "]";
	}
	
	

}
