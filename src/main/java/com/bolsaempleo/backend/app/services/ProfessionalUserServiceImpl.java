package com.bolsaempleo.backend.app.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.ProfessionalDto;
import com.bolsaempleo.backend.app.dto.ProfessionalUserDto;
import com.bolsaempleo.backend.app.dto.ProfessionalUserResponseDto;
import com.bolsaempleo.backend.app.dto.UsersDto;
import com.bolsaempleo.backend.app.entities.authentication.Users;
import com.bolsaempleo.backend.app.entities.job_board.Professional;
import com.bolsaempleo.backend.app.repositories.ProfessionalRepository;
import com.bolsaempleo.backend.app.repositories.UsersRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.bolsaempleo.backend.app.utility.UsuarioValidation;

@Service
public class ProfessionalUserServiceImpl implements ProfessionalUserService{

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsersService usersService;

    @Override
    public ProfessionalUserResponseDto saveProfessionalUserDto(ProfessionalUserDto professionalUserDto ) {
        ProfessionalUserResponseDto dto = new ProfessionalUserResponseDto();
        List<Users> users = new ArrayList<>();
        users = usersRepository.findUsersByUsername(professionalUserDto.getUsersDto().getUsername());
        try {
            if (UsuarioValidation.isIdentificacionValida(professionalUserDto.getUsersDto().getUsername())){
                Users u = new Users();
                if (users.isEmpty()){    
                    Professional p = new Professional();
                    u = usersRepository.save(toUsers(professionalUserDto.getUsersDto()));
                        if (u.getId() != null){
                            p = professionalRepository.save(toProfessional(professionalUserDto.getProfessionalDto(),u.getId()));
                            if (p.getId() != null){
                                //emailServiceImpl.enviarNotificacion(u.getEmail().toString());
                            }else{
                                dto.setCode(ComunEnum.INCORRECTO.toString());
                                dto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion() + "Ocurrio un error en el envio de correo");
                            }
                        }
                    dto.setData(toUserDto(u));
                    //dto.setData(toProfessionalDto(p));
                        if (dto.getData()!= null){
                            dto.setCode(ComunEnum.RECURSOCREADO.toString());
                            dto.setMessage(ComunEnum.MENSAJERECURSOCREADO.getDescripcion());
                        }
                } else{
                    dto.setCode(ComunEnum.CORRECTO.toString());
                    dto.setMessage(ComunEnum.MENSAJEUSEREXIST.getDescripcion());
                }   
            }else{
                dto.setCode(ComunEnum.CORRECTO.toString());
                dto.setMessage(ComunEnum.MENSAJECEDULAINVALIDA.getDescripcion());
            }
        } catch (Exception e) {
            dto.setCode(ComunEnum.INCORRECTO.toString());
            dto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            dto.setData(e.getMessage());
        }
        return dto;
    }
    private UsersDto toUserDto(Users users) {
        UsersDto dto = new UsersDto();
        dto.setUsername(users.getUsername());
        dto.setPassword(users.getPassword());
        dto.setLastname(users.getLastname());
        dto.setName(users.getName());
        dto.setAvatar(users.getAvatar());
        dto.setBirthdate(users.getBirthdate());
        dto.setEmail(users.getEmail());
        dto.setEmailVerifiedAt(users.getEmailVerifiedAt());
        dto.setMaxAttempts(users.getMaxAttempts());
        dto.setPasswordChanged(users.getPasswordChanged());
        dto.setPhone(users.getPhone());
        dto.setRememberToken(users.getRememberToken());
        dto.setSexId(users.getSexId());
        dto.setEthnicOriginId(users.getEthnicOriginId());
        dto.setGenderId(users.getGenderId());
        dto.setIdentificationTypeId(users.getIdentificationTypeId());
        dto.setBloodTypeId(users.getBloodTypeId());
        dto.setCivilStatusId(users.getCivilStatusId());
        dto.setCreatedAt(users.getCreatedAt());
        dto.setUpdatedAt(users.getUpdatedAt());
        dto.setDeletedAt(users.getDeletedAt());
        return dto;
    }

    private Users toUsers(UsersDto dto) {
        Users users = new Users();
        users.setUsername(dto.getUsername());//not null
        users.setPassword(passwordEncoder.encode(dto.getPassword()));//not null
        users.setLastname(dto.getLastname());
        users.setName(dto.getName());
        users.setAvatar(dto.getAvatar());
        users.setBirthdate(dto.getBirthdate());
        users.setEmail(dto.getEmail());//not null
        users.setEmailVerifiedAt(dto.getEmailVerifiedAt());
        users.setMaxAttempts(dto.getMaxAttempts());//not null
        users.setPasswordChanged(dto.getPasswordChanged());//not null
        users.setPhone(dto.getPhone());
        users.setRememberToken(dto.getRememberToken());
        users.setSexId(dto.getSexId());
        users.setEthnicOriginId(dto.getEthnicOriginId());
        users.setGenderId(dto.getGenderId());
        users.setIdentificationTypeId(dto.getIdentificationTypeId());
        users.setBloodTypeId(dto.getBloodTypeId());
        users.setCivilStatusId(dto.getCivilStatusId());
        users.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        //users.setUpdatedAt(dto.getUpdatedAt());
        //users.setDeletedAt(dto.getDeletedAt());
        return users;
    }

    private ProfessionalDto toProfessionalDto(Professional professional) {
        ProfessionalDto dto = new ProfessionalDto();
        dto.setAboutMe(professional.getAboutMe());
        dto.setCatastrophicDiseased(professional.getCatastrophicDiseased());
        dto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        dto.setDeletedAt(professional.getDeletedAt());
        dto.setDisabled(professional.getDisabled());
        dto.setFamiliarCatastrophicDiseased(professional.getFamiliarCatastrophicDiseased());
        dto.setFamiliarDisabled(professional.getFamiliarDisabled());
        dto.setIdentificationFamiliarDisabled(professional.getIdentificationFamiliarDisabled());
        dto.setTraveled(professional.getTraveled());
        dto.setUpdatedAt(professional.getUpdatedAt());
            return dto;
    }

    private Professional toProfessional(ProfessionalDto dto, UUID userId) {
        Professional professional = new Professional();
        professional.setAboutMe(dto.getAboutMe());//not null
        professional.setCatastrophicDiseased(dto.getCatastrophicDiseased());
        professional.setDisabled(dto.getDisabled());
        professional.setFamiliarCatastrophicDiseased(dto.getFamiliarCatastrophicDiseased());//not null
        professional.setFamiliarDisabled(dto.getFamiliarDisabled());//not null
        professional.setIdentificationFamiliarDisabled(dto.getIdentificationFamiliarDisabled());
        professional.setTraveled(dto.getTraveled());//not null
        professional.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        professional.setUserId(userId);//not null
        return professional;
    }
}