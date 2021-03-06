package generation.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.PostModel;
import generation.mx.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping
	public ArrayList<PostModel> getPosts() {
		return postService.getPosts();
	}
	
	@PostMapping
	public PostModel savePost(@RequestBody PostModel post) { //Lo obtenido de RequestBody que se meta a la variable PostModel llamada post
		return postService.savePost(post);
	}
	
	@GetMapping(path = "/{id}")
	public Optional <PostModel> getPostById(@PathVariable("id") Long id) {
		return postService.getPostById(id);
	}
	
	@GetMapping("/query")
	public ArrayList<PostModel> getPostsByTitle (@RequestParam(value = "title", defaultValue = "") String title){
	return postService.getPostsByTitle(title);
	//Al hacer la consulta en Postman, no olvidar la concatenación de cosas. En este caso, el request mapping está en post, entonces es: 
	//localhost:8080/post/query?title=Tuit
	}
	
	@GetMapping("/q")
	public ArrayList<PostModel> getByTitleOrderById (@RequestParam(value = "title", defaultValue = "") String title){
	return postService.getByTitleContainingOrderByIdDesc(title);
	}
} 
