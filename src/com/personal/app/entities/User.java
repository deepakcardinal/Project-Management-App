package com.personal.app.entities;

/**
 * This Class Models the User Entity.
 * Which will be used for storing user data 
 * @author Deepak Dogra
 */
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * @author Deepak Dogra
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 3025649200475443291L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * User name will be the email of the User
	 */
	@Column(name = "username", length = 50, unique = true)
	private String userName;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	

	@Column(name = "last_login")
	private Date lastLogin;
	
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	@Column(name = "enabled")
	private Boolean enabled = Boolean.FALSE;

	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "created_by", length = 50, nullable = false)
	private String createdBy;
	
	@Column(name = "updated_by", length = 50)
	private String updatedBy;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@org.hibernate.annotations.Cascade( { org.hibernate.annotations.CascadeType.ALL,
			org.hibernate.annotations.CascadeType.DETACH })			
	private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>(0);
	

	

	@Transient
    private Boolean isAdmin=Boolean.FALSE;

    @Transient
    private Boolean isUser=Boolean.FALSE;

    @Transient
    private Boolean isSuperUser=Boolean.FALSE;
    
    @Transient
    private Boolean isAnonymousUser=Boolean.FALSE;
 
	public Set<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	/**
	 * @param userAuthorities the userAuthorities to set
	 */
	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	
	public Boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the isUser
	 */
	public Boolean isUser() {
		return isUser;
	}

	/**
	 * @param isUser the isUser to set
	 */
	public void setUser(Boolean isUser) {
		this.isUser = isUser;
	}

	/**
	 * @return the isSuperUser
	 */
	public Boolean isSuperUser() {
		return isSuperUser;
	}

	/**
	 * @param isSuperUser the isSuperUser to set
	 */
	public void setSuperUser(Boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	
	public Boolean isAnonymousUser() {
		return isAnonymousUser;
	}

	public void setAnonymousUser(Boolean isAnonymousUser) {
		this.isAnonymousUser = isAnonymousUser;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
}
