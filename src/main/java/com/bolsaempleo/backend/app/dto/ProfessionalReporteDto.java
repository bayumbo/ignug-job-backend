package com.bolsaempleo.backend.app.dto;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ProfessionalReporteDto implements Serializable{
    
    /* Propiedades para poder pasar el archivo al controlador,
     el servicio entrega en bytes, debo transformarlo en archivo */
    @Getter
    @Setter
    private String fileName;
	@Getter
    @Setter
    private ByteArrayInputStream stream;
	@Getter
    @Setter
    private int length;

	
}
