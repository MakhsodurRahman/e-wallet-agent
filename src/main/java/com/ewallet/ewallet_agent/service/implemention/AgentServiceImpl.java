package com.ewallet.ewallet_agent.service.implemention;
import com.ewallet.ewallet_agent.dto.request.AgentRequestDto;
import com.ewallet.ewallet_agent.dto.response.AgentResponseDto;
import com.ewallet.ewallet_agent.entity.Agent;
import com.ewallet.ewallet_agent.enums.Gender;
import com.ewallet.ewallet_agent.enums.Role;
import com.ewallet.ewallet_agent.exceptions.AgentNotFoundException;
import com.ewallet.ewallet_agent.repository.AgentRepository;
import com.ewallet.ewallet_agent.service.definition.AgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    private AgentRepository agentRepository;

    AgentServiceImpl(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }


    @Override
    public Agent createAgent(AgentRequestDto agentReqDto) {
        Agent agent = new Agent();

        BeanUtils.copyProperties(agentReqDto,agent);
        agentRepository.save(agent);
        return agent;
    }

    @Override
    public List<AgentResponseDto> getAllAgent(){
        List<Agent> agentList = agentRepository.findAll();

        var resAgentList = new ArrayList<AgentResponseDto>();

        for(Agent agent: agentList){
            var resAgent = new AgentResponseDto();
            BeanUtils.copyProperties(agent,resAgent);
            resAgentList.add(resAgent);
        }

        return resAgentList;
    }

        @Override
        public AgentResponseDto findById(String id){
            var agent = agentRepository.findById(Long.parseLong(id)).orElseThrow(()-> new AgentNotFoundException("no found"));
//            var resAgent = new AgentResponseDto();
//            BeanUtils.copyProperties(agent,resAgent);
//            var resAgent = entityToDto(agent);
            return entityToDto(agent);
        }

    @Override
    public Agent updateAgent(Agent agent) {
        agentRepository.save(agent);
        return agent;
    }

    @Override
    public void delete(String id) {
        agentRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public AgentResponseDto entityToDto(Agent agent){

        var agentResponse = new AgentResponseDto();
        BeanUtils.copyProperties(agent,agentResponse);
        agentResponse.setBirthDate(agent.getBirthDate().toString());
        agentResponse.setRole(Role.ROLE_AGENT.toString());
        agentResponse.setStatus(agent.getStatus().toString());
        agentResponse.setGender(agent.getGender().toString());

        return agentResponse;

    }

    @Override
    public Agent dtoToEntity(AgentRequestDto agentReqDto){

        Agent agent = new Agent();
        BeanUtils.copyProperties(agentReqDto,agent);
        var birthDay = LocalDateTime.parse(agentReqDto.getBirthDate());
        agent.setBirthDate(LocalDate.parse(agentReqDto.getBirthDate().toString()));
        agent.setRole(Role.ROLE_AGENT);
        agent.setGender(Gender.valueOf(agentReqDto.getGender()));

        return agent;
    }


}
