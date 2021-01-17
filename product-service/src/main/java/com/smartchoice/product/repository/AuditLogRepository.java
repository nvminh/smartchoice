package com.smartchoice.product.repository;

import com.smartchoice.product.entity.AuditLog;
import com.smartchoice.product.entity.LogEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findTop10ByEventOrderByTimestampDesc(LogEvent event);
}
