package com.ewallet.ewalletagent.service.implemention;
import com.common_service.enums.Gender;
import com.common_service.enums.Role;
import com.common_service.enums.Status;
import com.common_service.exceptions.NotFoundException;
import com.ewallet.ewalletagent.dto.request.AgentRequestDto;
import com.ewallet.ewalletagent.dto.response.AgentResponseDto;
import com.ewallet.ewalletagent.entity.Agent;
import com.ewallet.ewalletagent.repository.AgentRepository;
import com.ewallet.ewalletagent.service.definition.AgentService;
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
    public Agent createAgent(AgentRequestDto agentRequestDto) {

        Agent agent = new Agent();

        if(findByNidNumber(agentRequestDto.getNidNumber()) == null){
            BeanUtils.copyProperties(agentRequestDto,agent);
            var birthDay = LocalDateTime.parse(agentRequestDto.getBirthDate());
            agent.setBirthDate(LocalDate.from(birthDay));
            agent.setRole(Role.ROLE_AGENT);
            agent.setStatus(Status.INACTIVE);
            agent.setGender(Gender.valueOf(agentRequestDto.getGender()));

            agentRepository.save(agent);
            return agent;
        }

       return null;
    }

    @Override
    public List<AgentResponseDto> getAllAgent(){
        List<Agent> agentList = agentRepository.findAll();

        var resAgentList = new ArrayList<AgentResponseDto>();

        for(Agent agent: agentList){
            var resAgent = new AgentResponseDto();
            BeanUtils.copyProperties(agent,resAgent);

            resAgent.setBirthDate(agent.getBirthDate().toString());
            resAgent.setRole(Role.ROLE_AGENT.toString());
            resAgent.setStatus(agent.getStatus().toString());
            resAgent.setGender(agent.getGender().toString());
            resAgentList.add(resAgent);
        }

        return resAgentList;
    }

        @Override
        public AgentResponseDto findById(Long id){
            var agent = agentRepository.findById(id).orElseThrow(()-> new NotFoundException(id + " not found"));
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
        //agentResponse.setStatus(agent.getStatus().toString());
        agentResponse.setStatus(agent.getStatus().toString());
        agentResponse.setGender(agent.getGender().toString());

        return agentResponse;

    }

    @Override
    public Agent dtoToEntity(AgentRequestDto agentRequestDto){

        Agent agent = new Agent();
        BeanUtils.copyProperties(agentRequestDto,agent);
        var birthDay = LocalDateTime.parse(agentRequestDto.getBirthDate());
        agent.setBirthDate(LocalDate.from(birthDay));
        agent.setRole(Role.ROLE_AGENT);
        agent.setGender(Gender.valueOf(agentRequestDto.getGender()));

        return agent;
    }

    @Override
    public Agent findByNidNumber(String nidNumber) {
        Agent agent = agentRepository.findByNidNumber(nidNumber);
        return agent;
    }


}
