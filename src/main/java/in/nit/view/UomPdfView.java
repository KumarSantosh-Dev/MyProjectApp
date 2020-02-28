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

import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView{

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
				           "attachment;filename=uoms.pdf");
		
		//create Element
		Paragraph p=new Paragraph("WELCOME TO UOM FILE");
		//add element to document
		document.add(p);
		//read data from model
		List<Uom> list=(List<Uom>) model.get("list");
		//create a Tbale with no.of columns
		PdfPTable tab=new PdfPTable(4);
		tab.addCell("ID");
		tab.addCell("TYPE");
		tab.addCell("MODEL");
		tab.addCell("NOTE");
		//add data to table
		for(Uom u:list) {
			tab.addCell(u.getUomId().toString());
			tab.addCell(u.getUomType());
			tab.addCell(u.getUomModel());
			tab.addCell(u.getUomDesc());
		}
		//add table to document
		document.add(tab);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
