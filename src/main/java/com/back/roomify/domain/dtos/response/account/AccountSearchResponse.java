package com.back.roomify.domain.dtos.response.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Schema(description = "Response object for searching multiple user profiles by username")
public class AccountSearchResponse {

    @Schema(description = "List of user profiles matching the search criteria")
    private List<AccountProfileResponse> accounts;
}
