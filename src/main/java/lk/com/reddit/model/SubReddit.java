package lk.com.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sub_reddit")
public class SubReddit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "sub_reddit_id")
    private Long subRedditId;
    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @OneToMany(
            mappedBy = "subReddit",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Post> posts;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    private AppUser appUser;
}
