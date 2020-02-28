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

import in.nit.model.PurchaseOrder;

public class PurchaseOrderPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			                         Document document,  
			                         PdfWriter writer,
			                         HttpServletRequest request,
			                         HttpServletResponse response) 
			                        		 throws Exception {
		//download file 
		response.addHeader("Content-Disposition",
				           "attachment;filename=purchaseOrder.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO PurchaseOrder FILE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(7);
		tab.addCell("ID");
		tab.addCell("CODE");
		tab.addCell("SHIP-CODE");
		tab.addCell("VENDOR");
		tab.addCell("REF-NO");
		tab.addCell("Q-CHECK");
		tab.addCell("DEF-STATUS");
		tab.addCell("NOTE");
		//add data to table
		for(PurchaseOrder po:list) {
			tab.addCell(po.getOrderId().toString());
			tab.addCell(po.getOrderCode());
			tab.addCell(po.getShipCode());
			tab.addCell(po.getVendor());
			tab.addCell(po.getRefNumber());
			tab.addCell(po.getQltyCheck());
			tab.addCell(po.getDefStatus());
			tab.addCell(po.getDescription());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
