package com.ravi.dao;


import com.ravi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressDao  extends JpaRepository<Address,Integer> {
    Optional<Address> findById(Integer id);
}
