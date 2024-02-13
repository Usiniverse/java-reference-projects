package EHH_studio.EHHblog.controller;

import EHH_studio.EHHblog.domain.Post;
import EHH_studio.EHHblog.service.PostService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public Post createPost(@RequestBody Post post) {
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());

        postService.savePost(post);
        return post;
    }

    @PutMapping("")
    public Post updatePost(
            @RequestParam Long id,
            @RequestBody Post post
    ) {
        String title = post.getTitle();
        String content = post.getContent();
        postService.updatePost(id, title, content);
        return postService.findByPostId(id);
    }

    @DeleteMapping("")
    public String delete(@RequestParam Long id) {
        postService.removePost(id);
        return id + "번 게시글 삭제 완료!";
    }

    @GetMapping("")
    public String readPost(@RequestParam @Nullable Long id, String title) {
        if (id != null) {
            return postService.findByPostId(id).toString();
        } else {
            return postService.findByTitle(title).toString();
        }
    }

    @GetMapping("/all")
    public String readAllPost() {
        return postService.findAllPost().toString();
    }
}