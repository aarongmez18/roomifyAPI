package com.back.roomify.domain.dtos.response.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object for user profile details")
public class AccountProfileResponse {

    @Schema(description = "Unique identifier of the Account", example = "1")
    private Long id;

    @Schema(description = "Username for the user's account", example = "aarongmez18")
    private String username;

    @Schema(description = "Email for the user's account", example = "aarongmez18@gmail.com")
    private String email;

    @Schema(description = "Name for the user's account", example = "Aaron")
    private String name;

    @Schema(description = "Lastname for the user's account", example = "Gomez Delgado")
    private String lastName;
}
