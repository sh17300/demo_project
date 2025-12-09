package Project_no_1.project1.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    private String reContent;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
