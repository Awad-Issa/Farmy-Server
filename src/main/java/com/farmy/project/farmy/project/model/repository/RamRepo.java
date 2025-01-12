package com.farmy.project.farmy.project.model.repository;

import com.farmy.project.farmy.project.model.entity.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RamRepo extends JpaRepository<Ram, Long> {


    Optional<Ram> findByNum(long num);

    Ram findById(Optional<Ram> ram);
}
