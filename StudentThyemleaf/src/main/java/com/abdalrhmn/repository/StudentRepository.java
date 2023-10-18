
package com.abdalrhmn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/*Abdalrhmn Refaie 2023*/
import com.abdalrhmn.entity.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("update Student s set s.result =:status where id =:id")
	@Modifying
	void updateResultStatus(long id, boolean status);

	List<Student> findByNameContainingIgnoreCase(String keyword);

}
