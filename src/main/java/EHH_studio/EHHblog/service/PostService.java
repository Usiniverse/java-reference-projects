package EHH_studio.EHHblog.service;

import EHH_studio.EHHblog.domain.Post;
import EHH_studio.EHHblog.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 생성
    public Long savePost(Post post) {
        postRepository.savePost(post);
        return post.getId();
    }

    // 게시글 수정
    public Long updatePost(Long id, String title, String content) {
        Post updatePost = postRepository.findByPostId(id);
        updatePost.setTitle(title);
        updatePost.setContent(content);

        return updatePost.getId();
    }

    // 게시글 삭제
    public void removePost(Long id) {
        postRepository.removePost(id);
    }

    // id로 게시글 검색
    public Post findByPostId(Long id) {
        return postRepository.findByPostId(id);
    }

    // title로 게시글 검색
    public Post findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    // 게시글 전체 검색
    public List<Post> findAllPost() {
        return postRepository.findAllPost();
    }
}
