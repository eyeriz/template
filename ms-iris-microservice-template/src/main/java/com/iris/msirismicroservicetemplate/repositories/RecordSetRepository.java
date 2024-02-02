package com.iris.msirismicroservicetemplate.repositories;

import com.iris.msirismicroservicetemplate.models.RecordSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordSetRepository extends JpaRepository<RecordSet, Long> {
}
