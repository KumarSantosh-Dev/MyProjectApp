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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "parttab")
public class Part {

	@Id
	@GeneratedValue(generator = "pIdgen")
	@GenericGenerator(name = "pIdgen" ,strategy = "increment")
	@Column(name="pid")
	private Integer partId;
	
	@Column(name="pcode")
	private String partCode;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "partdimentab", joinColumns = @JoinColumn(name="pid"))
	@OrderColumn(name = "dpos")
	@Column(name="dimension")
	private List<String> dimension;
	
    @Column(name = "pcost")
	private String bCost;
	@Column(name="curncy")
	private String baseCurrency;
	@Column(name="uom")
	private String uom;
	@Column(name="omCod")
	private String omCode;
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

	public List<String> getDimension() {
		return dimension;
	}

	public void setDimension(List<String> dimension) {
		this.dimension = dimension;
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

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getOmCode() {
		return omCode;
	}

	public void setOmCode(String omCode) {
		this.omCode = omCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", dimension=" + dimension + ", bCost=" + bCost
				+ ", baseCurrency=" + baseCurrency + ", uom=" + uom + ", omCode=" + omCode + ", description="
				+ description + "]";
	}

		
	
}
