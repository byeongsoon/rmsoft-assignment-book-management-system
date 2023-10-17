package com.rmsoft.bookmanagementsystem.global.config.jpa;

import lombok.NonNull;

import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        // todo : 사용자 정보 로그인 유지 시 사용자 이름 사용
        String updatedBy = "";

        if (StringUtils.hasText(updatedBy)) {
            updatedBy = "SERVER";
        }

        return Optional.of(updatedBy);
    }

}
