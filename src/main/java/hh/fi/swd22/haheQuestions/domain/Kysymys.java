package hh.fi.swd22.haheQuestions.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Kysymys {
	// attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kysymys_id;
	
	private String kysymysteksti;

	// konstruktorit
	public Kysymys() {
		super();
		this.kysymysteksti = null;
	}
	
	public Kysymys(String kysymysteksti) {
		super();
		this.kysymysteksti = kysymysteksti;
	}
	// getterit ja setterit
	public String getKysymysteksti() {
		return kysymysteksti;
	}

	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}
	
	public Long getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(Long kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	
	// toString
	@Override
	public String toString() {
		return "Kysymys [kysymys_id=" + kysymys_id + ", kysymysteksti=" + kysymysteksti + "]";
	}
	
	
}
