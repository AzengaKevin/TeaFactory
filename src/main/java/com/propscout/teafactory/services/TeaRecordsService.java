package com.propscout.teafactory.services;

import com.propscout.teafactory.models.entities.TeaRecord;
import com.propscout.teafactory.repositories.TeaRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class TeaRecordsService {

    private final TeaRecordRepository teaRecordRepository;

    public TeaRecordsService(TeaRecordRepository teaRecordRepository) {
        this.teaRecordRepository = teaRecordRepository;
    }


    public boolean addTeaRecord(TeaRecord teaRecord) {

        teaRecordRepository.save(teaRecord);

        return true;
    }


}
