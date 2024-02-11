package EHH_studio.EHHblog.controller;

import EHH_studio.EHHblog.domain.Post;
import EHH_studio.EHHblog.service.PostService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entitymanager-example/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public Post createPost(@RequestBody String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        postService.savePost(post);
        return post;
    }

    @PostMapping("")
    public Post createPost(@RequestBody Post post) {
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());

        postService.savePost(post);
        return post;
    }

    @PutMapping("")
    public String updatePost(@RequestParam Long id, String title, String content) {
        Long postId = postService.updatePost(id, title, content);
        return postId + "번 게시글 수정 완료!";
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