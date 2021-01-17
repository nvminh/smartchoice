package com.smartchoice.product.dto;

import com.smartchoice.product.entity.LogEvent;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class AuditLogDto {
    private Timestamp timestamp;
    private LogEvent event;
    private String source;
    private String log;
}