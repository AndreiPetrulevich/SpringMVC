package ru.gb.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String body;
    private String to;
    private String from;

}
