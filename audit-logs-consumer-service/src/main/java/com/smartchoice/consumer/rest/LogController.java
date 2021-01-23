package com.smartchoice.consumer.rest;

import com.smartchoice.common.dto.AuditLogDto;
import com.smartchoice.common.dto.LogEvent;
import com.smartchoice.consumer.repository.AuditLogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/logs")

public class LogController {

    private AuditLogRepository logRepository;
    private ModelMapper modelMapper;

    public LogController(AuditLogRepository logRepository, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity<List<AuditLogDto>> getLogs() {
        return ResponseEntity.ok(logRepository.findTop10ByEventOrderByTimestampDesc(LogEvent.CUSTOMER_SEARCH)
                .stream().map(i->modelMapper.map(i, AuditLogDto.class)).collect(Collectors.toList()));
    }
}
