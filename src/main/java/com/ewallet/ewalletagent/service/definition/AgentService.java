package com.ewallet.ewalletagent.service.definition;
import com.ewallet.ewalletagent.dto.request.AgentRequestDto;
import com.ewallet.ewalletagent.dto.response.AgentResponseDto;
import com.ewallet.ewalletagent.entity.Agent;

import java.util.List;


public interface AgentService {

    public Agent createAgent(AgentRequestDto agentReqDto);
    public List<AgentResponseDto> getAllAgent();
    public AgentResponseDto findById(Long id);
    public Agent updateAgent(Agent agent);
    public void delete(String id);
    public AgentResponseDto entityToDto(Agent agent);
    public Agent dtoToEntity(AgentRequestDto agentReqDto);

    public Agent findByNidNumber(String nidNumber);
}
