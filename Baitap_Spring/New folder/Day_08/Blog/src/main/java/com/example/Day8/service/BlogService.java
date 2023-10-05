package com.example.Day8.service;

import com.example.Day8.entity.Blog;
import com.example.Day8.entity.Category;
import com.example.Day8.entity.User;
import com.example.Day8.repository.BlogRepository;
import com.example.Day8.repository.CategoryRepository;
import com.example.Day8.repository.UserRepository;
import com.example.Day8.request.UpsertBlogRequest;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public BlogService(BlogRepository blogRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public Page<Blog> findAll(Integer page, Integer limit){
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by("publishedAt").descending());
        return blogRepository.findByStatus( true, pageable);
    }

    public List<Blog> searchByTitle(String title){
        return blogRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Blog> findByCategoryName(String name){
        return blogRepository.findByCategoryName(name);
    }

    public Blog findByIdAndSlug(Integer id, String slug){
        return blogRepository.findByIdAndSlugAndStatusTrue(id, slug)
                .orElseThrow(()-> new RuntimeException("Not found blog"));
    }

    public Page<Blog> getAllBlogsOfCurrentUser(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit , Sort.by("createdAt").descending());
        return blogRepository.findAll(pageable);
    }

    public Page<Blog> getAllBlogs(Integer page, Integer limit) {
        // TODO : Giả định userId = 1, sau này userId chính là user đang login
        Integer userId = 1;
        return null;
    }

    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found user"));
    }

    public Blog createBlog(UpsertBlogRequest request) {
        // TODO : Giả định userId = 1, sau này userId chính là user đang login
        Integer userId = 1;
        Blog blog = new Blog();

        User user = userRepository.findById(1)
                .orElseThrow(()-> new RuntimeException("not found user"));

        Slugify slugify = Slugify.builder().build();
        blog.setDescription(request.getDescription());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setContent(request.getContent());
        blog.setThumbnail(request.getThumbnail());
        blog.setTitle(request.getTitle());
        List<Category> categoryList = categoryRepository.findByIdIn(request.getCategoryIds());
        blog.setCategories(categoryList);
        blog.setUser(user);

        return blogRepository.save(blog);
    }

    public Blog updateBlog(UpsertBlogRequest request, Integer id){
        Blog blog = blogRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found blog"));
        User user = userRepository.findById(1)
                .orElseThrow(()-> new RuntimeException("not found user"));
        Slugify slugify = Slugify.builder().build();

        blog.setTitle(request.getTitle());
        blog.setThumbnail(request.getThumbnail());
        blog.setContent(request.getContent());
        blog.setStatus(request.getStatus());
        blog.setDescription(request.getDescription());
        blog.setSlug(slugify.slugify(request.getTitle()));
        List<Category> categoryList = categoryRepository.findByIdIn(request.getCategoryIds());
        blog.setCategories(categoryList);
        blog.setUser(user);
        return blogRepository.save(blog);
    }


    public void deleteBlog(Integer id) {
        Blog blog =  blogRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found blog"));
        blogRepository.delete(blog);
    }
}
