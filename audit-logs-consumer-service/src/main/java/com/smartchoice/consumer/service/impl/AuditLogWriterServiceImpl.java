package com.smartchoice.consumer.service.impl;

import com.smartchoice.common.dto.AuditLogDto;
import com.smartchoice.common.service.AuditLogService;
import com.smartchoice.consumer.entity.AuditLog;
import com.smartchoice.consumer.repository.AuditLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuditLogWriterServiceImpl implements AuditLogService {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogWriterServiceImpl.class);
    private AuditLogRepository auditLogRepository;


    public AuditLogWriterServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void log(AuditLogDto logDto) {
        logger.info("add an event log for auditing, event: {}, source {}", logDto.getEvent(), logDto.getSource());
        auditLogRepository.save(new AuditLog(logDto.getEvent(), logDto.getSource(), logDto.getLog()));
    }

}
