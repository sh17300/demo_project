package Project_no_1.project1.Service;

import Project_no_1.project1.Dto.BoardPostDto;
import Project_no_1.project1.Entity.Board;
import Project_no_1.project1.Repo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long createBoard(BoardPostDto boardPostDto) {
        Board board = new Board();
        board.setTitle(boardPostDto.getTitle());
        board.setContent(boardPostDto.getContent());

        return boardRepository.save(board).getId();
    }
}
