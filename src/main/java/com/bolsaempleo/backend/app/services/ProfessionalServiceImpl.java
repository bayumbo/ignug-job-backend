package com.bolsaempleo.backend.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsaempleo.backend.app.dto.ProfessionalDto;
import com.bolsaempleo.backend.app.entities.job_board.Professional;
import com.bolsaempleo.backend.app.repositories.ProfessionalRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ProfessionalServiceImpl implements ProfessionalService{

    @Autowired
    private ProfessionalRepository professionalsRepository;

    @Override
    @Transactional(readOnly = true )
    public List<Professional> findAll() {
        return (List<Professional>) professionalsRepository.findAll();
    }
 
    @Override
    @Transactional(readOnly = true )
    public Optional<Professional> findById(Long Id) {
        return professionalsRepository.findById(Id);
    }

    @Override
    @Transactional(readOnly = true )
    public ProfessionalDto findByIdDto (Long id){//
        Optional<Professional> professionalsFinded = professionalsRepository.findById(id);
        ProfessionalDto professionalsDto = new ProfessionalDto();
     
            if (professionalsFinded.isEmpty()){
                throw new EntityNotFoundException("Error");
            }
            
            professionalsDto.setAboutMe(professionalsFinded.get().getAboutMe());
            professionalsDto.setIdentificationFamiliarDisabled(professionalsFinded.get().getIdentificationFamiliarDisabled());
            Date date=new Date(professionalsFinded.get().getCreatedAt().getTime());  
            professionalsDto.setCreatedAt(date.toString());
            //professionalsDto.setCreatedAt(professionalsFinded.get().getCreatedAt().toString());
            professionalsDto.setDeletedAt(professionalsFinded.get().getDeletedAt()+"");
            professionalsDto.setUpdatedAt(professionalsFinded.get().getUpdatedAt().toString());
            professionalsDto.setCatastrophicDiseased(professionalsFinded.get().getCatastrophicDiseased());
            professionalsDto.setFamiliarCatastrophicDiseased(professionalsFinded.get().getFamiliarCatastrophicDiseased());
            professionalsDto.setFamiliarDisabled(professionalsFinded.get().getFamiliarDisabled());
            professionalsDto.setTraveled(professionalsFinded.get().getTraveled());
       
        return professionalsDto;
    }

    @Override
    @Transactional
    public void remove(Long id) {
        professionalsRepository.deleteById(id);;
    }

    @Override
    @Transactional
    public Professional save(Professional professional) {
        return professionalsRepository.save(professional);
    }

    @Override
    @Transactional
    public Optional<Professional> update(Professional professional, Long id) {
        Optional<Professional> obj = this.findById(id);
        if (obj.isPresent()){
            Professional professionalsDb = obj.orElseThrow();
            professionalsDb.setAboutMe(professional.getAboutMe());
            return Optional.of(this.save(professionalsDb));

        }
        return Optional.empty();
    }
}
