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
			kyselyrepository.save(new Kysely("testi"));
			
			// kysymysrepository.save(new Kysymys("kysymysteksti", kyselyrepository.findByNimi("testi").get(0)));
		};
	}
}
