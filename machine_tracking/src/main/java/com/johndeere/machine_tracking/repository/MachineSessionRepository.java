package com.johndeere.machine_tracking.repository;

import com.johndeere.machine_tracking.model.MachineSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineSessionRepository extends JpaRepository<MachineSession, String> {
    @Query("SELECT s FROM MachineSession s " +
            "WHERE s.machineId = :machineId " +
            "AND s.endAt IS NULL")
    MachineSession findOpenSessionByMachineId(@Param("machineId") String machineId);

    List<MachineSession> findByMachineId(@Param("machineId") String machineId);
}
