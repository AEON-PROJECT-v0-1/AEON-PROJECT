package com.aeon.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_permission")
@Getter
@Setter
public class Permission extends BaseEntity {

    private String permissionName;

    private String permissionKey;

<<<<<<< HEAD
	public String getPermissionKey() {
		// TODO Auto-generated method stub
		return permissionKey;
	}

=======
>>>>>>> db0bab5fa9bab12543c8776ae9ef20e29d15bce3
}
