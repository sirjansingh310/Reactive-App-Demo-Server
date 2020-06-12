package com.epam.reactiveprogramingrdignite.repository;

import com.epam.reactiveprogramingrdignite.model.MatchHighlight;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MatchHighlightRepository extends ReactiveMongoRepository<MatchHighlight, String> {
}
