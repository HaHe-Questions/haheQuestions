package hh.fi.swd22.haheQuestions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.fi.swd22.haheQuestions.domain.Kysely;
import hh.fi.swd22.haheQuestions.domain.KyselyRepository;
import hh.fi.swd22.haheQuestions.domain.Kysymys;
import hh.fi.swd22.haheQuestions.domain.KysymysRepository;
import hh.fi.swd22.haheQuestions.domain.Vastaus;
import hh.fi.swd22.haheQuestions.domain.VastausRepository;

@SpringBootApplication
public class HaheQuestionsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HaheQuestionsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HaheQuestionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner kysymysDemo(KyselyRepository kyselyrepository, KysymysRepository kysymysrepository, VastausRepository
			vastausrepository) {
		return (args) -> {
			log.info("Testi");
			kyselyrepository.save(new Kysely("kevätkysely"));
			
			kysymysrepository.save(new Kysymys("Mitä olet mieltä keväästä?", kyselyrepository.findByNimi("kevätkysely").get(0)));
			kysymysrepository.save(new Kysymys("Onko lämmin?", kyselyrepository.findByNimi("kevätkysely").get(0)));
			
			kyselyrepository.save(new Kysely("talvikysely"));
			
			kysymysrepository.save(new Kysymys("Onko kylmä?", kyselyrepository.findByNimi("talvikysely").get(0)));
			kysymysrepository.save(new Kysymys("Mitä olet mieltä talvesta?", kyselyrepository.findByNimi("talvikysely").get(0)));
			
			vastausrepository.save(new Vastaus("Kevät on kiva.", kysymysrepository.findByKysymysteksti("Mitä olet mieltä keväästä?").get(0)));
			vastausrepository.save(new Vastaus("Ei ole kylmä.", kysymysrepository.findByKysymysteksti("Onko kylmä?").get(0)));
			
			vastausrepository.save(new Vastaus("Kesä on parempi.", kysymysrepository.findByKysymysteksti("Mitä olet mieltä keväästä?").get(0)));
			vastausrepository.save(new Vastaus("On kylmä.", kysymysrepository.findByKysymysteksti("Onko kylmä?").get(0)));
			
			kyselyrepository.save(new Kysely("mielipidekysely etäopiskelemisesta"));
			
			kysymysrepository.save(new Kysymys("Koetko etäopiskelun helppona?", kyselyrepository.findByNimi("mielipidekysely etäopiskelemisesta").get(0)));
			kysymysrepository.save(new Kysymys("Minkä koet olevan suurin haaste etäopiskelemisessa?", kyselyrepository.findByNimi("mielipidekysely etäopiskelemisesta").get(0)));
			kysymysrepository.save(new Kysymys("Oletko tyytyväinen koulun tarjoamaan etäopetuksen laatuun?", kyselyrepository.findByNimi("mielipidekysely etäopiskelemisesta").get(0)));
			kysymysrepository.save(new Kysymys("Haluaisitko jatkaa etäopiskelemisesta vielä jatkossakin?", kyselyrepository.findByNimi("mielipidekysely etäopiskelemisesta").get(0)));
			
			vastausrepository.save(new Vastaus("En koe etäopiskelua helppona.", kysymysrepository.findByKysymysteksti("Koetko etäopiskelun helppona?").get(0)));
			vastausrepository.save(new Vastaus("Koen etäopiskelun helpoksi.", kysymysrepository.findByKysymysteksti("Koetko etäopiskelun helppona?").get(0)));
			
			vastausrepository.save(new Vastaus("Koen suurimmaksi haasteeksi etäopiskelussa motivaation puutteen", kysymysrepository.findByKysymysteksti("Minkä koet olevan suurin haaste etäopiskelemisessa?").get(0)));
			vastausrepository.save(new Vastaus("Koen suurimmaksi haasteeksi etäopiskelussa kontaktien vähäisyyden", kysymysrepository.findByKysymysteksti("Minkä koet olevan suurin haaste etäopiskelemisessa?").get(0)));
			vastausrepository.save(new Vastaus("Koen suurimmaksi haasteeksi etäopiskelussa vertaistuen puutteen", kysymysrepository.findByKysymysteksti("Minkä koet olevan suurin haaste etäopiskelemisessa?").get(0)));
			
			vastausrepository.save(new Vastaus("Olen tyytyväinen koulun tarjoamaan etäopetuksen laatuun", kysymysrepository.findByKysymysteksti("Oletko tyytyväinen koulun tarjoamaan etäopetuksen laatuun?").get(0)));
			vastausrepository.save(new Vastaus("Olen erittäin tyytyväinen koulun tarjoamaan etäopetuksen laatuun", kysymysrepository.findByKysymysteksti("Oletko tyytyväinen koulun tarjoamaan etäopetuksen laatuun?").get(0)));
			vastausrepository.save(new Vastaus("Koulun tarjoama etäopetus voisi olla laadukkaampaakin", kysymysrepository.findByKysymysteksti("Oletko tyytyväinen koulun tarjoamaan etäopetuksen laatuun?").get(0)));
			
			vastausrepository.save(new Vastaus("En haluaisi jatkaa etäopiskelua jatkossa", kysymysrepository.findByKysymysteksti("Haluaisitko jatkaa etäopiskelemisesta vielä jatkossakin?").get(0)));
			vastausrepository.save(new Vastaus("Haluaisin jatkaa etäopiskelua jatkossa", kysymysrepository.findByKysymysteksti("Haluaisitko jatkaa etäopiskelemisesta vielä jatkossakin?").get(0)));
			vastausrepository.save(new Vastaus("Voisin ottaa yksittäisiä etäopintokursseja jatkossakin", kysymysrepository.findByKysymysteksti("Haluaisitko jatkaa etäopiskelemisesta vielä jatkossakin?").get(0)));
			
		};
	}
}
