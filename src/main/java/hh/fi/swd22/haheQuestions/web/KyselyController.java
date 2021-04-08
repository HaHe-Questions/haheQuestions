package hh.fi.swd22.haheQuestions.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.swd22.haheQuestions.domain.Kysely;
import hh.fi.swd22.haheQuestions.domain.KyselyRepository;
import hh.fi.swd22.haheQuestions.domain.KysymysRepository;

// vr. Kyselyä Studenttiin ja Kysymystä Departmenttiin

@Controller
public class KyselyController {
	@Autowired
	private KyselyRepository kyselyrepository;
	
	@Autowired
	private KysymysRepository kysymysrepository;
	
	@RequestMapping(value="/kyselyt", method= RequestMethod.GET)
	public @ResponseBody List<Kysely> getKyselytRest() {
		return (List<Kysely>) kyselyrepository.findAll();
	}

}
