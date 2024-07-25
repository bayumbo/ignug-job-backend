package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsaempleo.backend.app.entities.authentication.Users;
import com.bolsaempleo.backend.app.repositories.UsersRepository;
import com.bolsaempleo.backend.app.utility.CorreoUtil;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private UsersRepository usersRepository;

    public void enviarNotificacion(String mail) {

        Users user = usersRepository.findByMail(mail);
		List<String> correos = new ArrayList<>();
		correos.add(user.getEmail().toString());
		
		List<String> correosCopia = new ArrayList<>();
		correosCopia.add("egarcia@yavirac.edu.ec");
		StringBuilder body = new StringBuilder();
		body.append("<html>");
			body.append("<head><meta http-equiv=Content-Type content=\\\"text/html; charset=UTF-8\\\"></head>");
			body.append("<body>");
				body.append("<table align=\\\"center\\\" width=\\\"100%\\\" cellspacing=\\\"0\\\" cellpadding=\\\"5\\\">");
					body.append("<tr>");
						body.append("<td align=\\\"center\\\" style=\\\"border:1px solid #6699CC;background-color:#E5F2FF;\\\">");
							body.append("<img alt=\\\"\\\"  src='https://yavirac.edu.ec/wp-content/uploads/2024/04/logo-yavirac-color-v2.png' width=\\\"300\\\" height=\\\"80\\\" />");
						body.append("</td>");
					body.append("</tr>");
					body.append("<tr>");
						body.append("<td style=\\\"border:1px solid #6699CC;\\\">");
							body.append("<table width=\\\"100%\\\" cellspacing=\\\"0\\\" cellpadding=\\\"5\\\">");
								body.append("<tr>");
									body.append("<td colspan=\"2\">Estimado(a)&nbsp;&nbsp;"+ user.getName().toString() + ' '+user.getLastname().toString()+"<br> <br>");
									//body.append("Se notifica la recepci&oacute;n de la solicitud de subcuenta No: "+maestroModel.getNumSol()+"<br>");
									body.append("Se notifica la creacion del usuario: : "+user.getUsername()+"<br>");
                                    body.append("<br>");
									body.append("<br>");
									body.append("</td>");
								body.append("</tr>");
								body.append("<tr>");
									body.append("<td colspan=\"2\">Saludos cordiales<br> <br>");
									body.append("<br>");
									body.append("<br>");
									body.append("INSTITUTO TECNOLOGICO DE PATRIMONIO CULTURAL Y TURISMO YAVIRAC");
									body.append("</td>");
								body.append("</tr>");
							body.append("</table>");
						body.append("</td>");
					body.append("</tr>");
				body.append("</table>");
			body.append("</body>");
		body.append("</html>");
		CorreoUtil.sendNotificacion(correos, correosCopia, "USUARIO REGISTRADO EN BOLSA DE EMPLEO DEL INSTITUTO YAVIRAC", body.toString());
		
	}
}
