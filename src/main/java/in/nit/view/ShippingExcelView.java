package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Shipping;


public class ShippingExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        //file name
		response.addHeader("Content-Disposition", 
				               "attachment;filename=Shipping.xlsx");
		
		Sheet s=workbook.createSheet("SHIPPING");
		//CONSTRUCT ROW-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>) model.get("list");
		setBody(s,list);
		
	}
    

	//set xlsx the head 
	private void setHeader(Sheet s) {

		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("SHP CODE");
		r.createCell(2).setCellValue("SHP REF NO");
		r.createCell(3).setCellValue("COR REF NO");
		r.createCell(4).setCellValue("CNTCT DTLS");
		r.createCell(5).setCellValue("SL ORD CODE");
		r.createCell(6).setCellValue("NOTE");
		r.createCell(7).setCellValue("BL TO ADDRS");
		r.createCell(8).setCellValue("SL TO ADDRS");
	}
    
	//set xlsx body
	private void setBody(Sheet s, List<Shipping> list) {

		int count=1;
		for(Shipping shp:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(shp.getShpId());
			r.createCell(1).setCellValue(shp.getShpCode());
			r.createCell(2).setCellValue(shp.getShpRefNo());
			r.createCell(3).setCellValue(shp.getCorirRefNo());
			r.createCell(4).setCellValue(shp.getContactDtls());
			r.createCell(5).setCellValue(shp.getSlOrdCode());
			r.createCell(6).setCellValue(shp.getDescription());
			r.createCell(7).setCellValue(shp.getBlToAddrs());
			r.createCell(8).setCellValue(shp.getShpToAddrs());
		}
	}
}
