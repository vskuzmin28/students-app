package com.students.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.students.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from student s \n"
            		+ "join gruppa gr on gr.id = s.gruppa_id\n"
            		+ "join specializacia sp on sp.specializacia_id = gr.specializacia_id\n"
            		+ "join kafedra kaf on gr.kafedra_id = kaf.kafedra_id\n"
            		+ "join facultet fac on fac.facultet_id = kaf.facultet_id\n"
            		+ "join vuz v on v.vuz_id = fac.vuz_id\n"
            		+ "where ((v.vuz_id=?1 or ?1=0) and (fac.facultet_id=?2 or ?2=0)\n"
            		+ "	   and(kaf.kafedra_id=?3 or ?3=0 )and(gr.id=?4 or ?4=0)\n"
            		+ "	   and(sp.specializacia_id=?5 or ?5=0)) ",
            		countQuery = "select * from student s \n"
                    		+ "join gruppa gr on gr.id = s.gruppa_id\n"
                    		+ "join specializacia sp on sp.specializacia_id = gr.specializacia_id\n"
                    		+ "join kafedra kaf on gr.kafedra_id = kaf.kafedra_id\n"
                    		+ "join facultet fac on fac.facultet_id = kaf.facultet_id\n"
                    		+ "join vuz v on v.vuz_id = fac.vuz_id\n"
                    		+ "where ((v.vuz_id=?1 or ?1=0) and (fac.facultet_id=?2 or ?2=0)\n"
                    		+ "	   and(kaf.kafedra_id=?3 or ?3=0 )and(gr.id=?4 or ?4=0)\n"
                    		+ "	   and(sp.specializacia_id=?5 or ?5=0)) "
    )
    List<Student> findAllFiltered(long vuzId, long facultetId,
			long kafedraId, long gruppaId, long specializaciaId);

}
