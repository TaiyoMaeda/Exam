package jp.ac.C.ohara.teamseisaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.C.ohara.teamseisaku.model.StudentModel;
import jp.ac.C.ohara.teamseisaku.repository.StudentRepository;

 

@Service
@Transactional
public class  StudentService{

    @Autowired
    private StudentRepository repository;

    /**
     * 学生一覧の取得
     * @return List<Student>
     */
    public List<StudentModel> getStudentList() {
        List<StudentModel> entityList = this.repository.findAll();
        return entityList;
    }

    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public StudentModel get(@NonNull Long index) {
        StudentModel studentmodel = this.repository.findById(index).orElse(new StudentModel());
        return studentmodel;
    }

    public void save(StudentModel studentmodel) {
        this.repository.save(studentmodel);
    }

    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }

  //学生データの削除・編集

        public List<StudentModel> getStudentList1() {
            return repository.findAll();
        }

        public StudentModel getStudentById(Long id) {
            return repository.findById(id).orElse(null);
        }

        public void saveOrUpdateStudent(StudentModel student) {
            repository.save(student);
        }

        public void deleteStudent(Long id) {
            repository.deleteById(id);
        }

}