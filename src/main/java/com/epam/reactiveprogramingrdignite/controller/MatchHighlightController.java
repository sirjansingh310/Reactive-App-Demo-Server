package com.epam.reactiveprogramingrdignite.controller;


import com.epam.reactiveprogramingrdignite.model.MatchHighlight;
import com.epam.reactiveprogramingrdignite.repository.MatchHighlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;


@RestController
@CrossOrigin("http://localhost:4200")
public class MatchHighlightController {
    @Autowired
    private MatchHighlightRepository matchHighlightRepository;
    private Logger logger = LoggerFactory.getLogger(MatchHighlightController.class);
    private FluxSink fluxSink;
    private FluxProcessor fluxProcessor;

    public MatchHighlightController(){
        this.fluxProcessor = DirectProcessor.create();
        this.fluxSink = fluxProcessor.sink();
    }
    
    @GetMapping("/match-highlights")
    public Flux<MatchHighlight> getAllMatchHighlights(){
        return matchHighlightRepository.findAll();
    }
    @PostMapping("/match-highlights")
    public Mono<MatchHighlight> createMatchEvent(@RequestBody MatchHighlight matchHighlight){
        return matchHighlightRepository.save(matchHighlight).doOnSuccess(mEvent -> {
            fluxSink.next(mEvent);
        });
    }

    @GetMapping(value = "/match-highlights/live", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent> getLiveMatchEvents(){
        return fluxProcessor.map(e -> ServerSentEvent.builder(e).build());
    }

   @DeleteMapping("/match-highlights")
    public Mono<Void> deleteAll(){
        return matchHighlightRepository.deleteAll();
   }

}
