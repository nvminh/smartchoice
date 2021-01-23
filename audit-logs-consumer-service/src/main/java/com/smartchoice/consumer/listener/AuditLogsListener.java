package com.smartchoice.consumer.listener;

import com.smartchoice.common.dto.AuditLogDto;
import com.smartchoice.consumer.entity.AuditLog;
import com.smartchoice.consumer.repository.AuditLogRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogsListener {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogsListener.class);

    private AuditLogRepository auditLogRepository;
    private ModelMapper modelMapper;

    public AuditLogsListener(AuditLogRepository auditLogRepository, ModelMapper modelMapper) {
        this.auditLogRepository = auditLogRepository;
        this.modelMapper = modelMapper;
    }

    @JmsListener(destination = "audit-logs", containerFactory = "myFactory")
    public void receiveMessage(AuditLogDto log) {
        logger.info("Received <" + log + ">");
        auditLogRepository.save(modelMapper.map(log, AuditLog.class));
    }
}
