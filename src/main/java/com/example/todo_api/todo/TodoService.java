package com.example.todo_api.todo;

import com.example.todo_api.common.exception.BadRequestException;
import com.example.todo_api.common.message.ErrorMessage;
import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    // 서비스 계층은 레포지토리 계층에 의존
    // 의존성 주입 , 생성자 주입
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    // 할 일 생성
    @Transactional
    public Long createTodo(String content, Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new BadRequestException(ErrorMessage.MEMBER_NOT_EXIST);
        }

//        List<Todo> todoList = todoRepository.findAllByMember(member);
//        if (todoList.size() >= 10) {
//            throw new Exception("할 일은 멤버당 최대 10개까지만 만들 수 있습니다.");
//        }

        Todo todo = new Todo(content, member);
        todoRepository.save(todo);
        return todo.getId();
    }

    // 할 일 조회(특정 멤버의 모든 할 일 조회)
    @Transactional(readOnly = true)
    public List<Todo> getTodoList(Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new BadRequestException(ErrorMessage.MEMBER_NOT_EXIST);
        }

        return todoRepository.findAllByMember(member);
    }
    // 할 일 수정
    @Transactional
    public void updateTodo(Long todoId, String newContent, Long memberId) throws Exception {
        // 수정하려는 todo 조회
        Todo todo = todoRepository.findById(todoId);
        Member member = memberRepository.findById(memberId);

        if (todo == null) {
            throw new Exception("존재하지 않는 할 일입니다.");
        }

        if (member == null) {
            throw new Exception(ErrorMessage.MEMBER_NOT_EXIST);
        }

        if (todo.getMember() != member) {
            throw new Exception("다른 유저의 할 일을 수정할 수 없습니다.");
        }

        todo.updateContent(newContent);
    }

    // 할 일 삭제
    @Transactional
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId);
//        todoRepository.deleteById(todoId);
        todoRepository.delete(todo);
    }
}
