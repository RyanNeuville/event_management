package com.iuc.event_management.mapper;
import com.iuc.event_management.dto.response.UserResponse;
import com.iuc.event_management.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toDto(User user) {
        UserResponse dto = new UserResponse();
        dto.id = user.getId();
        dto.name = user.getName();
        dto.email = user.getEmail();
        dto.role = user.getRoles().toString();
        return dto;
    }
}
