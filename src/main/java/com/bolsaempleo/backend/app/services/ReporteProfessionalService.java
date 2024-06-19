package com.bolsaempleo.backend.app.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import com.bolsaempleo.backend.app.dto.ProfessionalReporteDto;
import net.sf.jasperreports.engine.JRException;

public interface ReporteProfessionalService {

    ProfessionalReporteDto obtenerReporteProfessional (Map<String, Object> params) throws JRException, IOException, SQLException;
}
