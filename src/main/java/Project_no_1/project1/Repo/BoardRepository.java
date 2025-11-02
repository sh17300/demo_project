package Project_no_1.project1.Repo;

import Project_no_1.project1.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository  extends JpaRepository<Board,Long> {

}
