package com.paprika.api.mapper;

import com.paprika.api.domain.User;
import com.paprika.api.payload.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class UserMapper {
    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();

    }
}
