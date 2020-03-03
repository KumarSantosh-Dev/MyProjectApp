package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.GRN;

public class GRNExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //file name
		response.addHeader("Content-Disposition", 
				               "attachment;filename=GRN.xlsx");
		
		Sheet s=workbook.createSheet("GRN");
		//CONSTRUCT ROW-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<GRN> list=(List<GRN>) model.get("list");
		setBody(s,list);
		
	}
    

	//set xlsx the head 
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("TYPE");
		r.createCell(3).setCellValue("ORD-CODE");
		r.createCell(4).setCellValue("NOTE");
		
	}
    
	//set xlsx body
	private void setBody(Sheet s, List<GRN> list) {

		int count=1;
		for(GRN g:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(g.getGrnId());
			r.createCell(1).setCellValue(g.getGrnCode());
			r.createCell(2).setCellValue(g.getGrnType());
			r.createCell(3).setCellValue(g.getGrnType());
			r.createCell(4).setCellValue(g.getGrnDesc());
		}
	}
}
