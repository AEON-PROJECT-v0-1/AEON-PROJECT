package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tcategory_system")
@Getter
@Setter
public class CategoryProduct {
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PROGRAM_ID;
    private String PROGRAM_NAME;
    private String INSERT_ID;
    private Date INSERT_DATE;
    private String MODIFY_ID;
    private Date MODIFY_DATE;
}
