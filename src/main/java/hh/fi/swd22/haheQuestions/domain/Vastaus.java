package hh.fi.swd22.haheQuestions.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Vastaus {
	// attribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vastaus_id;
	
	private String vastausteksti;
	@ManyToOne
	@JsonIgnoreProperties("vastaukset")
	@JoinColumn(name = "kysymys_id")
	private Kysymys kysymys;
	
	// konstruktorit
	public Vastaus(String vastausteksti, Kysymys kysymys) {
		super();
		this.vastausteksti = vastausteksti;
		this.kysymys = kysymys;
	}
	public Vastaus() {
		super();
		this.vastausteksti = null;
		this.kysymys = null;
	}
	
	// getterit ja setterit
	
	public Long getVastaus_id() {
		return vastaus_id;
	}
	public void setVastaus_id(Long vastaus_id) {
		this.vastaus_id = vastaus_id;
	}
	public String getVastausteksti() {
		return vastausteksti;
	}
	public void setVastausteksti(String vastausteksti) {
		this.vastausteksti = vastausteksti;
	}
	public Kysymys getKysymys() {
		return kysymys;
	}
	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Vastaus [vastaus_id=" + vastaus_id + ", vastausteksti=" + vastausteksti + ", kysymys=" + kysymys + "]";
	}	

}
