package com.rumah.kita.spring_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rumah.kita.spring_crud.models.Learn;

public interface LearnRepo extends JpaRepository<Learn, Long> {
    
}
