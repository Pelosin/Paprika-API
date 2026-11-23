package com.paprika.api.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paprika.api.domain.LineOrder;
import com.paprika.api.payload.request.LineOrderCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderByIdResponse {
    private Long id;
    private List<LineOrder> lineOrderList;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDateTime;
}
