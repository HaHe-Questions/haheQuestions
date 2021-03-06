package hh.fi.swd22.haheQuestions.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	
	public List<Vastaus> findByKysymys(Kysymys kysymys);

}
