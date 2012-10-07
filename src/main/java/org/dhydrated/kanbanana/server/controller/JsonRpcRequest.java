package org.dhydrated.kanbanana.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.core.style.ToStringCreator;

/**
 * <Desc>
 * @author Dhydrated <dhydrated@gmail.com>
 **/
@XmlRootElement(name="jsonrpcrequest")
public class JsonRpcRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String jsonrpc = "2.0";
	private String method;
//	private ArrayList<LinkedHashMap<String, String>> params;
	private String id;
	private Object params;
	
	public Object getParams() {
		return params;
	}
	public void setParams(Object params) {
		this.params = params;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	/*public ArrayList<LinkedHashMap<String, String>> getParams() {
		return params;
	}
	public void setParams(ArrayList<LinkedHashMap<String, String>> params) {
		this.params = params;
	}*/
	public String getJsonrpc() {
		return jsonrpc;
	}

	@Override
	public String toString() {
		
		ToStringCreator tsh = new ToStringCreator(this);
		
		tsh.append("id", this.getId());
		tsh.append("method", this.getMethod());
		tsh.append("params", this.getParams());
		
		return tsh.toString();
	}
}
