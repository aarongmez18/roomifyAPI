package com.back.roomify.controller;

import com.back.roomify.domain.dtos.request.account.AccountSearchRequest;
import com.back.roomify.domain.dtos.response.account.AccountProfileResponse;
import com.back.roomify.domain.entity.Account;
import com.back.roomify.service.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
@Tag(name = "Account resource")
public class AccountController {

    private final AccountService accountService;
    private final ConversionService conversionService;

    @GetMapping("/search")
    @Operation(summary = "Search accounts by username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found accounts matching username",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccountProfileResponse.class))),
            @ApiResponse(responseCode = "404", description = "No accounts found with the provided username",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<List<AccountProfileResponse>> searchAccountsByUsername(
            @RequestParam @Parameter(description = "Username to search", required = true) AccountSearchRequest request) {
        List<Account> accounts = accountService.searchAccountsByUsername(request);
        List<AccountProfileResponse> responses = accounts.stream()
                .map(account -> conversionService.convert(account, AccountProfileResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get public profile of a user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User profile found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccountProfileResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<AccountProfileResponse> getAccountProfile(
            @PathVariable @Parameter(description = "Account ID", required = true) Long id) {
        Account profile = accountService.getProfile(id);
        AccountProfileResponse response = conversionService.convert(profile, AccountProfileResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    @Operation(summary = "Get your own profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Own profile found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccountProfileResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<AccountProfileResponse> getOwnProfile() {
        Account profile = accountService.getMyProfile();
        AccountProfileResponse response = conversionService.convert(profile, AccountProfileResponse.class);
        return ResponseEntity.ok(response);
    }
}
