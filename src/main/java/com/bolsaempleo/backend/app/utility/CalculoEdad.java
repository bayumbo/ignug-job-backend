package com.bolsaempleo.backend.app.utility;

import java.util.Calendar;
import java.util.Date;

public class CalculoEdad {

    public String calculo_de_edades(Date fechaNac)
    {
		
		
		Calendar calendar = Calendar.getInstance();	
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(fechaNac);
	    
        Integer diaInicio = cal.get(Calendar.DAY_OF_MONTH);
        Integer mesInicio = cal.get(Calendar.MONTH)+1;
        Integer anioInicio = cal.get(Calendar.YEAR);

        Integer diaActual = calendar.get(Calendar.DAY_OF_MONTH); 
        Integer mesActual = calendar.get(Calendar.MONTH)+1;
        Integer anioActual = calendar.get(Calendar.YEAR);

        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    if(b - (diaInicio - diaActual)<b)
                    	dias = b - (diaInicio - diaActual);
                    else
                    	dias = (b - (diaInicio - diaActual))-b;

                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                System.out.println(anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }
        
        return anios+" Años "+meses+" Meses "+dias+" Días";
        
    }
	
	public Integer calculo_de_año(Date fechaNac)
    {	
		Calendar calendar = Calendar.getInstance();			
		Calendar cal = Calendar.getInstance();
	    cal.setTime(fechaNac);	    
        Integer diaInicio = cal.get(Calendar.DAY_OF_MONTH);
        Integer mesInicio = cal.get(Calendar.MONTH)+1;
        Integer anioInicio = cal.get(Calendar.YEAR);
        Integer diaActual = calendar.get(Calendar.DAY_OF_MONTH); 
        Integer mesActual = calendar.get(Calendar.MONTH)+1;
        Integer anioActual = calendar.get(Calendar.YEAR);
        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    if(b - (diaInicio - diaActual)<b)
                    	dias = b - (diaInicio - diaActual);
                    else
                    	dias = (b - (diaInicio - diaActual))-b;

                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                System.out.println(anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }        
        return anios;        
    }
}
