package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tproduct")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String PRODUCT_NO;
    private String PRODUCT_NAME;
    private String CATE_LGROUP_CODE;
    private String CATE_MGROUP_CODE;
    private String CATE_SGROUP_CODE;
    private Date START_DATE;
    private Date END_DATE;
    private int SALE_PRICE;
    private Date INSERT_DATE;
    private String INSERT_ID;
    private Date MODIFY_DATE;
    private String MODIFY_ID;



}
