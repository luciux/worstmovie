package br.com.texo.worstmovie.app.entrypoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oscar-nominees")
public class OscarNominees {

    @GetMapping("/producers-with-longer-time-period-between-two-oscars")
    public ResponseEntity<Integer> producerWithLongerTimePeriodBetweenTwoOscars() {

        return ResponseEntity.ok().body(0);
    }

    @GetMapping("/producers-with-shorter-time-period-between-two-oscars")
    public ResponseEntity<Integer> producerWithShorterTimePeriodBetweenTowOscars() {
        return ResponseEntity.ok().body(1);
    }
}
