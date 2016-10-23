package com.acme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CustomerInvoice {

	private String customerId;
	private String addressId;
	private String invoiceId;
	private String invoiceType;
	private String invoiceTypeLocalized;
	private Date invoiceDate;
	private Date paymentDueDate;
	private String invoiceNumber;
	private Date startDate;
	private Date endDate;
	private String periodDescription;
	private double amount;
	private double vatAmount;
	private double totalAmount;

	public CustomerInvoice(String customerId, String addressId,
			String invoiceId, String invoiceType, String invoiceTypeLocalized,
			Date invoiceDate, Date paymentDueDate, String invoiceNumber,
			Date startDate, Date endDate, String periodDescription,
			double amount, double vatAmount, double totalAmount) {
		super();
		this.customerId = customerId;
		this.addressId = addressId;
		this.invoiceId = invoiceId;
		this.invoiceType = invoiceType;
		this.invoiceTypeLocalized = invoiceTypeLocalized;
		this.invoiceDate = invoiceDate;
		this.paymentDueDate = paymentDueDate;
		this.invoiceNumber = invoiceNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.periodDescription = periodDescription;
		this.amount = amount;
		this.vatAmount = vatAmount;
		this.totalAmount = totalAmount;
	}
	
	public CustomerInvoice( ) {
	      super();
	   }
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@Id
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceTypeLocalized() {
		return invoiceTypeLocalized;
	}
	public void setInvoiceTypeLocalized(String invoiceTypeLocalized) {
		this.invoiceTypeLocalized = invoiceTypeLocalized;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPeriodDescription() {
		return periodDescription;
	}
	public void setPeriodDescription(String periodDescription) {
		this.periodDescription = periodDescription;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CustomerInvoice [customerId=" + customerId + ", addressId="
				+ addressId + ", invoiceId=" + invoiceId + ", invoiceType="
				+ invoiceType + ", invoiceTypeLocalized="
				+ invoiceTypeLocalized + ", invoiceDate=" + invoiceDate
				+ ", paymentDueDate=" + paymentDueDate + ", invoiceNumber="
				+ invoiceNumber + ", startDate=" + startDate + ", endDate="
				+ endDate + ", periodDescription=" + periodDescription
				+ ", amount=" + amount + ", vatAmount=" + vatAmount
				+ ", totalAmount=" + totalAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result
				+ ((invoiceId == null) ? 0 : invoiceId.hashCode());
		result = prime * result
				+ ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime * result
				+ ((invoiceType == null) ? 0 : invoiceType.hashCode());
		result = prime
				* result
				+ ((invoiceTypeLocalized == null) ? 0 : invoiceTypeLocalized
						.hashCode());
		result = prime * result
				+ ((paymentDueDate == null) ? 0 : paymentDueDate.hashCode());
		result = prime
				* result
				+ ((periodDescription == null) ? 0 : periodDescription
						.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerInvoice other = (CustomerInvoice) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (invoiceType == null) {
			if (other.invoiceType != null)
				return false;
		} else if (!invoiceType.equals(other.invoiceType))
			return false;
		if (invoiceTypeLocalized == null) {
			if (other.invoiceTypeLocalized != null)
				return false;
		} else if (!invoiceTypeLocalized.equals(other.invoiceTypeLocalized))
			return false;
		if (paymentDueDate == null) {
			if (other.paymentDueDate != null)
				return false;
		} else if (!paymentDueDate.equals(other.paymentDueDate))
			return false;
		if (periodDescription == null) {
			if (other.periodDescription != null)
				return false;
		} else if (!periodDescription.equals(other.periodDescription))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double
				.doubleToLongBits(other.totalAmount))
			return false;
		if (Double.doubleToLongBits(vatAmount) != Double
				.doubleToLongBits(other.vatAmount))
			return false;
		return true;
	}
	
}
