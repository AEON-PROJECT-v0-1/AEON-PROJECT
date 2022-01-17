package com.aeon.project.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tnews")
@Getter
@Setter

public class News extends BaseEntity {
	
	private String newsNo;
	
	private String newsName;
	
	private String typeNews;
	

}
