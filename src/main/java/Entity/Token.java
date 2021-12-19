package Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_token")
@Getter
@Setter
public class Token extends BaseEntity {
	  @Column(length = 1000)
	    private String token;

	    private Date tokenExpDate;

	    private Long CreatedBy;
	    
		public Date getTokenExpDate() {
			return tokenExpDate;
		}

		public void setTokenExpDate(Date tokenExpDate) {
			this.tokenExpDate = tokenExpDate;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Long getCreatedBy() {
			return CreatedBy;
		}

		public void setCreatedBy(Long createdBy) {
			CreatedBy = createdBy;
		}

		
	    
	    
}
