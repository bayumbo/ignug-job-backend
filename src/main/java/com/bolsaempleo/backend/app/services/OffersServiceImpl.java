package com.bolsaempleo.backend.app.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaempleo.backend.app.dto.OfferResponseDto;
import com.bolsaempleo.backend.app.dto.OfferDto;
import com.bolsaempleo.backend.app.entities.job_board.Offer;
import com.bolsaempleo.backend.app.repositories.OffersRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;

@Service
public class OffersServiceImpl implements OfferService{

    @Autowired
    private OffersRepository offersRepository;



    @Override
    @Transactional(readOnly = true )
    public OfferResponseDto findAll() {
        List<Offer> offers = offersRepository.findAll().stream()
                .filter(offer -> offer.getDeletedAt() == null)
                .collect(Collectors.toList());

        List<OfferDto> offerDtos = offers.stream()
                .map(this::toOfferDto)
                .collect(Collectors.toList());
        return createResponseDto(offerDtos, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private OfferResponseDto createResponseDto(List<OfferDto> data, String code, String message) {
        OfferResponseDto responseDto = new OfferResponseDto();
        responseDto.setCode(code);
        responseDto.setMessage(message);
        responseDto.setData(data);
        return responseDto;
    }
    private OfferDto toOfferDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setActivities(offer.getActivities());
        dto.setAdditionalInformation(offer.getAdditionalInformation());
        dto.setCode(offer.getCode());
        dto.setContactCellphone(offer.getContactCellphone());
        dto.setContactEmail(offer.getContactEmail());
        dto.setContactName(offer.getContactName());
        dto.setContactPhone(offer.getContactPhone());
        dto.setContractTypeId(offer.getContractTypeId());
        dto.setCreatedAt(offer.getCreatedAt());
        dto.setCode(offer.getCode());
        dto.setDeletedAt(offer.getDeletedAt());
        dto.setEndedAt(offer.getEndedAt());
        dto.setExperienceTimeId(offer.getExperienceTimeId());
        dto.setLocationId(offer.getLocationId());
        dto.setPosition(offer.getPosition());
        dto.setRemuneration(offer.getRemuneration());
        dto.setRequirements(offer.getRequirements());
        dto.setSectorId(offer.getSectorId());
        dto.setStartedAt(offer.getStartedAt());
        dto.setStateId(offer.getStateId());
        dto.setTrainingHoursId(offer.getTrainingHoursId());
        dto.setUpdatedAt(offer.getUpdatedAt());
        dto.setVacancies(offer.getVacancies());
        dto.setWorkingDayId(offer.getWorkingDayId());
        dto.setCompany(offer.getCompany());
        return dto;
    }

    
    @Override
    public OfferResponseDto findById(UUID id) {
        Offer offer = offersRepository.findById(id)
                .filter(loc -> loc.getDeletedAt() == null)
                .orElse(null);

        if (offer == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }
        return createResponseDto(List.of(toOfferDto(offer)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }


    @Override
    public OfferResponseDto save(OfferDto offerDto) {
        Offer offer = toOffer(offerDto);
        offer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Offer savedOffer = offersRepository.save(offer);
        return createResponseDto(List.of(toOfferDto(savedOffer)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private Offer toOffer(OfferDto dto) {
        Offer offer = new Offer();
        dto.setActivities(offer.getActivities());
        dto.setAdditionalInformation(offer.getAdditionalInformation());
        dto.setCode(offer.getCode());
        dto.setContactCellphone(offer.getContactCellphone());
        dto.setContactEmail(offer.getContactEmail());
        dto.setContactName(offer.getContactName());
        dto.setContactPhone(offer.getContactPhone());
        dto.setContractTypeId(offer.getContractTypeId());
        dto.setCreatedAt(offer.getCreatedAt());
        dto.setCode(offer.getCode());
        dto.setDeletedAt(offer.getDeletedAt());
        dto.setEndedAt(offer.getEndedAt());
        dto.setExperienceTimeId(offer.getExperienceTimeId());
        dto.setLocationId(offer.getLocationId());
        dto.setPosition(offer.getPosition());
        dto.setRemuneration(offer.getRemuneration());
        dto.setRequirements(offer.getRequirements());
        dto.setSectorId(offer.getSectorId());
        dto.setStartedAt(offer.getStartedAt());
        dto.setStateId(offer.getStateId());
        dto.setTrainingHoursId(offer.getTrainingHoursId());
        dto.setUpdatedAt(offer.getUpdatedAt());
        dto.setVacancies(offer.getVacancies());
        dto.setWorkingDayId(offer.getWorkingDayId());
        dto.setCompany(offer.getCompany());
        return offer;
    }
    @Override
    public OfferResponseDto update(UUID id, OfferDto offerDto) {
        Offer offer = offersRepository.findById(id)
                .filter(loc -> loc.getDeletedAt() == null)
                .orElse(null);

        if (offer == null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        updateLocationFromDto(offerDto, offer);
        offer.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Offer updatedOffer = offersRepository.save(offer);

        return createResponseDto(List.of(toOfferDto(updatedOffer)), ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }

    private void updateLocationFromDto(OfferDto dto, Offer offer) {
        dto.setActivities(offer.getActivities());
        dto.setAdditionalInformation(offer.getAdditionalInformation());
        dto.setCode(offer.getCode());
        dto.setContactCellphone(offer.getContactCellphone());
        dto.setContactEmail(offer.getContactEmail());
        dto.setContactName(offer.getContactName());
        dto.setContactPhone(offer.getContactPhone());
        dto.setContractTypeId(offer.getContractTypeId());
        dto.setCreatedAt(offer.getCreatedAt());
        dto.setCode(offer.getCode());
        dto.setDeletedAt(offer.getDeletedAt());
        dto.setEndedAt(offer.getEndedAt());
        dto.setExperienceTimeId(offer.getExperienceTimeId());
        dto.setLocationId(offer.getLocationId());
        dto.setPosition(offer.getPosition());
        dto.setRemuneration(offer.getRemuneration());
        dto.setRequirements(offer.getRequirements());
        dto.setSectorId(offer.getSectorId());
        dto.setStartedAt(offer.getStartedAt());
        dto.setStateId(offer.getStateId());
        dto.setTrainingHoursId(offer.getTrainingHoursId());
        dto.setUpdatedAt(offer.getUpdatedAt());
        dto.setVacancies(offer.getVacancies());
        dto.setWorkingDayId(offer.getWorkingDayId());
        dto.setCompany(offer.getCompany());
    }

    @Override
    public OfferResponseDto deleteById(UUID id) {
        Offer offer = offersRepository.findById(id).orElse(null);

        if (offer == null || offer.getDeletedAt() != null) {
            return createResponseDto(null, ComunEnum.RECURSOVACIO.toString(), ComunEnum.MENSAJESINDATOS.getDescripcion());
        }

        offer.setDeletedAt(new Timestamp(System.currentTimeMillis()));
        offersRepository.save(offer);
        return createResponseDto(null, ComunEnum.CORRECTO.toString(), ComunEnum.MENSAJECORRECTO.getDescripcion());
    }




    
}
