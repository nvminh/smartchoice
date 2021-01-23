package com.smartchoice.common.service;

import com.smartchoice.common.dto.AuditLogDto;

public interface AuditLogService {
    void log(AuditLogDto logDto);
}
