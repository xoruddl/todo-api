package com.example.todo_api.todo;

import com.example.todo_api.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //실제 어플리케이션에 올리는것처럼 사용하겠다
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

//    @Test
//    @Transactional
//    @Rollback(false)    //테스트 끝나도 롤백 x
//    void todoSaveTest() {
//        // 트랜잭션 시작
//        Todo todo = new Todo("todo content", null);
//        todoRepository.save(todo);
//
//        // 트랜잭션 끝
//        // 에러가 발생했을 때는 자동으로 롤백
//
//        Assertions.assertThat(todo.getId()).isNotNull();
//    }
//
//    @Test
//    @Transactional
//    void todoFindOneByIdTest() {
//        // given
//        Todo todo = new Todo("todo content", null);
//        todoRepository.save(todo);
//
//        todoRepository.flushAndClear();
//
//        // when
//        Todo findTodo = todoRepository.findById(todo.getId());
//
//        // then
//        Assertions.assertThat(findTodo.getId()).isEqualTo(todo.getId());
//    }
//
//    @Test
//    @Transactional
//    void todoFindAllTest() {
//        Todo todo1 = new Todo("todo content1", null);
//        Todo todo2 = new Todo("todo content2", null);
//        Todo todo3 = new Todo("todo content3", null);
//        todoRepository.save(todo1);
//        todoRepository.save(todo2);
//        todoRepository.save(todo3);
//
//        List<Todo> todoList = todoRepository.findAll();
//
//        System.out.println(todoList);
////        Assertions.assertThat(todoList).hasSize(3);
//    }
//
//    @Test
//    @Transactional
//    void todoFindAllByMemberTest() {
//        Member member1 = new Member();
//        Member member2 = new Member();
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//
//        Todo todo1 = new Todo("todo content1", member1);
//        Todo todo2 = new Todo("todo content2", member1);
//        Todo todo3 = new Todo("todo content3", member2);
//        todoRepository.save(todo1);
//        todoRepository.save(todo2);
//        todoRepository.save(todo3);
//
//        List<Todo> member1TodoList = todoRepository.findAllByMember(member1);
//        List<Todo> member2TodoList = todoRepository.findAllByMember(member2);
//
//        Assertions.assertThat(member1TodoList).hasSize(2);
//        Assertions.assertThat(member2TodoList).hasSize(1);
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    void todoUpdateTest() {
//        Todo todo1 = new Todo("todo content1", null);
//        todoRepository.save(todo1);
//
//        todoRepository.flushAndClear();
//
//        Todo findTodo1 = todoRepository.findById(todo1.getId());
//        findTodo1.updateContent("new content");
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    void todoDeleteTest() {
//        Todo todo1 = new Todo("todo content1", null);
//        Todo todo2 = new Todo("todo content2", null);
//        todoRepository.save(todo1);
//        todoRepository.save(todo2);
//
//        todoRepository.flushAndClear();
//
//        todoRepository.deleteById(todo1.getId());
//    }
//
//    @AfterAll   // 모든 테스트가 끝났을때
//    public static void doNotFinish() {
//        System.out.println("test finished");
//        while (true) {}
//    }
}
