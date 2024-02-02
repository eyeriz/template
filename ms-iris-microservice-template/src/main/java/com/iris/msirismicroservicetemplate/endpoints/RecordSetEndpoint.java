package com.iris.msirismicroservicetemplate.endpoints;

import com.iris.msirismicroservicetemplate.dtos.RecordSetDto;
import com.iris.msirismicroservicetemplate.models.RecordSet;
import com.iris.msirismicroservicetemplate.repositories.RecordSetRepository;
import com.iris.msirismicroservicetemplate.services.RecordSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecordSetEndpoint {
    @Autowired
    RecordSetService recordSetService;

    @Autowired
    RecordSetRepository recordSetRepository;

    @PostMapping("/record")
    public RecordSet saveRecord(@RequestBody RecordSetDto recordSetDto){
        return recordSetService.saveRecord(recordSetDto);
    }

    @PutMapping("/record/{id}")
    public RecordSet updateRecord(@PathVariable Long id, @RequestBody RecordSetDto recordSetDto ) throws Exception {
        return  recordSetService.updateRecord(id, recordSetDto);
    }

    @GetMapping("/records")
    public List<RecordSet> getAllRecords(){
        return recordSetService.getRecords();
    }

    @GetMapping("/record/{id}")
    public RecordSet getRecordById(@PathVariable Long id) throws Exception {
        return     recordSetRepository.findById(id).orElseThrow(Exception::new);
    }
    @DeleteMapping("/record/{id}")
    public void  deleteRecordById(@PathVariable Long id) {
        recordSetRepository.deleteById(id);
    }


}
