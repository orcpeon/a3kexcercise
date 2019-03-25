package colortables.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VotesRepository extends CrudRepository<Votes, Integer> {
    List<Votes> findByColorIgnoreCase(String color);
}
