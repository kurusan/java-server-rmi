package com.bank.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.bank.logic.Account;
import com.bank.logic.Agency;
import com.bank.logic.Customer;
import com.bank.logic.Operation;


public interface DataInterface extends Remote{
	
	/* These four methods are called when creation is required*/
	/**
	 * Call this method when created Agency is needed
	 * @param agency
	 */
	public void createAgency(Agency agency) throws RemoteException;
	
	/**
	 * Call this method when created Customer is needed
	 * @param customer
	 */
	public void createCustomer(Customer customer) throws RemoteException;
	
	/**
	 * Call this method when created Account is needed
	 * @param account
	 */
	public void createAccount(Account account) throws RemoteException;
	
	/**
	 * Call this method when created Operation is needed
	 * @param operation
	 */
	public void createOperation(Operation operation) throws RemoteException;
	
	/* These methods are called when select is required*/
	public List <Agency> getAgencies() throws RemoteException;
	
	public List <Customer> getCustomers() throws RemoteException;
	
	public List <Account> getAccounts() throws RemoteException;
	
	public List <Operation> getOperations() throws RemoteException;

	public List <Customer> getCustomersByAgency(String agencyName) throws RemoteException;

	public List <Account> getAccountsByCustomer(String customerID) throws RemoteException;
	
	public List <Operation> getOperationsByAccount(String accountID) throws RemoteException;

	public String getAccountStat(String temp) throws RemoteException;
	
	public int deleteAgency(Agency agency, String clause) throws RemoteException;
	
	public int deleteAccount(Account account, String clause) throws RemoteException;
	
	public int deleteOperation(Operation operation, String clause) throws RemoteException;
	
	public int deleteCustomer(Customer customer, String clause) throws RemoteException;
	
	public int updateCustomer(Customer customer, String clause) throws RemoteException;
	
	public int updateOperation(Operation operation, String clause) throws RemoteException;
	
	public int updateAccount(Account account, String clause) throws RemoteException;
	
	public int updateAgency(Agency agency, String clause) throws RemoteException;
	
}
