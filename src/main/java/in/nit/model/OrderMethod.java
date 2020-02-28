package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orderMethodTab")
public class OrderMethod {
	@Id
	@GeneratedValue
	@Column(name = "ordId")
	private Integer orderId;
	
	@Column(name = "ordMode")
	private String orderMode;
	
	@Column(name = "ordCode")
	private String orderCode;
	
	@Column(name = "ordType")
	private String orderType;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "omacpttab",joinColumns =@JoinColumn(name="ordId"))
	@OrderColumn(name = "pos")
	@Column(name = "ordAccpt")
	private List<String> orderAccpt;
	
	@Column(name = "ordDesc")
	private String description;

	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<String> getOrderAccpt() {
		return orderAccpt;
	}

	public void setOrderAccpt(List<String> orderAccpt) {
		this.orderAccpt = orderAccpt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderType=" + orderType + ", orderAccpt=" + orderAccpt + ", description=" + description + "]";
	}
	
	
	
	
	
	}
