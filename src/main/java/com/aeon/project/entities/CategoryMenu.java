package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tcategorykindsmapping")
@Getter
@Setter
public class CategoryMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CATE_LGROUP_CODE;
    private String CATE_MGROUP_CODE;
    private String CATE_SGROUP_CODE;
    private String CATE_LGROUP_NAME;
    private String CATE_MGROUP_NAME;
    private String CATE_SGROUP_NAME;

    private Date INSERT_DATE;
    private String INSERT_ID;
    private Date MODIFY_DATE;
    private String MODIFY_ID;

}
