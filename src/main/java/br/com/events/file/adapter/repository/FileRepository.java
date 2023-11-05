package br.com.events.file.adapter.repository;

import br.com.events.file.domain.entity.File;
import br.com.events.file.domain.entity.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, String> {

    Optional<File> findByUuidAndType(String uuid, FileType fileType);

    List<File> findByOriginAndOriginUuid(String origin, String originUuid);
}
