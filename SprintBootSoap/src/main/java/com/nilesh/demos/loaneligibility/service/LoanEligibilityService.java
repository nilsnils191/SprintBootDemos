package com.nilesh.demos.loaneligibility.service;

import java.util.ArrayList;
import java.util.List;

import org.nilesh.loaneligibility.LoanRequest;
import org.nilesh.loaneligibility.LoanResponse;
import org.nilesh.loaneligibility.LoanResponseComplex;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {

	public LoanResponse checkLoanEligibility(LoanRequest request) {
		LoanResponse response = new LoanResponse();
		LoanResponseComplex loanResponseComplex = new LoanResponseComplex();
		List<String> mismatchCriteriaList = loanResponseComplex.getCriteriaMismatch();

		if (!(request.getLoanRequestData().getAge() > 30 && request.getLoanRequestData().getAge() <= 60)) {
			mismatchCriteriaList.add("Person age should in between 30 to 60");
		}
		if (!(request.getLoanRequestData().getSalary() > 20000)) {
			mismatchCriteriaList.add("minimum salary should be more than 20000");
		}
		if (!(request.getLoanRequestData().getCibil() > 500)) {
			mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
		}

		

		if (mismatchCriteriaList.size() > 0) {
			loanResponseComplex.setApprovedAmount(0);
			loanResponseComplex.setIsEligible(false);
		} else {
			loanResponseComplex.setApprovedAmount(500000);
			loanResponseComplex.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		response.setLoanResponseData(loanResponseComplex);
		return response;

	}

}
