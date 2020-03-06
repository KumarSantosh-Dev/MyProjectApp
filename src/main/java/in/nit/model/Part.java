package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "parttab")
public class Part {

	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer partId;
	
	@Column(name="pcode")
	private String partCode;
	
	@Column(name="dweight")
	private Double weight;
	@Column(name="dlength")
	private Double length;
	@Column(name="dheight")
	private Double height;
	
    @Column(name = "pcost")
	private String bCost;
	@Column(name="curncy")
	private String baseCurrency;
	
	@ManyToOne
    @JoinColumn(name = "uomIdFk")
	private Uom uomOb;
	
	@ManyToOne
	@JoinColumn(name = "orderSaleFk")
	private OrderMethod omSaleOb;
	
	@ManyToOne
	@JoinColumn(name = "orderPurchaseFk")
	private OrderMethod omPurchaseOb;
	
	
	@Column(name="partdesc")
	private String description;
	
	public Part() {
		super();
	}

	public Part(Integer partId) {
		super();
		this.partId = partId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getbCost() {
		return bCost;
	}

	public void setbCost(String bCost) {
		this.bCost = bCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	
	public Uom getUomOb() {
		return uomOb;
	}

	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethod getOmSaleOb() {
		return omSaleOb;
	}

	public void setOmSaleOb(OrderMethod omSaleOb) {
		this.omSaleOb = omSaleOb;
	}
	
	

	public OrderMethod getOmPurchaseOb() {
		return omPurchaseOb;
	}

	public void setOmPurchaseOb(OrderMethod omPurchaseOb) {
		this.omPurchaseOb = omPurchaseOb;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", weight=" + weight + ", length=" + length
				+ ", height=" + height + ", bCost=" + bCost + ", baseCurrency=" + baseCurrency + ", uomOb=" + uomOb
				+ ", omSaleOb=" + omSaleOb + ", omPurchaseOb=" + omPurchaseOb + ", description=" + description + "]";
	}

	
}
