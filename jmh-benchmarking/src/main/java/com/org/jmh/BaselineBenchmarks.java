package com.org.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class BaselineBenchmarks {
    int i;

    @Benchmark
    public void noop() {
    }

    @Benchmark
    public void increment() {
        i++;
    }

    @Benchmark
    public int incrementConsume() {
        return i++;
    }

    @Benchmark
    public int consume() {
        return i;
    }

    @Benchmark
    public int consumeAdd() {
        return i + 1;
    }

    public static void main(String...args) throws RunnerException {
        new Runner(new OptionsBuilder()
                .include(BaselineBenchmarks.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(20)
                .forks(1)
                .build()).run();
    }
}
