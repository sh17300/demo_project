package Project_no_1.project1.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class BoardPatchDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
