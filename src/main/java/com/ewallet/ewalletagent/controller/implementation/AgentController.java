package com.ewallet.ewalletagent.controller.implementation;
import com.ewallet.ewalletagent.controller.definition.IAgentController;
import com.ewallet.ewalletagent.dto.request.AgentRequestDto;
import com.ewallet.ewalletagent.dto.response.AgentResponseDto;
import com.ewallet.ewalletagent.entity.Agent;
import com.ewallet.ewalletagent.service.definition.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController implements IAgentController {

    private AgentService agentService;

    private AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @Override
    public ResponseEntity<List<AgentResponseDto>> allAgent()
    {
        var agent =  agentService.getAllAgent();
        return ResponseEntity.ok(agent);
    }

    @Override
    public ResponseEntity<AgentResponseDto> getAgent(Long id){
        var agent = agentService.findById(id);
        return ResponseEntity.ok(agent);
    }

    @Override
    public ResponseEntity<String> createAgent(AgentRequestDto agentRequestDto){
        agentService.createAgent(agentRequestDto);
        return new ResponseEntity<>("Agent Created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateAgent(Agent agent){
        Agent agents =  agentService.updateAgent(agent);
        return  ResponseEntity.ok("agent updated");
    }

    @Override
    public ResponseEntity<String> deleteAgent(String id){
        agentService.delete(id);
        return ResponseEntity.ok("agent deleted");
    }


}
