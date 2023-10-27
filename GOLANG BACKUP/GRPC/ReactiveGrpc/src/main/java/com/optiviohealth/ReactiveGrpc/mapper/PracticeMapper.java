package com.optiviohealth.ReactiveGrpc.mapper;

import com.optiviohealth.ReactiveGrpc.entity.PracticeEntity;
import com.optiviohealth.ReactiveGrpc.model.Practice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PracticeMapper {


    PracticeEntity mapToEntity(Practice practice);
    Practice mapToModel(PracticeEntity practice);
}
