package com.nilesh.demos.loaneligibility.endpoint;

import org.nilesh.loaneligibility.LoanRequest;
import org.nilesh.loaneligibility.LoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nilesh.demos.loaneligibility.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {

	@Autowired
	public LoanEligibilityService service;
	
	private static final String NAME_SPACE="http://www.nilesh.org/loanEligibility";

	@PayloadRoot(namespace=NAME_SPACE,localPart="LoanRequest")
	@ResponsePayload
	public LoanResponse getLoanEligibility(@RequestPayload LoanRequest request) {
		return service.checkLoanEligibility(request);
	}

}
