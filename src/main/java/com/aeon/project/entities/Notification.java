package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_notification")
@Getter
@Setter
public class Notification extends BaseEntity {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7612345950286989909L;

	private String custNo;

    private String notificationNo;
    
    private String notificationName;
    
    private String notificationNote;
    
    private String seenYn;
	
}
