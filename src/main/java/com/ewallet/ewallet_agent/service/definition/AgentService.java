package com.ewallet.ewallet_agent.service.definition;
import com.ewallet.ewallet_agent.dto.request.AgentRequestDto;
import com.ewallet.ewallet_agent.dto.response.AgentResponseDto;
import com.ewallet.ewallet_agent.entity.Agent;

import java.util.List;

public interface AgentService {

    public Agent createAgent(AgentRequestDto agentReqDto);
    public List<AgentResponseDto> getAllAgent();
    public AgentResponseDto findById(String id);
    public Agent updateAgent(Agent agent);
    public void delete(String id);
    public AgentResponseDto entityToDto(Agent agent);
    public Agent dtoToEntity(AgentRequestDto agentReqDto);
}
