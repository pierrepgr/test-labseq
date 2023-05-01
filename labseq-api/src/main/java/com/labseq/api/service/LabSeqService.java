package com.labseq.api.service;

import com.labseq.api.service.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LabSeqService {

    private static final ConcurrentHashMap<BigInteger, BigInteger> cache = new ConcurrentHashMap<>();

    public BigInteger getSeq(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) throw new BusinessException("generic-1", HttpStatus.BAD_REQUEST, null);

        if (number.compareTo(BigInteger.ZERO) == 0 || number.compareTo(BigInteger.TWO) == 0) return BigInteger.ZERO;
        if (number.compareTo(BigInteger.ONE) == 0 || number.compareTo(BigInteger.valueOf(3)) == 0) return BigInteger.ONE;

        if (!cache.containsKey(number)) cache.put(number, getSeq(number.subtract(BigInteger.valueOf(4))).add(getSeq(number.subtract(BigInteger.valueOf(3)))));

        return cache.get(number);
    }
}
