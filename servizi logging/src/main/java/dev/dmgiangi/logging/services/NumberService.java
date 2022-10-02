package dev.dmgiangi.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class NumberService {
    private final static Logger logger = LoggerFactory.getLogger(NumberService.class);

    @Value("${pow.base}")
    private Double base;

    @Value("${pow.exponent}")
    private Double exponent;

    public double getPow() {
        Instant start = Instant.now();
        logger.debug("Start Calculation on: " + start);
        double result = Math.pow(base, exponent);
        Instant end = Instant.now();
        logger.debug("End Calculation on: %s with result: %d" + end);
        logger.debug("Calculation duration: " + Duration.between(start, end).getNano() + " ns");
        return result;
    }
}
