package com.probehub.repositories;

import com.probehub.models.ProbeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<ProbeTest, Long> {

}
