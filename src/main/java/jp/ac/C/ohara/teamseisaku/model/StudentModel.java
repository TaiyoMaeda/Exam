package jp.ac.C.ohara.teamseisaku.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    
    @Column(name="st_id",length = 10, nullable = false)
    private String stId;
    
    @Column(name="name",length = 10, nullable = true)
    private String name;

    @Column(name="nyu_year",length = 10, nullable = true)
    private Integer nyuYear;

    @Column(name="class_id",length = 3, nullable = true)
    private String classId;

    @Column(name="zaigaku",nullable = true)
    private Boolean zaigaku;
    
    @Column(name="zai_co",length = 3, nullable = true)
    private String zaiCo;

}