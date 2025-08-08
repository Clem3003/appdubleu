package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolkloreSubjectRepository extends JpaRepository<FolkloreSubjectEntity, FolkloreSubject> {


}

