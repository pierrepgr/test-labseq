package com.labseq.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class LabSeqServiceTest {

    private LabSeqService labSeqService;

    @BeforeEach
    void setup() {
        this.labSeqService = new LabSeqService();
    }

    @Test
    void testIfLabSeqIsCalculatingCorrectly() {
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(0)), BigInteger.ZERO);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(1)), BigInteger.ONE);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(2)), BigInteger.ZERO);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(3)), BigInteger.ONE);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(4)), BigInteger.ONE);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(5)), BigInteger.ONE);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(6)), BigInteger.ONE);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(7)), BigInteger.TWO);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(8)), BigInteger.TWO);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(9)), BigInteger.TWO);
        assertEquals(this.labSeqService.getSeq(BigInteger.valueOf(10)), BigInteger.valueOf(3));
    }
}
