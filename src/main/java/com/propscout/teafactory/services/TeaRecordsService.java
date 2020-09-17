package com.propscout.teafactory.services;

import com.propscout.teafactory.models.MonthTeaWeight;
import com.propscout.teafactory.models.entities.TeaRecord;
import com.propscout.teafactory.repositories.TeaRecordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<MonthTeaWeight> getThisMonthCumulativeTeaWeight() {

        return teaRecordRepository.getCumulativeAccountTeaRecords();
    }


}
