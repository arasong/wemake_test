package com.wemake.test.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
public class RequestDto {
    @NotNull(message = "url을 입력해주세요")
    private String url;
    private String type;
    @NotNull(message = "출력 단위 묶음을 입력해주세요")
    private int unit;
}
