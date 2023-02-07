package com.application.Service;

import java.util.List;

import com.application.DTO.CustomerDto;
import com.application.Entities.Customer;
import com.application.Exception.CustomerException;

public interface CustomerService {
	
  public Customer registerCustomer(Customer customer) throws CustomerException;
  
  public Customer getCustomerDetialsByEmail(String email) throws CustomerException;
  
  public List<Customer> getAllCustomers()throws CustomerException;
  
  public Customer updateCustomer(String email, CustomerDto customerDto)throws CustomerException;
  
  public Customer updatePassword(String email ,String password)throws CustomerException;
  
  public Customer deleteCustomer(String email)throws CustomerException;
  
  
}
