package com.bolsaempleo.backend.app.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalDto;
import com.bolsaempleo.backend.app.dto.CompanyProfessionalResponseDto;
import com.bolsaempleo.backend.app.entities.job_board.CompanyProfessional;
import com.bolsaempleo.backend.app.repositories.CompanyProfessionalRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;


@Service
public class CompanyProfessionalServiceImpl implements CompanyProfessionalService{

    @Autowired
    private CompanyProfessionalRepository companyProfessionalRepository;

    @Override
    public List<CompanyProfessional> findAll() {
        return  (List<CompanyProfessional>) companyProfessionalRepository.findAll();
    }


    public CompanyProfessionalResponseDto findAllModel(){
        CompanyProfessionalResponseDto companyProfessionalResponseDto = new CompanyProfessionalResponseDto();
        List<CompanyProfessional> companyProfessionals = new ArrayList<>();
        try {
            //companyProfessionals = (List<CompanyProfessional>)companyProfessionalRepository.findAll();
            companyProfessionals = companyProfessionalRepository.findAllCompanyProfessional();
            List<CompanyProfessionalDto> companyProfessionalModelDto = new ArrayList<>();
            if (companyProfessionals.size()>0){
                for (CompanyProfessional c : companyProfessionals){
                    companyProfessionalModelDto.add(crearModelo(c));  
                }
                companyProfessionalResponseDto.setCode(ComunEnum.CORRECTO.toString());
                companyProfessionalResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                companyProfessionalResponseDto.setData(companyProfessionalModelDto);
            }else {
                companyProfessionalResponseDto.setCode(ComunEnum.RECURSOVACIO.toString());
                companyProfessionalResponseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            companyProfessionalResponseDto.setCode(ComunEnum.RECURSOVACIO.toString());
            companyProfessionalResponseDto.setMessage(ComunEnum.MENSAJESINDATOS.getDescripcion());
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return companyProfessionalResponseDto;
    }

    public CompanyProfessionalDto crearModelo(CompanyProfessional c){
        CompanyProfessionalDto companyProfessionalModelDto = new CompanyProfessionalDto();
        if (c.getId() != null){companyProfessionalModelDto.setId(c.getId().toString());}
        if (c.getCreatedAt() != null){companyProfessionalModelDto.setCreatedAt(c.getCreatedAt().toString());}
        if (c.getUpdatedAt() != null){companyProfessionalModelDto.setUpdatedAt(c.getUpdatedAt().toString());}
        if (c.getCompany().getId() != null){companyProfessionalModelDto.setCompany(c.getCompany().getId().toString());}
        if (c.getProfessional().getId() != null){companyProfessionalModelDto.setProfessional(c.getProfessional().getId().toString());}
        return companyProfessionalModelDto;
    }

}
