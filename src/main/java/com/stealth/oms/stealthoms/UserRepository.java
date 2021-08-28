package com.stealth.oms.stealthoms;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stealth.oms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}