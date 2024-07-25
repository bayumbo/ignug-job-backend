package com.bolsaempleo.backend.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
