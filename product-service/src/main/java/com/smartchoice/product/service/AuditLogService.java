package com.smartchoice.product.service;

import com.smartchoice.product.entity.AuditLog;
import com.smartchoice.product.entity.LogEvent;

import java.util.List;

public interface AuditLogService {
    void log(LogEvent event, String source, String log);
    List<AuditLog> findTop();
}
