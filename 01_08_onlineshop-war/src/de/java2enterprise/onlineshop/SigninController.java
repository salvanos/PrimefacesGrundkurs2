package de.java2enterprise.onlineshop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.java2enterprise.onlineshop.model.Customer;

@Named
@SessionScoped
public class SigninController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Customer> customers;
	
	@PostConstruct
	public void init() {
		customer = new Customer();
		customers = new ArrayList<Customer>();
	}
	
	@Inject
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void find() {
		if(!customers.contains(customer)) {
			customers.add(customer);
		}
		customer = new Customer();
	}
	
	public List<String> complete(String query) {
		List<String> suggests = new ArrayList<String>();
		if(query.startsWith("B")) {
			suggests.add("Bitte mehr Naßfutter!");
			suggests.add("Bitte mehr Abwechslung!");
			suggests.add("Bitte größere Mengen!");
		} else if(query.startsWith("Z")) {
			suggests.add("Zu viel Trockenfutter!");
		}
		return suggests;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}