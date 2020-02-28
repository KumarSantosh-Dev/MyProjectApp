package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipTab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipId;
	
	@Column(name="shipMode")
	private String shipMode;
	
	@Column(name="shipCode")
	private String shipCode;
	
	@Column(name="enbShip")
	private String enbShip;
	
	@Column(name="shipGrd")
	private String shipGrd;
	
	@Column(name="shipDesc")
	private String shipDesc;

	public ShipmentType() {
		super();
	}

	public Integer getShipId() {
		return shipId;
	}
	

	public ShipmentType(Integer shipId) {
		super();
		this.shipId = shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getEnbShip() {
		return enbShip;
	}

	public void setEnbShip(String enbShip) {
		this.enbShip = enbShip;
	}

	public String getShipGrd() {
		return shipGrd;
	}

	public void setShipGrd(String shipGrd) {
		this.shipGrd = shipGrd;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", enbShip="
				+ enbShip + ", shipGrd=" + shipGrd + ", shipDesc=" + shipDesc + "]";
	}
	
	
}
