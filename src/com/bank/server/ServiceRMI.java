package com.bank.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.CommonDAO;
import com.bank.interfaces.DataInterface;
import com.bank.logic.Account;
import com.bank.logic.Agency;
import com.bank.logic.Customer;
import com.bank.logic.Operation;


@SuppressWarnings("serial")
public class ServiceRMI extends UnicastRemoteObject implements DataInterface{
	
	// Database Operations Helper
	private CommonDAO cdao;
	
	public ServiceRMI() throws RemoteException{
		this.cdao = new CommonDAO();
	}
	
	/* These four methods are called when creation is required*/
	/**
	 * Call this method when created Agency is needed
	 * @param agency
	 */
	@Override
	public void createAgency(Agency agency){
		
		System.out.println(cdao.insert(agency, "Agency"));
	}
	
	/**
	 * Call this method when created Customer is needed
	 * @param customer
	 */
	@Override
	public void createCustomer(Customer customer){
		cdao.insert(customer, "Customer");
	}
	
	/**
	 * Call this method when created Account is needed
	 * @param account
	 */
	@Override
	public void createAccount(Account account){
		cdao.insert(account, "Account");
	}
	
	/**
	 * Call this method when created Operation is needed
	 * @param operation
	 */
	@Override
	public void createOperation(Operation operation){
		cdao.insert(operation, "Operation");
	}
	
	/* These methods are called when select is required*/
	@Override
	public ArrayList <Agency> getAgencies(){
		return cdao.select(Agency.class, "Agency", null);
	}
	
	@Override
	public ArrayList <Customer> getCustomers(){
		return cdao.select(Customer.class, "Customer", null);
	}
	
	@Override
	public ArrayList <Account> getAccounts(){
		return cdao.select(Account.class, "Account", null);
	}
	
	@Override
	public ArrayList <Operation> getOperations(){
		return cdao.select(Operation.class, "Operation", null);
	}

	@Override
	public ArrayList <Customer> getCustomersByAgency(String agencyName){
		return cdao.select(Customer.class, "Customer", "agName = '" + agencyName + "'");
	}

	@Override
	public ArrayList <Account> getAccountsByCustomer(String customerID){
		return cdao.select(Account.class, "Account", "cusID = '" + customerID + "'");
	}


	/* These four methods are called when delete is required*/
	@Override
	public int deleteAccount(Account account, String clause) {
		return cdao.delete(account, "Account", clause);
	}
	
	@Override
	public int deleteOperation(Operation operation, String clause) {
		return cdao.delete(operation, "Operation", clause);
	}
	
	@Override
	public int deleteAgency(Agency agency, String clause) {
		return cdao.delete(agency, "Agency", clause);
	}
	
	@Override
	public int deleteCustomer(Customer customer, String clause) {
		return cdao.delete(customer, "Customer", clause);
	}
	
	/* These four methods are called when update is required*/
	@Override
	public int updateAccount(Account account, String clause) {
		return cdao.update(account, "Account", clause);
	}
	
	@Override
	public int updateOperation(Operation operation, String clause) {
		return cdao.update(operation, "Operation", clause);
	}
	
	@Override
	public int updateAgency(Agency agency, String clause) {
		return cdao.update(agency, "Agency", clause);
	}
	
	@Override
	public int updateCustomer(Customer customer, String clause) {
		return cdao.update(customer, "Customer", clause);
	}

	@Override
	public List<Operation> getOperationsByAccount(String accountID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountStat(String temp) {
		// TODO Auto-generated method stub
		return null;
	}
}
