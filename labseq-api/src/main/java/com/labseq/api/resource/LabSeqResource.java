package com.labseq.api.resource;

import com.labseq.api.service.LabSeqService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/labseq")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LabSeqResource {

    private final LabSeqService labSeqService;

    @GetMapping("/{number}")
    @Operation(tags = {"LabSeq Sequence Generate"})
    public ResponseEntity<BigInteger> getLabSeq(@PathVariable BigInteger number) {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES))
                .body(this.labSeqService.getSeq(number));
    }
}
