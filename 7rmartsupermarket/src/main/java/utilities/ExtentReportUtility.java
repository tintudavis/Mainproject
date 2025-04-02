package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();
	public synchronized static ExtentReports createExtentReports() {
			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
			reporter.config().setReportName("SevenRMartSuperMarket");
			extentReports.attachReporter(reporter);
			extentReports.setSystemInfo("organization", "Obsqura");
			extentReports.setSystemInfo("Name", "Athira");
			return extentReports;

}}
