package com.ewallet.ewalletagent.controller.definition;
import com.ewallet.ewalletagent.dto.request.AgentRequestDto;
import com.ewallet.ewalletagent.dto.response.AgentResponseDto;
import com.ewallet.ewalletagent.entity.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/agent")
public interface IAgentController {

    @GetMapping("/agent")
    public ResponseEntity<List<AgentResponseDto>> allAgent();

    @GetMapping("/{id}")
    public ResponseEntity<AgentResponseDto> getAgent(@PathVariable Long id);

    @PostMapping("/agent")
    public ResponseEntity<String> createAgent(@RequestBody AgentRequestDto agentRequestDto);

    @PutMapping("/agent")
    public ResponseEntity<String> updateAgent(@RequestBody Agent agent);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable String id);
}
