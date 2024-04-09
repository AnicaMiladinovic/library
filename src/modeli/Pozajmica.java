package modeli;

import java.util.Date;

public class Pozajmica {
	
	private int id_pozajmice;
	private int id_knjige;
	private int id_korisnika;
	private Date datum_iznamljivanja;
	private Date datum_vracanja;
	public int getId_pozajmice() {
		return id_pozajmice;
	}
	public void setId_pozajmice(int id_pozajmice) {
		this.id_pozajmice = id_pozajmice;
	}
	public int getId_knjige() {
		return id_knjige;
	}
	public void setId_knjige(int id_knjige) {
		this.id_knjige = id_knjige;
	}
	public int getId_korisnika() {
		return id_korisnika;
	}
	public void setId_korisnika(int id_korisnika) {
		this.id_korisnika = id_korisnika;
	}
	public Date getDatum_iznamljivanja() {
		return datum_iznamljivanja;
	}
	public void setDatum_iznamljivanja(Date datum_iznamljivanja) {
		this.datum_iznamljivanja = datum_iznamljivanja;
	}
	public Date getDatum_vracanja() {
		return datum_vracanja;
	}
	public void setDatum_vracanja(Date datum_vracanja) {
		this.datum_vracanja = datum_vracanja;
	}
	public Pozajmica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pozajmica(int id_pozajmice, int id_knjige, int id_korisnika, Date datum_iznamljivanja, Date datum_vracanja) {
		super();
		this.id_pozajmice = id_pozajmice;
		this.id_knjige = id_knjige;
		this.id_korisnika = id_korisnika;
		this.datum_iznamljivanja = datum_iznamljivanja;
		this.datum_vracanja = datum_vracanja;
	}
	public Pozajmica(int id_knjige, int id_korisnika, Date datum_iznamljivanja, Date datum_vracanja) {
		super();
		this.id_knjige = id_knjige;
		this.id_korisnika = id_korisnika;
		this.datum_iznamljivanja = datum_iznamljivanja;
		this.datum_vracanja = datum_vracanja;
	}
	@Override
	public String toString() {
		return "Pozajmica [id_pozajmice=" + id_pozajmice + ", id_knjige=" + id_knjige + ", id_korisnika=" + id_korisnika
				+ ", datum_iznamljivanja=" + datum_iznamljivanja + ", datum_vracanja=" + datum_vracanja + "]";
	}
	
	

}
