package com.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    private Integer rno;
    private Integer bno;
    private String replyText;
    private String replyer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
