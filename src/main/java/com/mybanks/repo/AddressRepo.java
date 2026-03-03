package com.mybanks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybanks.dto.Address;



public interface AddressRepo extends JpaRepository<Address, Integer>{

}
