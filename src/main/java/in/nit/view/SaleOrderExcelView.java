package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //file name
		response.addHeader("Content-Disposition", 
				               "attachment;filename=SaleOrders.xlsx");
		
		Sheet s=workbook.createSheet("SaleOrder");
		//CONSTRUCT ROW-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		setBody(s,list);
		
	}
    

	//set xlsx the head 
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("ORD CODE");
		r.createCell(2).setCellValue("SHIP CODE");
		r.createCell(3).setCellValue("CUSTOMER");
		r.createCell(4).setCellValue("REF-NUM");
		r.createCell(5).setCellValue("STOCK-MODE");
		r.createCell(6).setCellValue("STOCK-SRC");
		r.createCell(7).setCellValue("DEF-STATUS");
		r.createCell(7).setCellValue("DESCRIPTION");
	}
    
	//set xlsx body
	private void setBody(Sheet s, List<SaleOrder> list) {

		int count=1;
		for(SaleOrder so:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(so.getSaleId());
			r.createCell(1).setCellValue(so.getOrdCode());
			r.createCell(2).setCellValue(so.getShipCode());
			r.createCell(3).setCellValue(so.getCustomer());
			r.createCell(4).setCellValue(so.getRefNum());
			r.createCell(5).setCellValue(so.getStMode());
			r.createCell(6).setCellValue(so.getStSource());
			r.createCell(7).setCellValue(so.getStatus());
			r.createCell(7).setCellValue(so.getSaleDesc());
		}
	}
}
