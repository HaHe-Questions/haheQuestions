package hh.fi.swd22.haheQuestions.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {
	
	public List<Kysymys> findByKysely(Kysely kysely);
	
	List<Kysymys> findByKysymysteksti(String kysymysteksti);
}
