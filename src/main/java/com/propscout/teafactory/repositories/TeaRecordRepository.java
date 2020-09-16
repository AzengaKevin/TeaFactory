package com.propscout.teafactory.repositories;

import com.propscout.teafactory.models.entities.Center;
import com.propscout.teafactory.models.entities.TeaRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeaRecordRepository extends CrudRepository<TeaRecord, Long> {
    List<TeaRecord> findAllByCenter(Center center);
}
