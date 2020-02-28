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

import in.nit.model.OrderMethod;

public class OrderMethodPdfView extends AbstractPdfView{

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
				           "attachment;filename=orderMethod.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO ORDER METHOD FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(6);
		tab.addCell("ID");
		tab.addCell("MODE");
		tab.addCell("CODE");
		tab.addCell("TYPE");
		tab.addCell("ACCEPT");
		tab.addCell("NOTE");
		//add data to table
		for(OrderMethod om:list) {
			tab.addCell(om.getOrderId().toString());
			tab.addCell(om.getOrderMode());
			tab.addCell(om.getOrderCode());
			tab.addCell(om.getOrderType());
			tab.addCell(om.getOrderAccpt().toString());
			tab.addCell(om.getDescription());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
