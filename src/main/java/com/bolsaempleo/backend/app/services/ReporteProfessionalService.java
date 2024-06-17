package com.bolsaempleo.backend.app.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import com.bolsaempleo.backend.app.dto.ReporteProfessionalDto;
import net.sf.jasperreports.engine.JRException;

public interface ReporteProfessionalService {

    ReporteProfessionalDto obtenerReporteProfessional (Map<String, Object> params) throws JRException, IOException, SQLException;
}
