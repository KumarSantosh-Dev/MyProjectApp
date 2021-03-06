package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.Part;

public class PartPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			                         Document document,  
			                         PdfWriter writer,
			                         HttpServletRequest request,
			                         HttpServletResponse response) 
			                        		 throws Exception {
		//download file 
		response.addHeader("Content-Disposition",
				           "attachment;filename=PartS.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO Part FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<Part> list=(List<Part>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(10);
		tab.addCell("ID");
		tab.addCell("CODE");
		tab.addCell("W");
		tab.addCell("L");
		tab.addCell("H");
		tab.addCell("COST");
		tab.addCell("CURRENCY");
		tab.addCell("UOM");
		tab.addCell("ORDER SALE");
		tab.addCell("ORDER PURCHASE");
		tab.addCell("NOTE");
		//add data to table
		for(Part part:list) {
			tab.addCell(part.getPartId().toString());
			tab.addCell(part.getPartCode());
			tab.addCell(part.getWeight().toString());
			tab.addCell(part.getLength().toString());
			tab.addCell(part.getHeight().toString());
			tab.addCell(part.getbCost());
			tab.addCell(part.getBaseCurrency());
			tab.addCell(part.getUomOb().toString());
			tab.addCell(part.getOmSaleOb().getOrderCode());
			tab.addCell(part.getOmPurchaseOb().getOrderCode());
			tab.addCell(part.getDescription());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
