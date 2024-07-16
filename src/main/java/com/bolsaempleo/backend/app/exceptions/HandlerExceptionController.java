package com.bolsaempleo.backend.app.exceptions;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bolsaempleo.backend.app.dto.ErrorDto;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.servlet.ServletException;

@RestControllerAdvice
public class HandlerExceptionController{

    @ExceptionHandler(Exception.class)
    public ProblemDetail securityException(Exception e){
        ProblemDetail errorDetail=null;
        if (e instanceof BadCredentialsException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), e.getMessage());
            errorDetail.setProperty("Acces Denied", "Authentication Failure");
        }
        if (e instanceof AccessDeniedException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), e.getMessage());
            errorDetail.setProperty("Acces Denied", "Not Authorized"); 
        }
    return errorDetail;
    }

    @ExceptionHandler(SQLDataException.class)
    public ResponseEntity<ErrorDto> noData(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de tipo SQL: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> nullos(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de tipo Null Pointer: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ErrorDto> errorJWTGeneral(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error servlet con dificultades: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> errorIOGeneral(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error Credenciales no validas: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }

    @ExceptionHandler(StreamReadException.class)
    public ResponseEntity<ErrorDto> errorIGeneral(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de procesamiento de lectura de datos: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }

    @ExceptionHandler(DatabindException.class)
    public ResponseEntity<ErrorDto> errorOGeneral(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de acceso a datos: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDto> errorDataAccess(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de tipo JDBC: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDto> errorSqlException(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error de tipo JDBC: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }
    

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> errorFilterUsername(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
        errorDto.setMessage(ComunEnum.MENSAJEERRORINTERNOSERVIDOR.getDescripcion());
        errorDto.setData("Se ha producido un Error en tiempo de Ejecucion del JVM: "+e.getMessage());
    return ResponseEntity.internalServerError().body(errorDto);
    }
}
