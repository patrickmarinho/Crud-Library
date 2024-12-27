package com.example.crudlibary.dto;

import com.example.crudlibary.domain.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
