package controller;

import webserviceclient.LoanBrokerWS_Service;
import webserviceclient.LoanRequest;
import webserviceclient.LoanResponse;

/**
 *
 * @author mhck
 */
public class LoanBrokerGateway {

    private LoanBrokerWS_Service service;

    public LoanBrokerGateway() {
        service = new LoanBrokerWS_Service();
    }

    public LoanResponse getLoanResponse(double loanAmount, String ssn, int loanDuration) {
        LoanRequest request = new LoanRequest();
        request.setLoanAmount(loanAmount);
        request.setSsn(ssn);
        request.setLoanDuration(loanDuration);

        LoanResponse response = service.getLoanBrokerWSPort().getLoanRequest(request);

        System.out.println("BankName: " + response.getBankName());
        System.out.println("InterestRate: " + response.getInterrestRate());
        System.out.println("SSN: " + response.getSsn());
        
        return response;
    }
}