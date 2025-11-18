package Project_no_1.project1.Controller;

import Project_no_1.project1.Dto.BoardPatchDto;
import Project_no_1.project1.Dto.BoardPostDto;
import Project_no_1.project1.Entity.Board;
import Project_no_1.project1.Repo.BoardRepository;
import Project_no_1.project1.Service.BoardService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Getter@Setter
@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity postBoard(@RequestBody @Valid BoardPostDto boardPostDto) {
        Long boardId = boardService.createBoard(boardPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardId);

    }
    @PatchMapping("/{boardId}")
    public ResponseEntity patchBoard(@PathVariable("boardId") Long boardId, @RequestBody @Validated BoardPatchDto boardPatchDto) {
        boardService.updateBoard(boardPatchDto, boardId);
        return ResponseEntity.status(HttpStatus.OK).body(boardId);
    }
    @DeleteMapping("/{boardId}")
    public ResponseEntity deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
