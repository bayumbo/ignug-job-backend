package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsaempleo.backend.app.dto.OfferResponseDto;
import com.bolsaempleo.backend.app.dto.OffersDto;
import com.bolsaempleo.backend.app.entities.job_board.Offer;
import com.bolsaempleo.backend.app.repositories.OffersRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

@Service
public class OffersServiceImpl implements OfferService{

    @Autowired
    private OffersRepository offersRepository;


    @Override
    @Transactional(readOnly = true )
    public OfferResponseDto findAllDto(){
        OfferResponseDto offerResponseDto = new OfferResponseDto();
        List<Offer> offers = offersRepository.findAllOffers();
        List<OffersDto> offersDto = new ArrayList<>();
        try {
            if (offers.size()>0){
                for (Offer o : offers){
                    offersDto.add(crearModelo(o));
                }
                offerResponseDto.setCode(ComunEnum.CORRECTO.toString());
                offerResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
                offerResponseDto.setData(offersDto);      
            }else{
                offerResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                offerResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return offerResponseDto;
    } 

    public OffersDto crearModelo (Offer offer){
        OffersDto offersDto = new OffersDto();
        if (offer.getActivities() != null){offersDto.setActivities(offer.getActivities());}
        if (offer.getAdditionalInformation() != null){offersDto.setAdditionalInformation(offer.getAdditionalInformation());}
        if (offer.getCode() != null){offersDto.setCode(offer.getCode());}
        if (offer.getContactCellphone() != null){offersDto.setContactCellphone(offer.getContactCellphone());}
        if (offer.getContactEmail() != null){offersDto.setContactEmail(offer.getContactEmail());}
        if (offer.getContactName() != null){offersDto.setContactName(offer.getContactName());}
        if (offer.getContactPhone() != null){offersDto.setContactPhone(offer.getContactPhone());}
        if (offer.getContractTypeId() != null){offersDto.setContractTypeId(offer.getContractTypeId());}
        if (offer.getCreatedAt() != null){offersDto.setCreatedAt(offer.getCreatedAt());}
        if (offer.getDeletedAt() != null){offersDto.setDeletedAt(offer.getDeletedAt());}
        if (offer.getEndedAt() != null){offersDto.setEndedAt(offer.getEndedAt());}
        if (offer.getExperienceTimeId() != null){offersDto.setExperienceTimeId(offer.getExperienceTimeId());}
        if (offer.getLocationId() != null){offersDto.setLocationId(offer.getLocationId());}
        if (offer.getPosition() != null){offersDto.setPosition(offer.getPosition());}
        if (offer.getRemuneration() != null){offersDto.setRemuneration(offer.getRemuneration());}
        if (offer.getRequirements() != null){offersDto.setRequirements(offer.getRequirements());}
        if (offer.getSectorId() != null){offersDto.setSectorId(offer.getSectorId());}
        if (offer.getStartedAt() != null){offersDto.setStartedAt(offer.getStartedAt());}
        if (offer.getStateId() != null){offersDto.setStateId(offer.getStateId());}
        if (offer.getTrainingHoursId() != null){offersDto.setTrainingHoursId(offer.getTrainingHoursId());}
        if (offer.getUpdatedAt() != null){offersDto.setUpdatedAt(offer.getUpdatedAt());}
        if (offer.getVacancies() != null){offersDto.setVacancies(offer.getVacancies());}
        if (offer.getWorkingDayId() != null){offersDto.setWorkingDayId(offer.getWorkingDayId());}
        if (offer.getCompany() != null){offersDto.setCompany(offer.getCompany());}
        return offersDto;
    }
    
}
