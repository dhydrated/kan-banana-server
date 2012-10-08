package org.dhydrated.kanbanana.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.datanucleus.jpa.annotations.Extension;

@SuppressWarnings("serial")
@Entity
@MappedSuperclass
public class BaseModel implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
