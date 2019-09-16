package com.seventeam.gsf.repository;

import com.seventeam.gsf.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoDao extends JpaRepository<Medico, Integer> {
	
	public List<Medico> getMedicoByCrm(String crm);
	
}



/*SAMPLES

//https://www.baeldung.com/spring-data-jpa-query

    @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
	Foo retrieveByName(@Param("name") String name);

	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers(Sort sort);
 */
	