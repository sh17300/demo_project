package Project_no_1.project1.Dto;

import Project_no_1.project1.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String content;

    //정적 팩토리 메서드 추가
    public static BoardResponseDto findFromBoard(Board board) {
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }

}
