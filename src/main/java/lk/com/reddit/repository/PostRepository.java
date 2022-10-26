package lk.com.reddit.repository;

import lk.com.reddit.model.AppUser;
import lk.com.reddit.model.Post;
import lk.com.reddit.model.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubReddit(SubReddit subreddit);
    List<Post> findByAppUser(AppUser appUser);
}
