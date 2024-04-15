package jp.ac.C.ohara.teamseisaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.C.ohara.teamseisaku.model.StudentModel;

@Repository
public interface StudentRepository  extends JpaRepository<StudentModel, Long>{

}