package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsaempleo.backend.app.dto.CatalogueDto;
import com.bolsaempleo.backend.app.dto.CatalogueResponseDto;
import com.bolsaempleo.backend.app.entities.core.Catalogue;
import com.bolsaempleo.backend.app.repositories.CatalogueRepository;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.bolsaempleo.backend.app.utility.FechasUtil;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;
    
    @Override
    public List<Catalogue> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Catalogue> findById(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Catalogue save(Catalogue catalogue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Catalogue> update(Catalogue catalogue, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void remove(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    @Transactional(readOnly = true )
    public CatalogueResponseDto findByTypeDes (String type){
        CatalogueResponseDto catalogueResponseDto = new CatalogueResponseDto();
        List<CatalogueDto> catalogueDto = new ArrayList<>();
        try {
            List<Catalogue> catalogues = catalogueRepository.findByTypeDescription(type);        
            if (catalogues != null){
                for( Catalogue c : catalogues){
                    catalogueDto.add(crearModelo(c));
                }
                catalogueResponseDto.setCode(ComunEnum.CORRECTO.toString());
                catalogueResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.toString());
                catalogueResponseDto.setData(catalogueDto);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return catalogueResponseDto;
    }
     

    @Override
    @Transactional(readOnly = true )
    public CatalogueResponseDto findByIdDto(Long Id) {
        CatalogueResponseDto catalogueResponseDto = new CatalogueResponseDto();
        try {
            Catalogue catalogue = catalogueRepository.findCatalogueById(Id);
          if (catalogue != null){
            catalogueResponseDto.setCode(ComunEnum.CORRECTO.toString());
            catalogueResponseDto.setMessage(ComunEnum.MENSAJECORRECTO.getDescripcion());
            catalogueResponseDto.setData(crearModelo(catalogue));
          }else{
            catalogueResponseDto.setCode(ComunEnum.INCORRECTO.toString());
            catalogueResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
          }
        } catch (Exception e) {
            catalogueResponseDto.setCode(ComunEnum.ERRORINTERNOSERVIDOR.toString());
            catalogueResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
        }
        return catalogueResponseDto;
    }
    public CatalogueDto crearModelo(Catalogue c){
        CatalogueDto catalogueDto= new CatalogueDto();
        if (c.getName() != null){catalogueDto.setName(c.getName().toString());}
        if (c.getType() != null){catalogueDto.setType(c.getType().toString());}
        if (c.getCode() != null){catalogueDto.setCode(c.getCode().toString());}
        if (c.getColor() != null){catalogueDto.setColor(c.getColor().toString());}
        if (c.getCreatedAt() != null){catalogueDto.setCreatedAt(c.getCreatedAt().toString());}
        if (c.getDeletedAt() != null){catalogueDto.setDeletedAt(c.getDeletedAt().toString());}
        if (c.getUpdatedAt() != null){catalogueDto.setUpdatedAt(c.getUpdatedAt().toString());}
        if (c.getIcon() != null){catalogueDto.setIcon(c.getIcon().toString());}
        if (c.getDescription() != null){catalogueDto.setDescription(c.getDescription().toString());}
        if (c.getCatalogue() != null){catalogueDto.setCatalogue(c.getCatalogue().getId().toString());}
        return catalogueDto;
    }

    public CatalogueResponseDto saveCatalogue (CatalogueDto catalogueDto){
        CatalogueResponseDto catalogueResponseDto = new  CatalogueResponseDto();
        try {
            catalogueResponseDto.setData(crearModelo(catalogueRepository.save(crearObjeto(catalogueDto))));
            if (catalogueResponseDto.getData()!= null){
                catalogueResponseDto.setCode(ComunEnum.RECURSOCREADO.toString());
                catalogueResponseDto.setMessage(ComunEnum.MENSAJERECURSOCREADO.getDescripcion());
            }
            else{
                catalogueResponseDto.setCode(ComunEnum.INCORRECTO.toString());
                catalogueResponseDto.setMessage(ComunEnum.MENSAJEINCORRECTO.getDescripcion());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return catalogueResponseDto;
    }

    public Catalogue crearObjeto(CatalogueDto c){
        Catalogue catalogue = new Catalogue();
        if(c.getType() != null){catalogue.setType(c.getType());}
        if(c.getName() != null){catalogue.setName(c.getName());}
        if(c.getIcon() != null){catalogue.setIcon(c.getIcon());}
        if(c.getDescription() != null){catalogue.setDescription(c.getDescription());}
        if(c.getColor() != null){catalogue.setColor(c.getColor());}
        if(c.getCode() != null){catalogue.setCode(c.getCode());}
        if(c.getCreatedAt() != null){catalogue.setCreatedAt(FechasUtil.getFechaTimestamp());}
        if(c.getUpdatedAt() != null){catalogue.setUpdatedAt(FechasUtil.getFechaTimestamp());}
        if(c.getDeletedAt() != null){catalogue.setDeletedAt(null);}
        if(c.getCatalogue() != null){catalogue.setCatalogue(null);}
        return catalogue;
    }

}
