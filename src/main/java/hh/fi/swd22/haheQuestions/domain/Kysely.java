package hh.fi.swd22.haheQuestions.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysely {
	// attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kysely_id;
	
	private String nimi;

	// konstruktorit
	public Kysely(String nimi) {
		super();
		this.nimi = nimi;
	}
	
	public Kysely() {
		super();
		this.nimi = null;
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

	// toString
	@Override
	public String toString() {
		return "Kysely [kysely_id=" + kysely_id + ", nimi=" + nimi + "]";
	}

}
