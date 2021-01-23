package com.smartchoice.consumer.entity;

import com.smartchoice.common.dto.LogEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private Timestamp timestamp;
    @Column
    private LogEvent event;
    @Column
    private String source;
    @Column
    private String log;

    public AuditLog(LogEvent event, String source, String log) {
        this.event = event;
        this.source = source;
        this.log = log;
        this.timestamp = new Timestamp(new Date().getTime());
    }
}
