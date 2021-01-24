package com.smartchoice.product.service.impl;

import com.smartchoice.common.dto.AuditLogDto;
import com.smartchoice.common.service.AuditLogService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AuditLogSenderServiceImpl implements AuditLogService {
    private JmsTemplate jmsTemplate;

    public AuditLogSenderServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    @Async("auditLogExecutor")
    public void log(AuditLogDto logDto) {
        jmsTemplate.convertAndSend("audit-logs", logDto);
    }
}
