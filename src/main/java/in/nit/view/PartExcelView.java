package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Part;

public class PartExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //file name
		response.addHeader("Content-Disposition", 
				               "attachment;filename=Parts.xlsx");
		
		Sheet s=workbook.createSheet("PART");
		//CONSTRUCT ROW-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		setBody(s,list);
		
	}
    

	//set xlsx the head 
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("DIMENSION");
		r.createCell(3).setCellValue("BASE COST");
		r.createCell(4).setCellValue("BASE CURRENCY");
		r.createCell(5).setCellValue("UOM");
		r.createCell(6).setCellValue("OREDER CODE");
		r.createCell(7).setCellValue("DESCRIPTION");
	}
    
	//set xlsx body
	private void setBody(Sheet s, List<Part> list) {

		int count=1;
		for(Part p:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(p.getPartId());
			r.createCell(1).setCellValue(p.getPartCode());
			r.createCell(2).setCellValue(p.getDimension().toString());
			r.createCell(3).setCellValue(p.getbCost());
			r.createCell(4).setCellValue(p.getBaseCurrency());
			r.createCell(5).setCellValue(p.getUom());
			r.createCell(6).setCellValue(p.getOmCode());
			r.createCell(7).setCellValue(p.getDescription());
		}
	}
}
