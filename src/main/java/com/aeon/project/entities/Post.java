package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_post")
@Getter
@Setter
public class Post extends BaseEntity {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5009727874055951336L;

	private String postNo;

    private String cityName;
    
    private String addressName;
    
    private String streetName;
	
}
