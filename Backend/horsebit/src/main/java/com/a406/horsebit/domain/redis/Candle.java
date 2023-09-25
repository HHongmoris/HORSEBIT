package com.a406.horsebit.domain.redis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Candle {
    private LocalDateTime startTime;
    private Long open;
    private Long close;
    private Long high;
    private Long low;
    private Double volume;
}