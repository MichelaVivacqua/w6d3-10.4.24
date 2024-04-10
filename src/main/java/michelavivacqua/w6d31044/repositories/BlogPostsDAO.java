package michelavivacqua.w6d31044.repositories;

import michelavivacqua.w6d31044.entities.Autore;
import michelavivacqua.w6d31044.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostsDAO extends JpaRepository<BlogPost, Integer> {
    boolean existsByTitolo(String titolo);
    Optional<BlogPost> findBytitolo(String titolo);

}
