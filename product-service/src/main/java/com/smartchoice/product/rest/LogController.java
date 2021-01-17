package com.smartchoice.product.rest;

import com.smartchoice.product.entity.AuditLog;
import com.smartchoice.product.service.AuditLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")

public class LogController {

    private AuditLogService logService;
    public LogController(AuditLogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getLogs() {
        return ResponseEntity.ok(logService.findTop());
    }
}
