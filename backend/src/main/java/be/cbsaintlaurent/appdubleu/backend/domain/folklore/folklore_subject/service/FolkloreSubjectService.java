package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.service;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.NewFolkloreSubjectRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper.FolkloreSubjectMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.repository.BaptismalSeasonRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolkloreSubjectService {

    @Getter(AccessLevel.PROTECTED)
    private final FolkloreSubjectRepository repository;
    private final BaptismalSeasonRepository baptismalSeasonRepository;
    @Getter(AccessLevel.PROTECTED)
    private final FolkloreSubjectMapper mapper;
    private final BaptismalSeasonMapper baptismalSeasonMapper;



    public ResponseEntity<?> register(NewFolkloreSubjectRequest request) {
        FolkloreSubject folkloreSubject = new FolkloreSubject(null,
                request.getTitle(),
                request.getContent(),
                request.getPictureUrl(),
                null,
                null,
                baptismalSeasonMapper.toDto(baptismalSeasonRepository.findFirstByActive(true)),
                true
        );
        System.out.println("folkloreSubject");
        System.out.println(folkloreSubject);
        System.out.println(mapper.toEntity(folkloreSubject));

        FolkloreSubjectEntity folkloreSubjectEntity = repository.save(mapper.toEntity(folkloreSubject));
        return ResponseEntity.ok(mapper.toDto(folkloreSubjectEntity));
    }
}

