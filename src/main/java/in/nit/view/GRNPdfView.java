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

import in.nit.model.GRN;

public class GRNPdfView extends AbstractPdfView{

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
				           "attachment;filename=GRN.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO GRN FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<GRN> list=(List<GRN>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(5);
		tab.addCell("ID");
		tab.addCell("CODE");
		tab.addCell("TYPE");
		tab.addCell("ORD-CODE");
		tab.addCell("NOTE");
		
		//add data to table
		for(GRN g:list) {
			tab.addCell(g.getGrnId().toString());
			tab.addCell(g.getGrnCode());
			tab.addCell(g.getOrdCode());
			tab.addCell(g.getOrdCode());
			tab.addCell(g.getGrnDesc());
					}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
