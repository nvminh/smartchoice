package com.smartchoice.consumer.listener;

import com.smartchoice.common.dto.AuditLogDto;
import com.smartchoice.consumer.entity.AuditLog;
import com.smartchoice.consumer.repository.AuditLogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogsListener {
    private AuditLogRepository auditLogRepository;
    private ModelMapper modelMapper;

    public AuditLogsListener(AuditLogRepository auditLogRepository, ModelMapper modelMapper) {
        this.auditLogRepository = auditLogRepository;
        this.modelMapper = modelMapper;
    }

    @JmsListener(destination = "audit-logs", containerFactory = "myFactory")
    public void receiveMessage(AuditLogDto log) {
        System.out.println("Received <" + log + ">");
        auditLogRepository.save(modelMapper.map(log, AuditLog.class));
    }
}
