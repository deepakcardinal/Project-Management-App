package com.personal.app.entities;

/**
 * This Class Models the UserAuthority Entity.
 * Which will be used for assigning roles to user (used in Spring)
 * @author Deepak Dogra
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class UserAuthority implements Serializable{

	private static final long serialVersionUID = 842916714893080812L;
	
	@Id
	private UserAuthorityPk id = new UserAuthorityPk();

	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
	private User user;

	public void setAuthority(String authority) {
		id.setAuthority(authority);
	}

	public String getAuthority() {
		return id.getAuthority();
	}

	/**
	 * @return the securityUser
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param securityUser
	 *            the securityUser to set
	 */
	public void setUser(User user) {
		this.user = user;
		id.setUserName(user.getUserName());
	}

	/**
	 * @return the id
	 */
	public UserAuthorityPk getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UserAuthorityPk id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuthority other = (UserAuthority) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Embeddable
	public static class UserAuthorityPk implements Serializable {
		private static final long serialVersionUID = 9084890503786022145L;

		@Column(name = "username")
		private String userName;

		private String authority;

		public UserAuthorityPk() {
		}

		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName
		 *            the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * @return the authority
		 */
		public String getAuthority() {
			return authority;
		}

		/**
		 * @param authority
		 *            the authority to set
		 */
		public void setAuthority(String authority) {
			this.authority = authority;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			result = prime * result
					+ ((authority == null) ? 0 : authority.hashCode());
			result = prime * result
					+ ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof UserAuthorityPk))
				return false;
			UserAuthorityPk other = (UserAuthorityPk) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (authority == null) {
				if (other.authority != null)
					return false;
			} else if (!authority.equals(other.authority))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		private Object getOuterType() {
			return new Object();
		}

		

	}

}
