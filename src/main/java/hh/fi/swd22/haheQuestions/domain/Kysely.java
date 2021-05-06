package hh.fi.swd22.haheQuestions.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kysely {
	// attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kysely_id;
	private String kysely_kuvaus;
	private String nimi;
	
	@JsonIgnoreProperties("kysely")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;

	
	// konstruktorit
	public Kysely(String nimi, String kysely_kuvaus) {
		super();
		this.nimi = nimi;
		this.kysely_kuvaus = kysely_kuvaus;
	}
	
	public Kysely(String nimi) {
		super();
		this.nimi = nimi;
	}
	
	public Kysely() {
		super();
		this.nimi = null;
		this.kysely_kuvaus = null;
	}

	// getterit ja setterit
	public Long getKysely_id() {
		return kysely_id;
	}

	public void setKysely_id(Long kysely_id) {
		this.kysely_id = kysely_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	public String getKysely_kuvaus() {
		return kysely_kuvaus;
	}

	public void setKysely_kuvaus(String kysely_kuvaus) {
		this.kysely_kuvaus = kysely_kuvaus;
	}

	// toString
	@Override
	public String toString() {
		return "Kysely [kysely_id=" + kysely_id + ", kysely_kuvaus=" + kysely_kuvaus + ", nimi=" + nimi
				+ ", kysymykset=" + kysymykset + "]";
	}
	
}
