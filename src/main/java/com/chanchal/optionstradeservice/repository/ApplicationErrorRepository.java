package com.chanchal.optionstradeservice.repository;

import com.chanchal.optionstradeservice.bo.ApplicationErrorBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationErrorRepository extends JpaRepository<ApplicationErrorBO, Long> {
}
