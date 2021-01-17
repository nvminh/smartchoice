package com.smartchoice.product.service.impl;

import com.smartchoice.product.entity.AuditLog;
import com.smartchoice.product.entity.LogEvent;
import com.smartchoice.product.repository.AuditLogRepository;
import com.smartchoice.product.service.AuditLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogServiceImpl.class);
    private AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    @Async("auditLogExecutor")
    public void log(LogEvent event, String source, String log) {
        logger.info("add an event log for auditing, event: {}, source {}", event, source);
        auditLogRepository.save(new AuditLog(event, source, log));
    }

    @Override
    public List<AuditLog> findTop() {
        return auditLogRepository.findTop10ByEventOrderByTimestampDesc(LogEvent.CUSTOMER_SEARCH);
    }
}
