package hh.fi.swd22.haheQuestions.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.swd22.haheQuestions.domain.Kysely;
import hh.fi.swd22.haheQuestions.domain.KyselyRepository;
import hh.fi.swd22.haheQuestions.domain.Kysymys;
import hh.fi.swd22.haheQuestions.domain.KysymysRepository;

// vr. Kyselyä Studenttiin ja Kysymystä Departmenttiin

@CrossOrigin
@Controller
public class KyselyController {
	@Autowired
	private KyselyRepository kyselyrepository;
	
	@Autowired
	private KysymysRepository kysymysrepository;
	
	@RequestMapping(value="/kyselylista")
	public String kyselyLista(Model model) {
		model.addAttribute("kyselyt", kyselyrepository.findAll());
		// model.addAttribute("kysymykset", kysymysrepository.findAll());
		return "kysely";
	}
	
	// Rest palvelu, joka palauttaa kaikki kyselyt
	@RequestMapping(value="/kyselyt", method= RequestMethod.GET)
	public @ResponseBody List<Kysely> getKyselytRest() {
		return (List<Kysely>) kyselyrepository.findAll();
	}
	
	// Rest palvelu, joka palauttaa yhden kyselyn id:n perusteella
    @RequestMapping(value="/kysely/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long kId) {	
    	return kyselyrepository.findById(kId);
    } 
	
	// Lisää uusi kysely
	@RequestMapping(value="/uusikysely")
	public String uusiKysely(Model model) {
		model.addAttribute("kysely", new Kysely());
		return "uusikysely";
	}
	
	// Lisää uusi kysymys
	@RequestMapping(value="/uusikysymys")
	public String uusiKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kyselyt", kyselyrepository.findAll());
		return "uusikysymys";
	}
	
	// Tallenna uusi kysely
	@RequestMapping(value="/tallennakysely", method = RequestMethod.POST)
	public String tallennaKysely(Kysely kysely) {
		kyselyrepository.save(kysely);
		return "redirect:kyselylista";
	}
	
	// Tallenna uusi kysymys
	@RequestMapping(value="/tallennakysymys", method = RequestMethod.POST)
	public String tallennaKysymys(Kysymys kysymys) {
		kysymysrepository.save(kysymys);
		return "redirect:kyselylista";
	}
	

}
