package com.back.roomify.domain.dtos.request.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Request object to search for accounts by username")
public class AccountSearchRequest {

    @Schema(description = "Username to search for accounts containing this string", example = "aar")
    private String username;
}
