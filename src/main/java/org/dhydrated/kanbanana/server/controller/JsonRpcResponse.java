package org.dhydrated.kanbanana.server.controller;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <Desc>
 * @author Dhydrated <dhydrated@gmail.com>
 **/
@XmlRootElement(name="jsonrpcresponse")
public class JsonRpcResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String jsonrpc = "2.0";
	private String id;
	private Object result;
	private Object error;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public String getJsonrpc() {
		return jsonrpc;
	}
	
	
	
}
