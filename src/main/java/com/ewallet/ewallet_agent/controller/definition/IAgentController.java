package com.ewallet.ewallet_agent.controller.definition;
import com.ewallet.ewallet_agent.dto.request.AgentRequestDto;
import com.ewallet.ewallet_agent.dto.response.AgentResponseDto;
import com.ewallet.ewallet_agent.entity.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/agent/")
public interface IAgentController {

    @GetMapping("agent")
    public ResponseEntity<List<AgentResponseDto>> allAgent();

    @GetMapping("{id}")
    public ResponseEntity<AgentResponseDto> getAgent(@PathVariable String id);

    @PostMapping("agent")
    public ResponseEntity<String> createAgent(@RequestBody AgentRequestDto agentReqDto);

    @PutMapping("/agent")
    public ResponseEntity<String> updateAgent(@RequestBody Agent agent);

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable String id);
}
