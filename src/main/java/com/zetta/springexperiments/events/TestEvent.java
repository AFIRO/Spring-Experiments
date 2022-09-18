package com.zetta.springexperiments.events;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestEvent {
    private int id;
    @NonNull
    private String payload;
}
