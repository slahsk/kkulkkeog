package com.kkulkkeog.file.repository;

import com.kkulkkeog.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
