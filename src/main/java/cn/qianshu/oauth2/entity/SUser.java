package cn.qianshu.oauth2.entity;

import java.util.Date;

public class SUser{

	private int id;  
    private String username;  
    private String password;
    private String name2;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
    
	@Override
	public String toString() {
		return "SUser [id=" + id + ", username=" + username + ", password=" + password + ", name2=" + name2 + ", phone="
				+ phone + ", email=" + email + ", created=" + created + ", updated=" + updated + "]";
	}
	public SUser(SUser sUser) {
		super();
		this.id = sUser.getId();
		this.username = sUser.getUsername();
		this.password = sUser.getPassword();
		this.name2 = sUser.getName2();
		this.phone = sUser.getPhone();
		this.email = sUser.getEmail();
		this.created = sUser.getCreated();
		this.updated = sUser.getUpdated();
	}
	public SUser(int id, String username, String password, String name2, String phone, String email, Date created,
			Date updated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name2 = name2;
		this.phone = phone;
		this.email = email;
		this.created = created;
		this.updated = updated;
	}
	public SUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
}
