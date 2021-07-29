package com.zf.cs.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;


@Component
public class ReportUtilImpl implements ReportUtil{

	
	@Override
	public void generatePieChart(String path, List<Object[]> data) {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(Object[] objects: data)
		{
			dataset.setValue(objects[0].toString(),Integer.valueOf(objects[1].toString()));
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D("Location type chart",dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/pieChart.jpeg"),chart, 400, 400);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	
}
