package com.rumah.kita.spring_crud.services;

import java.util.List;
import java.util.Optional;

import com.rumah.kita.spring_crud.dtos.LearnDTO;

public interface LearnServices {

    // get all - list data
    List<LearnDTO.ResponseLearnDTO> getAll();
    // save data
    LearnDTO.ResponseLearnDTO save(LearnDTO.RequestLearnDTO req);
    // update data
    Optional<LearnDTO.ResponseLearnDTO> update(Long id, LearnDTO.RequestLearnDTO req);
    // delete data
    int delete(Long id);

}
