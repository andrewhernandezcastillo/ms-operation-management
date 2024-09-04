package com.demo.ms.utils.commons;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Properties {
    @Value("${operacion.recarga}")
    private String recarga;
    @Value("${operacion.debito}")
    private String debito;
}
