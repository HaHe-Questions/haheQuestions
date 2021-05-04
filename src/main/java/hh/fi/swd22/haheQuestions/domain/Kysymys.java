package hh.fi.swd22.haheQuestions.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Kysymys {
	// attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kysymys_id;
	
	private String kysymysteksti;
	@ManyToOne
	@JsonIgnoreProperties("kysymykset")
	@JoinColumn(name = "kysely_id")
	private Kysely kysely;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	// konstruktorit
	public Kysymys() {
		super();
		this.kysymysteksti = null;
	}
	
	public Kysymys(String kysymysteksti, Kysely kysely) {
		super();
		this.kysymysteksti = kysymysteksti;
		this.kysely = kysely;
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
	
	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	// toString
	@Override
	public String toString() {
		return "Kysymys [kysymys_id=" + kysymys_id + ", kysymysteksti=" + kysymysteksti + "]";
	}
	
	
}
