package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.PurchaseOrder;

public class PurchaseOrderExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //file name
		response.addHeader("Content-Disposition", 
				               "attachment;filename=PurchaseOrder.xlsx");
		
		Sheet s=workbook.createSheet("PurchaseOrder");
		//CONSTRUCT ROW-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		setBody(s,list);
		
	}
    

	//set xlsx the head 
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("SHIP-CODE");
		r.createCell(3).setCellValue("VENDOR");
		r.createCell(4).setCellValue("REF-NO");
		r.createCell(5).setCellValue("Q-CHECK");
		r.createCell(6).setCellValue("DEF-STATUS");
		r.createCell(7).setCellValue("DESC");
	}
    
	//set xlsx body
	private void setBody(Sheet s, List<PurchaseOrder> list) {

		int count=1;
		for(PurchaseOrder po:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(po.getOrderId());
			r.createCell(1).setCellValue(po.getOrderCode());
			r.createCell(2).setCellValue(po.getShipCode().getShipCode());
			r.createCell(3).setCellValue(po.getVendor().getUserCode());
			r.createCell(4).setCellValue(po.getRefNumber());
			r.createCell(5).setCellValue(po.getQltyCheck());
			r.createCell(6).setCellValue(po.getDefStatus());
			r.createCell(7).setCellValue(po.getDescription());
		}
	}
}
