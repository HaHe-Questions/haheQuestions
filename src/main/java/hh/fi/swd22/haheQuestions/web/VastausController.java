package hh.fi.swd22.haheQuestions.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.swd22.haheQuestions.domain.Kysymys;
import hh.fi.swd22.haheQuestions.domain.Vastaus;
import hh.fi.swd22.haheQuestions.domain.VastausRepository;

@CrossOrigin
@Controller
public class VastausController {
	@Autowired
	private VastausRepository vastausrepository;

	// Rest metodi kaikkien vastausten hakemiseksi
	@RequestMapping(value = "/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> getVastauksetRest() {
		return (List<Vastaus>) vastausrepository.findAll();
	}

	// Rest metodi yhden kysymyksen vastauksille
	@RequestMapping(value = "/kysymys/{id}/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> getKysymyksenVastauksetRest(@PathVariable("id") Long kId) {
		Kysymys kysymys = new Kysymys();
		kysymys.setKysymys_id(kId);
		return (List<Vastaus>) vastausrepository.findByKysymys(kysymys);
	}
	
	// Rest metodi - tallenna uusi vastaus
	@RequestMapping(value="/tallennavastaus", method = RequestMethod.POST)
	public @ResponseBody Vastaus tallennaVastaus(@RequestBody Vastaus vastaus) {
		vastausrepository.save(vastaus);
		return vastaus;
	}
	
	// Rest metodi - tallenna monta uutta vastausta
	@RequestMapping(value="/tallennavastaukset", method = RequestMethod.POST)
	public @ResponseBody List<Vastaus> tallennaVastaukset(@RequestBody List<Vastaus> vastaukset) {
		vastausrepository.saveAll(vastaukset);
		return vastaukset;
	}

}
