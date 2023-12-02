package com.chanchal.optionstradeservice.repository;

import com.chanchal.optionstradeservice.bo.OptionsTradesBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsTradeRepository extends JpaRepository<OptionsTradesBO, Long> {

}
