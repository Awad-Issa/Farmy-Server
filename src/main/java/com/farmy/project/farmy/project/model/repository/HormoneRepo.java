package com.farmy.project.farmy.project.model.repository;

import com.farmy.project.farmy.project.model.entity.Hormone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HormoneRepo extends JpaRepository<Hormone, Long> {
}
