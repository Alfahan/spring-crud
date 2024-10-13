package com.rumah.kita.spring_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumah.kita.spring_crud.dtos.LearnDTO;
import com.rumah.kita.spring_crud.dtos.LearnDTO.RequestLearnDTO;
import com.rumah.kita.spring_crud.dtos.LearnDTO.ResponseLearnDTO;
import com.rumah.kita.spring_crud.models.Learn;
import com.rumah.kita.spring_crud.repositories.LearnRepo;

@Service
public class LearnServiceImpl implements LearnServices {

    @Autowired
    private LearnRepo learnRepo;

    public List<ResponseLearnDTO> getAll() {
        List<Learn> proccessData = learnRepo.findAll();
        List<ResponseLearnDTO> responseLearnList = new ArrayList<>();
        proccessData.forEach(getData -> {
            ResponseLearnDTO data = ResponseLearnDTO.builder()
                    .id(getData.getId())
                    .firstName(getData.getFirstName()) 
                    .lastName(getData.getFirstName())
                    .build();
            responseLearnList.add(data);
        });
        return responseLearnList;
    }

    public ResponseLearnDTO save(RequestLearnDTO req) {
        Learn requestData = Learn.builder()
            .firstName(req.getFirstName())
            .lastName(req.getLastName())
            .build();
        Learn returnData = learnRepo.save(requestData);
        return LearnDTO.ResponseLearnDTO.builder()
                    .id(returnData.getId())
                    .firstName(returnData.getFirstName())
                    .lastName(returnData.getLastName())
                    .build();
    }

    public Optional<ResponseLearnDTO> update(Long id, RequestLearnDTO req) {
        Optional<Learn> getDatLearnById = learnRepo.findById(id);
        getDatLearnById.get().setFirstName(req.getFirstName());
        getDatLearnById.get().setLastName(req.getLastName());
        Learn save = learnRepo.save(getDatLearnById.get());
        return Optional.ofNullable(
                ResponseLearnDTO.builder() 
                    .id(save.getId())
                    .firstName(save.getFirstName())
                    .lastName(save.getLastName())
                    .build());
    }

    public int delete(Long id) {
        learnRepo.deleteById(id);
        return 0;
    }
    
}
