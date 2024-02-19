package dev.marianoj8.inaluma.persistence.model.entity.utils;

import java.util.List;

public interface FilterOperator<L, P> { public L filter(List<L> list, P predicate); }