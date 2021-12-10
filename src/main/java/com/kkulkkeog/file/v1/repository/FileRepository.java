package com.kkulkkeog.file.v1.repository;

import com.kkulkkeog.file.v1.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
