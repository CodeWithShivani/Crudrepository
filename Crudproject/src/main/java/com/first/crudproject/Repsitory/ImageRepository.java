package com.first.crudproject.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.crudproject.entities.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

}
