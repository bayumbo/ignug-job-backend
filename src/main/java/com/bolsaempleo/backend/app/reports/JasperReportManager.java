package com.bolsaempleo.backend.app.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.bolsaempleo.backend.app.utility.QRCodeGenerator;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;



@Component
public class JasperReportManager {

    public ByteArrayOutputStream export(String fileName, String tipoReporte, Map<String, Object> params,
			Connection con) throws JRException, IOException {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();//para el reporte tenerlo en memoria
		ClassPathResource resource = new ClassPathResource(ComunEnum.REPORT_FOLDER.toString() + File.separator + fileName + ComunEnum.JASPER.toString());
		
		InputStream inputStream = resource.getInputStream();
		String paramURLQR = params.get("URLQR").toString();

		/* Generar PATHIMGQR*/
		QRCodeGenerator QR = new QRCodeGenerator();
		try {
			QR.generateQRCodeImage(paramURLQR, ComunEnum.EIDTH,ComunEnum.EIDTH,ComunEnum.QR_CODE_IMAGE_PATH.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> paramsReport=new HashMap<>();
		paramsReport.put("PATHIMGLOGO",ComunEnum.PATHIMGLOGO.toString());
		paramsReport.put("PATHIMGQR",ComunEnum.PATHIMGQR.toString());
		JasperReport jasperReport=(JasperReport)JRLoader.loadObject(inputStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramsReport, con);
		if (tipoReporte.equalsIgnoreCase(ComunEnum.EXCEL)) {
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setDetectCellType(true);
			configuration.setCollapseRowSpan(true);
			exporter.setConfiguration(configuration);
			exporter.exportReport();
		} else {
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		}

		return stream;
	}
}
