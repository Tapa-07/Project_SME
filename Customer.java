package org.tapa.customer.entity;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.weaver.tools.Trace;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity /**
		 * declared as an entity, table name same as class name. i.e Customer
		 **/
public class Customer {

	@Id /**
		 * primary key of the table.
		 **/
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto generation id.
	private int id;
	@Column(name = "customer_Name", nullable = false)
	private String customerName;
	@Column(name = "orderDate", nullable = false)
	private LocalDate orderDate;
	@Column(name = "totalAmount", nullable = false)
	private int totalAmount;

	@ElementCollection
	@NonNull
	private List<String> items;

	/**
	 * Implementing getters and setters.
	 * getting id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * setting id.
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
	/**
	 * generate to string method.
	 */

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", items=" + items + "]";
	}

	/**
	 * parameterized constructor.
	 * @param id - customer id.
	 * @param customerName - customer name.
	 * @param orderDate - order date.
	 * @param totalAmount - price amount
	 * @param items - list of items.
	 */
	public Customer(int id, String customerName, LocalDate orderDate, int totalAmount, List<String> items) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.items = items;
	}
	/**
	 * No Argument constructor.
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
