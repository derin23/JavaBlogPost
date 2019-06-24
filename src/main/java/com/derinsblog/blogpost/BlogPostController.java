package com.derinsblog.blogpost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 


@RequestMapping
@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	
	//private static List<BlogPost> posts = new ArrayList<>();
	
	
	
	@GetMapping("/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/index";
	    }

//private BlogPost blogpost;
@PostMapping("/")
public String addNewBlogPost(BlogPost blogPost, Model model) {
	blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
	
	model.addAttribute("id", blogPost.getId());
	model.addAttribute("title", blogPost.getTitle());
	model.addAttribute("author", blogPost.getAuthor());
	model.addAttribute("blogEntry", blogPost.getBlogEntry());
	return "blogpost/result";
        }
@GetMapping(value = "/blogpost/new")
public String newBlog (BlogPost blogPost) {
    return "blogpost/new";
	
}
//show
@RequestMapping(value = "/blogpost/{id}", method = RequestMethod.GET)
public String getPostWithId(@PathVariable long id,BlogPost blogPost,Model model) {

	BlogPost post = blogPostRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id " +id));
    model.addAttribute("post",post);
    return "blogpost/show";

}
//edit
@RequestMapping(value="/blogpost/edit/{id}",method=RequestMethod.GET)
public String showUpdateForm(@PathVariable long id, Model model) {
    BlogPost blogPost = blogPostRepository.findById(id).orElse(null);
    model.addAttribute("posts",blogPost);
        return "blogpost/edit";
    }

//update
@RequestMapping(value="/blogpost/{id}", method = RequestMethod.PUT)
public String updatePostById(@PathVariable long id, Model model, BlogPost formData) {
	BlogPost editedBlogPost = blogPostRepository.findById(id).orElse(null);
	editedBlogPost.setAuthor(formData.getAuthor());  
	editedBlogPost.setTitle(formData.getTitle()); 
	editedBlogPost.setBlogEntry(formData.getBlogEntry()); 
	blogPostRepository.save(editedBlogPost);
	model.addAttribute("id",editedBlogPost.getId());
	model.addAttribute("title",editedBlogPost.getTitle());
	model.addAttribute("author",editedBlogPost.getAuthor());
	model.addAttribute("blogEntry",editedBlogPost.getBlogEntry());
	return"blogpost/result";
}

//delete
@RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
public String deletePostWithId(@PathVariable long id,BlogPost blogPost,Model model) {

    blogPostRepository.deleteById(id);
    model.addAttribute("posts",blogPostRepository.findAll());
    return "blogpost/index";

}

@PostMapping(value = "/blogpost/new")
public String create(BlogPost blogPost, Model model) {
	blogPostRepository.save(blogPost);
        
	model.addAttribute("title", blogPost.getTitle());
	model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
}
}