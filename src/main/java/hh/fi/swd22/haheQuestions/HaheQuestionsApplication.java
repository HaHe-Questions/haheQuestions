package hh.fi.swd22.haheQuestions;

import java.util.List;
import java.util.Optional;

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

@SpringBootApplication
public class HaheQuestionsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HaheQuestionsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HaheQuestionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner kysymysDemo(KyselyRepository kyselyrepository, KysymysRepository kysymysrepository) {
		return (args) -> {
			log.info("Testi");
			kyselyrepository.save(new Kysely("kevätkysely"));
			
			kysymysrepository.save(new Kysymys("Mitä olet mieltä keväästä?", kyselyrepository.findByNimi("kevätkysely").get(0)));
			kysymysrepository.save(new Kysymys("Onko lämmin?", kyselyrepository.findByNimi("kevätkysely").get(0)));
			
			kyselyrepository.save(new Kysely("talvikysely"));
			
			kysymysrepository.save(new Kysymys("Onko kylmä?", kyselyrepository.findByNimi("talvikysely").get(0)));
			kysymysrepository.save(new Kysymys("Mitä olet mieltä talvesta?", kyselyrepository.findByNimi("talvikysely").get(0)));
		};
	}
}
