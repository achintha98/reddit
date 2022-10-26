package lk.com.reddit.repository;

import lk.com.reddit.model.AppUser;
import lk.com.reddit.model.Comment;
import lk.com.reddit.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    List<Comment> findAllByAppUser(AppUser appUser);
}
