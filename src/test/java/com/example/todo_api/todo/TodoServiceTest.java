package com.example.todo_api.todo;

import com.example.todo_api.common.message.ErrorMessage;
import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    // mocking
    @Mock
    private TodoRepository todoRepository;

    @Mock
    private MemberRepository memberRepository;

    // mocking 된 객체 넣, 가짜 객체 주입
    @InjectMocks
    private TodoService todoService;

    @Test
    public void createTodoTest() throws Exception {
        // bdd (behavior driven development)

        // given (테스트를 실행할 때 필요한 기본 환경 세팅)
        // 1을 가지는 객체가 호출되었을 때, 멤버 객체를 임의로 생성을 해서 반환하도록 한다.
        // memberRepository 라는 가짜객체의 동작을 우리가 지정
        BDDMockito.given(memberRepository.findById(1L)).willReturn(new Member());

        // when (테스트 하려는 그 동작을 실행)
        todoService.createTodo("content", 1L);

        // then (그 동작이 실행되었을 때, 우리가 기대하는 결과가 올바르게 나오는지 확인)
        // 특정 메서드의 호출여부, 호출 횟수
        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    public void createTodoTestFail() throws Exception {
        // given
        BDDMockito.given(memberRepository.findById(anyLong())).willReturn(null);

        // when & then
        // 멤버가 존재하지 않는다는 에러가 나기를 기대한다.
        Assertions.assertThatThrownBy(() -> {
            todoService.createTodo("content", 99999L);
        }).hasMessageContaining(ErrorMessage.MEMBER_NOT_EXIST)
                .isInstanceOf(Exception.class);
    }
}
