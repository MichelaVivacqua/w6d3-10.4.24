package michelavivacqua.w6d31044.services;

import michelavivacqua.w6d31044.entities.Autore;
import michelavivacqua.w6d31044.entities.BlogPost;
import michelavivacqua.w6d31044.exceptions.NotFoundException;
import michelavivacqua.w6d31044.repositories.AutoriDAO;
import michelavivacqua.w6d31044.repositories.BlogPostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogPostsService {
    @Autowired
    private BlogPostsDAO blogPostRepository;

    public List<BlogPost> getBlogPostsList() {
        return blogPostRepository.findAll();
    }

    public BlogPost saveBlogPost(BlogPost body) {
        return blogPostRepository.save(body);
    }

    public BlogPost findById(int id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost) {
        BlogPost found = findById(id);
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setContenuto(updatedBlogPost.getContenuto());
        return blogPostRepository.save(found);
    }

    public void findByIdAndDelete(int authorId) {
        blogPostRepository.deleteById(authorId);
    }
}
