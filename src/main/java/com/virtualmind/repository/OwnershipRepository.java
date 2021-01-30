package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Ownership;

@Component("ownershipRepository")
public interface OwnershipRepository extends CrudRepository<Ownership, Integer> {

}
