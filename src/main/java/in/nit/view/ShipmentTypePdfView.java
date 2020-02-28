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

import in.nit.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView{

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
				           "attachment;filename=shipments.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO SHIPMENT TYPE FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(6);
		tab.addCell("ID");
		tab.addCell("MODE");
		tab.addCell("CODE");
		tab.addCell("ENABLED");
		tab.addCell("GRADE");
		tab.addCell("NOTE");
		//add data to table
		for(ShipmentType st:list) {
			tab.addCell(st.getShipId().toString());
			tab.addCell(st.getShipMode());
			tab.addCell(st.getShipCode());
			tab.addCell(st.getEnbShip());
			tab.addCell(st.getShipGrd());
			tab.addCell(st.getShipDesc());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
