package com.first.crudproject.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;


import com.first.crudproject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}




