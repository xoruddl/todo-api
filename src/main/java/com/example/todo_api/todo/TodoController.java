package com.example.todo_api.todo;

import com.example.todo_api.todo.dto.TodoCreateRequest;
import com.example.todo_api.todo.dto.TodoUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    // 생성자 주입
    private final TodoService todoService;

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createTodo(@RequestBody @Valid TodoCreateRequest request) throws Exception {
        Long todoId = todoService.createTodo(request.getContent(), request.getMemberId());
        return ResponseEntity.created(URI.create("/todo/" + todoId)).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getTodoList(@RequestBody Long memberId) throws Exception {
        List<Todo> todoList = todoService.getTodoList(memberId);
        return ResponseEntity.ok().body(todoList);
    }

    // Delete
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable (name = "todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();  // 204 no content
    }

    // PATCH
    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> updateTodo(@PathVariable (name = "todoId") Long todoId, @RequestBody TodoUpdateRequest request) throws Exception {
        todoService.updateTodo(todoId, request.getUpdateContent(), request.getMemberId());
        return ResponseEntity.ok().build();
    }

//    public String test() {
//        return "hello";
//    }
}
