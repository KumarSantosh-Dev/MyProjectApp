package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "porderTab")
public class PurchaseOrder {
    @Id
    @GeneratedValue
    @Column(name = "ordId")
	private Integer orderId;
   
    @Column(name = "ordCod")
	private String orderCode;
   
    @ManyToOne
    @JoinColumn(name = "shipIdFk")
	private ShipmentType shipCode;
    
    @ManyToOne
    @JoinColumn(name = "whUserIdFk")
	private WhUserType vendor;
    
    @Column(name = "refNo")
	private String refNumber;
    
    @Column(name = "qltycheck")
	private String qltyCheck;
    
    @Column(name = "dstatus")
	private String defStatus;
    
    @Column(name = "descrption")
	private String description;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	public ShipmentType getShipCode() {
		return shipCode;
	}

	public void setShipCode(ShipmentType shipCode) {
		this.shipCode = shipCode;
	}
	
	
	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getQltyCheck() {
		return qltyCheck;
	}

	public void setQltyCheck(String qltyCheck) {
		this.qltyCheck = qltyCheck;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", orderCode=" + orderCode + ", shipCode=" + shipCode + ", vendor="
				+ vendor + ", refNumber=" + refNumber + ", qltyCheck=" + qltyCheck + ", defStatus=" + defStatus
				+ ", description=" + description + "]";
	}
	
}
