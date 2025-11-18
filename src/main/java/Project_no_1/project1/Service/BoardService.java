package Project_no_1.project1.Service;

import Project_no_1.project1.Dto.BoardPatchDto;
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

    //post와 다른 부분 --> 매개변수 2개, 이유는 그 이유는d
    // PATCH는 POST와는 다르게 누군지를 알아야 하기에 ID를 찾아줘야 하는데
    //Board board = findBoardId(boardId);
    // 여길보면 findBoardId를 호출하는게 보이는데
    // Service에 메서드를 새로 추가 하였다.
    public Long updateBoard(BoardPatchDto boardPatchDto, Long boardId) {
        Board board = findBoardId(boardId);
        board.setTitle(boardPatchDto.getTitle());
        board.setContent(boardPatchDto.getContent());

        return boardRepository.save(board).getId();
    }
    public Board findBoardId(Long  boardId) {
        return boardRepository.findById(boardId).orElseThrow(()->new BusinessLogicException(BusinessLogicException.ExceptionCode.BOARD_NOT_FOUND));
    }
    public void deleteBoard(Long boardId) {
        findBoardId(boardId);
        boardRepository.deleteById(boardId);
    }
}
