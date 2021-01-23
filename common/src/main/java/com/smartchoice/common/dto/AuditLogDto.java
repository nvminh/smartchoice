package com.smartchoice.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class AuditLogDto {


    private Timestamp timestamp;
    private LogEvent event;
    private String source;
    private String log;

    public AuditLogDto(LogEvent event, String source, String log) {
        this.event = event;
        this.source = source;
        this.log = log;
        this.timestamp = new Timestamp(new Date().getTime());
    }


}
