package com.jacaranda.security.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836716317920536349L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<UserRole> roles;
	
	@CreatedDate
	private LocalDateTime createTime;
	
	//Preguntar a Jose
	@UpdateTimestamp
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
	}
	@Override
	public String getPassword() {
		
		return this.password;
	}
	@Override
	public String getUsername() {
		
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return deleteTime == null;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return false;
	}
	@Override
	public boolean isEnabled() {
		
		return false;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
