package util;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	static Logger log = LogManager.getLogger(ExtentManager.class);
	static String extentReport = "ExtentReport";

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	static LocalDate localDate = LocalDate.now();
	static LocalTime time = LocalTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm");

	static String reportName = extentReport + time.format(formatter) + ".html";
//change to string buffer
	static StringBuffer htmlReport = new StringBuffer().append(System.getProperty("user.dir")).append(File.separator)
			.append(extentReport).append(File.separator).append(dtf.format(localDate)).append(File.separator)
			.append(reportName);
	static String htmlReportPath = htmlReport.toString();

	// Returns the ExtentReports instance, creating it if necessary
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();

		return extent;
	}

	// Creates a new ExtentReports instance with the given file name
	public static ExtentReports createInstance() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlReportPath);
		// Configures the HTML report's theme, title, encoding, and name
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(htmlReportPath);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(htmlReportPath);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter = new ExtentHtmlReporter(htmlReportPath);
		extent.attachReporter(htmlReporter);
		return extent;
	}

	

	// Logs a message with the given ExtentTest instance and boolean flag
	// If flag is true, logs as a pass message, otherwise logs as a fail message
	public static void logsreportsinfo(ExtentTest child, String message, boolean flag) {
		if (flag)

			child.pass(message + flag);

		else
			child.fail(message + flag);

		log.info(message);

	}

//Logs an info message with the given ExtentTest instance and message string
	public static void logsreportsinfo(ExtentTest child, String message) {
		child.info(message);
		log.info(message);
	}
}