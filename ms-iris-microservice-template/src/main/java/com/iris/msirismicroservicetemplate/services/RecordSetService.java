package com.iris.msirismicroservicetemplate.services;

import com.iris.msirismicroservicetemplate.dtos.RecordSetDto;
import com.iris.msirismicroservicetemplate.models.RecordSet;
import com.iris.msirismicroservicetemplate.repositories.RecordSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordSetService {
    @Autowired
    RecordSetRepository recordSetRepository;

    public RecordSet saveRecord(RecordSetDto recordSetDto) {
        RecordSet recordSet = RecordSet.builder()
                .name(recordSetDto.getName())
                .gender(recordSetDto.getGender())
                .description(recordSetDto.getDescription())
                .build();
        return recordSetRepository.save(recordSet);
    }

    public List<RecordSet> getRecords(){
        return recordSetRepository.findAll();
    }

    public RecordSet updateRecord(Long id, RecordSetDto recordSetDto) throws Exception {
        RecordSet recordSet = recordSetRepository.findById(id).orElseThrow(Exception::new);
        recordSet.setName(recordSetDto.getName());
        recordSet.setGender(recordSetDto.getGender());
        recordSet.setDescription(recordSetDto.getDescription());
        return  recordSetRepository.save(recordSet);
    }
}
