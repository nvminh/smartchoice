package com.smartchoice.consumer.repository;

import com.smartchoice.common.dto.LogEvent;
import com.smartchoice.consumer.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findTop10ByEventOrderByTimestampDesc(LogEvent event);
}
