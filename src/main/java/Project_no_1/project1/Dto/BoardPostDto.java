package Project_no_1.project1.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoardPostDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
