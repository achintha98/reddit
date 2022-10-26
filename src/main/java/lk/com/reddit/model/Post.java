package lk.com.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            name = "app_user_id",
            referencedColumnName = "app_user_id",
            foreignKey = @ForeignKey(
                    name = "app_user_post_fk"
            )
    )
    private AppUser appUser;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            name = "sub_reddit_id",
            referencedColumnName = "sub_reddit_id"
    )
    private SubReddit subReddit;
}
