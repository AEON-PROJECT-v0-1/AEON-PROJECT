package com.aeon.project.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tnews_info")
@Getter
@Setter

public class NewsInfo extends BaseEntity {
	
	private String newsNo;
	
	private String newsInfo;
	

	

}
