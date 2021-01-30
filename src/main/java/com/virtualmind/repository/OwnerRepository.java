package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Owner;
import com.virtualmind.domain.Topic;

@Component("ownerRepository")
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

}
