package com.rmsoft.bookmanagementsystem.api.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/healthCheck")
@Tag(name = "헬스 체크", description = "서버 정상 운용 관련 API")
public class HealthCheckApi {

    @Operation(summary = "서버 상태 헬스체크", description = "서버가 정상적으로 운영중인지 확인합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공",
            content = @Content(schema = @Schema(implementation = String.class))),
    })
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("status : UP");
    }

}
