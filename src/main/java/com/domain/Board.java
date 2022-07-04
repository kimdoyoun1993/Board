package com.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private Integer bno;
    private String title;
    private String content;
    private String writer;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
