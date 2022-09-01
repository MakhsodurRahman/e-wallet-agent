package com.ewallet.ewalletagent.repository;

import com.ewallet.ewalletagent.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findByNidNumber(String nidNumber);
}
