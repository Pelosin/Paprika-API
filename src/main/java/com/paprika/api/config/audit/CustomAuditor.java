package com.paprika.api.config.audit;

import org.springframework.data.domain.AuditorAware;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomAuditor implements AuditorAware<LocalDateTime> {
    @Override
    public Optional<LocalDateTime> getCurrentAuditor() {
        return Optional.of(LocalDateTime.now());
    }
}
