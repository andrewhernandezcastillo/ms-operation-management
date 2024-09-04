package com.demo.ms.infraestructure.adapter.input.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private String code;
    private String description;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Error [code=");
        builder.append(code);
        builder.append("description=");
        builder.append(description);
        builder.append("]");
        return builder.toString();
    }
}