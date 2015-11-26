package dynamic.report;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
public class OlaJasper {

	public static void main(String[] args) throws FileNotFoundException, DRException {
		// TODO Auto-generated method stub
//builder
		JasperReportBuilder report=DynamicReports.report();
//styles
		StyleBuilder boldStyle=DynamicReports.stl.style().bold();
		StyleBuilder boldCentered=DynamicReports.stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder columnHeader=DynamicReports.stl.style(boldCentered)
		.setBorder(DynamicReports.stl.penDotted())
		.setBackgroundColor(Color.LIGHT_GRAY);
		
		//add titles
		TextFieldBuilder<String> title=DynamicReports.cmp.text("Sonar Fixes Report");
		title.setStyle(boldCentered);
		
		report.title(title );
		// row num
		TextColumnBuilder<Integer> rowNumColumn = Columns.reportRowNumberColumn("No.").setFixedColumns(2).setHorizontalAlignment(HorizontalAlignment.CENTER);

		TextColumnBuilder<String> fileNameColumn=Columns.column("File Name","fileName",DynamicReports.type.stringType());
		TextColumnBuilder<String> MCouplingColumn=Columns.column("Altered to remove Duplicate Literals","MCoupling",DynamicReports.type.stringType());
		TextColumnBuilder<String> MDuplicateColumn=Columns.column("Altered to remove Loose Coupling","MDuplicate",DynamicReports.type.stringType());
		
		report.columns(rowNumColumn, fileNameColumn,MCouplingColumn,MDuplicateColumn);
		report.pageFooter(DynamicReports.cmp.pageXofY());
		// higligh rows
		report.highlightDetailEvenRows();

		report.setColumnTitleStyle(columnHeader);
		report.setDataSource(getDetails());
report.show();
//report.toPdf(new FileOutputStream(new File("e:/report.pdf")));
System.out.println("done");
	}

	private static List<Details> getDetails()
	{
		List<Details> list=new ArrayList<Details>();
		list.add(new Details("steo","true","false"));
		list.add(new Details("ssss","true","false"));
		list.add(new Details("aaaaa","false","true"));
		list.add(new Details("aaaa","true","false"));
		return list;
	}
	
}
