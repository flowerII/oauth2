package cn.qianshu.oauth2.entity;

import java.io.Serializable;
import java.util.Date;

public class SPermission implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO 
	*/
	private static final long serialVersionUID = 1L;
	private int id;
	private int parent_id;
	private String name;
	private String enname;
	private String url;
	private String description;
	private Date created;
	private Date updated;
	
	@Override
	public String toString() {
		return "SPermission [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", enname=" + enname + ", url="
				+ url + ", description=" + description + ", created=" + created + ", updated=" + updated + "]";
	}
	public SPermission(int id, int parent_id, String name, String enname, String url, String description, Date created,
			Date updated) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.enname = enname;
		this.url = url;
		this.description = description;
		this.created = created;
		this.updated = updated;
	}
	public SPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnname() {
		return enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
