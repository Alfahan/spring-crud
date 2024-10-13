package com.rumah.kita.spring_crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumah.kita.spring_crud.dtos.LearnDTO.RequestLearnDTO;
import com.rumah.kita.spring_crud.dtos.LearnDTO.ResponseLearnDTO;
import com.rumah.kita.spring_crud.services.LearnServices;

@RestController
@RequestMapping(value = "/learn")
public class LearnController {

    @Autowired
    private LearnServices learnServices;
    
    @GetMapping(value = "/get")
    public List<ResponseLearnDTO> getAll() {
        return learnServices.getAll();
    }

    @PostMapping(value = "/save")
    public ResponseLearnDTO save(@RequestBody RequestLearnDTO req) {
        return learnServices.save(req);
    }

    @PutMapping(value = "/update/{id}")
    public Optional<ResponseLearnDTO> update(@PathVariable(value = "id") Long id, @RequestBody RequestLearnDTO req) {
        return learnServices.update(id, req);
    }

    @DeleteMapping(value = "/delete/{id}")
    public int delete(@PathVariable(value = "id") Long id) {
        return learnServices.delete(id);
    }
    
}
