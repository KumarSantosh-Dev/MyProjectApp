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

import in.nit.model.Shipping;

public class ShippingPdfView extends AbstractPdfView{

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
				           "attachment;filename=Shipping.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO SHIPPING FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<Shipping> list=(List<Shipping>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(9);
		tab.addCell("ID");
		tab.addCell("SHIP CODE");
		tab.addCell("SHP REF NUM");
		tab.addCell("COR REF NUM");
		tab.addCell("CNTCT DETAILS");
		tab.addCell("SL ORD CODE");
		tab.addCell("NOTE");
		tab.addCell("BL TO ADDRS");
		tab.addCell("SHP TO ADDRS");
		//add data to table
		for(Shipping shp:list) {
			tab.addCell(shp.getShpId().toString());
			tab.addCell(shp.getShpCode());
			tab.addCell(shp.getShpRefNo());
			tab.addCell(shp.getCorirRefNo());
			tab.addCell(shp.getContactDtls());
			tab.addCell(shp.getSlOrdCode());
			tab.addCell(shp.getDescription());
			tab.addCell(shp.getBlToAddrs());
			tab.addCell(shp.getShpToAddrs());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
