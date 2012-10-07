package org.dhydrated.kanbanana.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonRpcServiceImpl {

	@RequestMapping(method=RequestMethod.POST, value="/jsonrpc", produces="application/json")
	public @ResponseBody JsonRpcResponse process(@RequestBody JsonRpcRequest request, HttpServletRequest req) {

		return new JsonRpcResponse();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/test", produces="application/json")
	public @ResponseBody JsonRpcResponse process() {

		return new JsonRpcResponse();
	}
}
