package dev.marianoj8.inaluma.persistence.model.entity.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimeUnits {
    M("Minuto/s"),
    H("Hora/s");

    public final String timeUnit;
}
