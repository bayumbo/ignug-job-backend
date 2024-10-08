package com.bolsaempleo.backend.app.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.dto.UsersResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Users;
import com.bolsaempleo.backend.app.repositories.CatalogueRepository;
import com.bolsaempleo.backend.app.repositories.UsersRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.bolsaempleo.backend.app.utility.FechasUtil;
import com.bolsaempleo.backend.app.utility.Log;
import com.bolsaempleo.backend.app.utility.UsuarioValidation;


@Service
public class UsersServiceImpl implements UsersService{


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private CatalogueRepository catalogueRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true )
    public UsersResponseDto findAllDto(){
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        List<Users> users = usersRepository.findAllUsers();
        List<UsersDto> usersDto = new ArrayList<>();
        try {
            if (users.size()>0){
                for (Users u : users){
                    usersDto.add(crearModelo(u));
                }
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                usersResponseDto.setData(usersDto);
            }else{
                usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }
        return usersResponseDto;
    }

    public UsersDto crearModelo (Users u){
        UsersDto usersDto = new UsersDto();
        if (u.getPasswordChanged() != null){usersDto.setPasswordChanged(u.getPasswordChanged());}
        if (u.getAvatar() != null){usersDto.setAvatar(u.getAvatar());}
        if (u.getBirthdate() != null){usersDto.setBirthdate(u.getBirthdate());}
        if (u.getBloodTypeId() != null){usersDto.setBloodTypeId(u.getBloodTypeId());}
        if (u.getCivilStatusId() != null){usersDto.setCivilStatusId(u.getCivilStatusId());}
        if (u.getCreatedAt() != null){usersDto.setCreatedAt(u.getCreatedAt());}
        if (u.getDeletedAt() != null){usersDto.setDeletedAt(u.getDeletedAt());}
        if (u.getEmail() != null){usersDto.setEmail(u.getEmail());}
        if (u.getEmailVerifiedAt() != null){usersDto.setEmailVerifiedAt(u.getEmailVerifiedAt());}
        if (u.getEthnicOriginId() != null){usersDto.setEthnicOriginId(u.getEthnicOriginId());}
        if (u.getGenderId() != null){usersDto.setGenderId(u.getGenderId());}
        if (u.getIdentificationTypeId() != null){usersDto.setIdentificationTypeId(u.getIdentificationTypeId());}
        if (u.getLastname() != null){usersDto.setLastname(u.getLastname());}
        if (u.getMaxAttempts() != null){usersDto.setMaxAttempts(u.getMaxAttempts());}
        if (u.getName() != null){usersDto.setName(u.getName());}
        if (u.getPhone() != null){usersDto.setPhone(u.getPhone());}
        if (u.getRememberToken() != null){usersDto.setRememberToken(u.getRememberToken());}
        if (u.getSexId() != null){usersDto.setSexId(u.getSexId());}
        if (u.getUpdatedAt() != null){usersDto.setUpdatedAt(u.getUpdatedAt());}
        if (u.getUsername() != null){usersDto.setUsername(u.getUsername());}
        if (u.getPassword() != null){usersDto.setPassword(u.getPassword());}
        return usersDto;
    }

    @Override
    public List<Users> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @Transactional(readOnly = true )
    public UsersResponseDto findByIdDto(UUID Id) {
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        try {
            Users users = usersRepository.findUserById(Id);
            if (users != null){
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                usersResponseDto.setData(crearModelo(users));
            }else{
                usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }

        return usersResponseDto;
    }

    @Override
    public UsersResponseDto saveUserDto(UsersDto usersDto) {
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        try {
            if (UsuarioValidation.isIdentificacionValida(usersDto.getUsername())){
                    Users u = new Users();
                    u = usersRepository.save(crearObjeto(usersDto));
                    if (u.getId() != null){
                        emailServiceImpl.enviarNotificacion(u.getEmail().toString());

                    }
                    usersResponseDto.setData(crearModelo(u));
                    if (usersResponseDto.getData()!= null){
                        usersResponseDto.setCode(ComunEnum.RECURSOCREADO.toString());
                        usersResponseDto.setMessage(ComunEnum.MENSAJERECURSOCREADO.getDescripcion());
                    }    
            }else{
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJECEDULAINVALIDA.getDescripcion());
            }
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }
        return usersResponseDto;
    }

    public Users crearObjeto(UsersDto u){
        Users users = new Users();
        Users uFinded = usersRepository.findByUsername(u.getUsername());
        if (uFinded == null){
            if (u.getName() != null){users.setName(u.getName());}
            if (u.getLastname() != null){users.setLastname(u.getLastname());}
            if (u.getUsername() != null){users.setUsername(u.getUsername());}
            if (u.getEmail() != null){users.setEmail(u.getEmail());}
            if (u.getPassword()!= null){users.setPassword(passwordEncoder.encode(u.getPassword()));}
            if (u.getPasswordChanged() != null){users.setPasswordChanged(u.getPasswordChanged());}
            if (u.getRememberToken() != null){users.setRememberToken(u.getRememberToken());}
            if (u.getMaxAttempts() != null){users.setMaxAttempts(Integer.valueOf(u.getMaxAttempts()));}
            if (u.getEmailVerifiedAt() != null){
                try {
                    users.setEmailVerifiedAt(FechasUtil.convertirStringATimestampSql(u.getEmailVerifiedAt(),ComunEnum.PATRON_TIMESTAMP2.getDescripcion()));
                } catch (Exception e) {
                    Log.error("Service", "Error en carga de fecha creacion", e);
                }} 
            if (u.getPhone() != null){users.setPhone(u.getPhone());}
            if (u.getAvatar() != null){users.setAvatar(u.getAvatar());}
            if (u.getBirthdate() != null){users.setBirthdate(u.getBirthdate());}
            if (u.getCreatedAt() != null){users.setCreatedAt(FechasUtil.getFechaTimestamp());}
            if (u.getDeletedAt() != null){users.setDeletedAt(null);}
            if (u.getUpdatedAt() != null){users.setUpdatedAt(FechasUtil.getFechaTimestamp());}
            if (u.getBloodTypeId() != null){users.setBloodTypeId(catalogueRepository.findCatalogueById(Long.parseLong(u.getBloodTypeId().toString())).getId());}
            if (u.getCivilStatusId() != null){users.setCivilStatusId(catalogueRepository.findCatalogueById(Long.parseLong(u.getCivilStatusId().toString())).getId());}
            if (u.getEthnicOriginId() != null){users.setEthnicOriginId(catalogueRepository.findCatalogueById(Long.parseLong(u.getEthnicOriginId().toString())).getId());}
            if (u.getGenderId() != null){users.setGenderId(catalogueRepository.findCatalogueById(Long.parseLong(u.getGenderId().toString())).getId());}
            if (u.getIdentificationTypeId() != null){users.setIdentificationTypeId(catalogueRepository.findCatalogueById(Long.parseLong(u.getIdentificationTypeId().toString())).getId());}
            if (u.getSexId() != null){users.setSexId(catalogueRepository.findCatalogueById(Long.parseLong(u.getSexId().toString())).getId());}
        }else{
            users.setId(uFinded.getId());
            users.setName(u.getName());
            users.setLastname(u.getLastname());
            users.setUsername(u.getUsername());
            users.setEmail(u.getEmail());
            users.setPassword(u.getPassword());
            users.setPasswordChanged(u.getPasswordChanged());
            users.setRememberToken(u.getRememberToken());
            users.setMaxAttempts(Integer.valueOf(u.getMaxAttempts()));
                try {
                    users.setEmailVerifiedAt(FechasUtil.convertirStringATimestampSql(u.getEmailVerifiedAt(),ComunEnum.PATRON_TIMESTAMP2.getDescripcion()));
                    users.setCreatedAt(FechasUtil.convertirStringATimestampSql(u.getCreatedAt(),ComunEnum.PATRON_TIMESTAMP2.getDescripcion()));
                    users.setDeletedAt(FechasUtil.convertirStringATimestampSql(u.getDeletedAt(),ComunEnum.PATRON_TIMESTAMP2.getDescripcion()));
                    users.setUpdatedAt(FechasUtil.convertirStringATimestampSql(u.getUpdatedAt(),ComunEnum.PATRON_TIMESTAMP2.getDescripcion()));
                } catch (Exception e) {
                    Log.error("Service", "Error en carga de fechas", e);
                }
            users.setPhone(u.getPhone());
            users.setAvatar(u.getAvatar());
            users.setBirthdate(u.getBirthdate());
            users.setBloodTypeId(catalogueRepository.findCatalogueById(Long.parseLong(u.getBloodTypeId().toString())).getId());
            users.setCivilStatusId(catalogueRepository.findCatalogueById(Long.parseLong(u.getCivilStatusId().toString())).getId());
            users.setEthnicOriginId(catalogueRepository.findCatalogueById(Long.parseLong(u.getEthnicOriginId().toString())).getId());
            users.setGenderId(catalogueRepository.findCatalogueById(Long.parseLong(u.getGenderId().toString())).getId());
            users.setIdentificationTypeId(catalogueRepository.findCatalogueById(Long.parseLong(u.getIdentificationTypeId().toString())).getId());
            users.setSexId(catalogueRepository.findCatalogueById(Long.parseLong(u.getSexId().toString())).getId());
        }
        return users;
    }

    @Override
    public UsersResponseDto deteleUserDto(UUID Id) {
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        UsersDto usersDto = new UsersDto();
        Users user = new Users();
        try {
            user=usersRepository.findUserById(Id);
        if (user != null){
            usersDto = crearModelo(user);
            usersDto.setDeletedAt(FechasUtil.getFechaTimestamp());
            usersRepository.saveAndFlush(crearObjeto(usersDto));
            user=usersRepository.findUserById(Id);
            if (user == null){
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJERECURSOELINADO.getDescripcion());
            }
        }else{
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJERECURSONOEXISTE.getDescripcion());
        }    
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }
        
        return usersResponseDto;
    }

    @Override
    public UsersResponseDto findByUserName(String userName) {
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        Users user = usersRepository.findByUsername(userName);
        try {
            if (user != null){
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                usersResponseDto.setData(user.getUsername());
            }else{
                usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
                usersResponseDto.setData("No existe el Username:" + userName);
            }
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }
        return usersResponseDto;
    }

    @Override
    public UsersResponseDto findByMail(String mail) {
        UsersResponseDto usersResponseDto = new UsersResponseDto();
        Users user = usersRepository.findByMail(mail);
        try {
            if (user != null){
                usersResponseDto.setCode(ComunEnum.CORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                usersResponseDto.setData(user.getEmail());
            }else{
                usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
                usersResponseDto.setData("No existe el email:" + mail);
            }
        } catch (Exception e) {
            usersResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            usersResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            usersResponseDto.setData(e.getMessage());
        }
        return usersResponseDto;
    }


}