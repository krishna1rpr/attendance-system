package com.gec.attendance.attendancesystem.repository;

import com.gec.attendance.attendancesystem.model.ProxyTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProxyTimeTableRepository extends JpaRepository<ProxyTimeTable, Integer> {
}
