package com.farmy.project.farmy.project.model.repository;

import com.farmy.project.farmy.project.model.entity.Ewe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EweRepo extends JpaRepository<Ewe, Long> {


    Optional<Ewe> findByNum(long num);
}
