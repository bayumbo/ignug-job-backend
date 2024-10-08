package com.bolsaempleo.backend.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.InputStreamResource;
import com.bolsaempleo.backend.app.dto.ProfessionalReporteDto;
import com.bolsaempleo.backend.app.services.ReporteProfessionalService;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import org.springframework.http.MediaType;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReporteProfessionalController {

    @Autowired
	private ReporteProfessionalService reporteProfessionalService;

	@GetMapping(path = "/professional/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ProfessionalReporteDto reporteProfessionalDto = reporteProfessionalService.obtenerReporteProfessional(params);

		InputStreamResource streamResource = new InputStreamResource(reporteProfessionalDto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(ComunEnum.EXCEL)) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 
		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"" + reporteProfessionalDto.getFileName() + "\"")
				.contentLength(reporteProfessionalDto.getLength()).contentType(mediaType).body(streamResource);
	}
}
