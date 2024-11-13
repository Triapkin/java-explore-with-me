package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    @NotBlank
    private String app;

    @NotBlank
    private String uri;

    @NotBlank
    private Long hits;
}
