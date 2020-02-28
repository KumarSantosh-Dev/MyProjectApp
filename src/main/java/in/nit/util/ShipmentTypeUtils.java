package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtils {

	public void generatePie(String path,List<Object[]> data) {
		//Create Dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] arr:data) {
			//key-shipMode , Val=count
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		//create JFreeChart using ChartFactory
		JFreeChart chart=ChartFactory.createPieChart3D("ShipmentType Modes",dataset,true,true,false);
		//Save Image as using ChartUtils
		   try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipModePie.jpg"), chart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] arr:data) {
			// Val=index-1(y-axis),key-index-0(x-axis) 
			dataset.setValue( Double.valueOf(arr[1].toString()),arr[0].toString(),"");
		}
		//create JFreeChart using ChartFactory
		JFreeChart chart=ChartFactory.createBarChart("Shipment Modes", "MODES", "COUNT", dataset);
		//Save Image as using ChartUtils
		   try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipModeBar.jpg"), chart, 400, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
