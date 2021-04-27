package hh.fi.swd22.haheQuestions.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.swd22.haheQuestions.domain.Kysely;
import hh.fi.swd22.haheQuestions.domain.Kysymys;
import hh.fi.swd22.haheQuestions.domain.KysymysRepository;

@CrossOrigin
@Controller
public class KysymysController {
	@Autowired
	private KysymysRepository kysymysrepository;
	
	@ResponseBody
	@RequestMapping("/index")
	public String hello() {
		return "testitesti";
	}
	// Rest metodi kaikkien kysymysten hakemiseksi
	@RequestMapping(value="/kysymykset", method= RequestMethod.GET)
	public @ResponseBody List<Kysymys> getKysymyksetRest() {
		return (List<Kysymys>) kysymysrepository.findAll();
	}
	
	// Rest metodi yhdelle kyselylle
	@RequestMapping(value="/kysely/{id}/kysymykset", method= RequestMethod.GET)
	public @ResponseBody List<Kysymys> getKysyelynKysymyksetRest(@PathVariable("id") Long kId) {
		Kysely kysely = new Kysely();
		// kyselyoliolle asetetaan pathvariablena tullut kyselyid
		kysely.setKysely_id(kId);
		return (List<Kysymys>) kysymysrepository.findByKysely(kysely);
	}
}
