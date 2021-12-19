package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_token")
@Getter
@Setter
public class Token extends BaseEntity {
    @Column(length = 1000)
    private String token;

    private Date tokenExpDate;
    
    private Long createdBy;
    
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenExpDate() {
		return tokenExpDate;
	}

	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
    
}
