package modeli;

public class Knjiga {
	
	private int id;
	private String naziv;
	private String autor;
	private String zanr;
	private boolean pozajmljena;
	public Knjiga() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Knjiga(int id, String naziv, String autor, String zanr,boolean pozajmljena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.autor = autor;
		this.zanr = zanr;
		this.pozajmljena=pozajmljena;
	}
	
	public Knjiga( String naziv, String autor, String zanr,boolean pozajmljena) {
		super();
		this.naziv = naziv;
		this.autor = autor;
		this.zanr = zanr;
		this.pozajmljena=pozajmljena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isPozajmljena() {
		return pozajmljena;
	}
	public void setPozajmljena(boolean pozajmljena) {
		this.pozajmljena = pozajmljena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	@Override
	public String toString() {
		return "Knjiga [naziv=" + naziv + ", autor=" + autor + ", zanr=" + zanr + "]";
	}
	
	

}
