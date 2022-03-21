package com.example.restservice;

import com.example.restservice.util.Counter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {

    @Test
    public void testInitialisedDefaultValue() {
        Counter counter = new Counter();
        assertEquals(0, counter.getCount());
    }

    @Test
    public void testIncrementation() {
        Counter counter = new Counter();
        counter.incrementCount();
        assertEquals( 1, counter.getCount());
        counter.incrementCount();
        assertEquals( 2, counter.getCount());
    }
}
