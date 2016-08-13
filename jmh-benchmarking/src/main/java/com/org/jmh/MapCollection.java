package com.org.jmh;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MapCollection {

    private static final Map<String, String> HASH_MAP = new HashMap<>();
    private static final Map<String, String> TREE_MAP = new TreeMap<>();
    private static final Map<String, String> CONCUR_MAP = new ConcurrentHashMap<>();
    private static final Map<String, String> CONCUR_SL_MAP = new ConcurrentSkipListMap<>();
    private static final Map<String, String> LINKED_MAP = new LinkedHashMap<>();
    private static final Map<String, String> ID_MAP = new IdentityHashMap<>();

    static {
        for (int i = 0; i < 1000000; ++i) {
            HASH_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            TREE_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            CONCUR_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            CONCUR_SL_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            LINKED_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            ID_MAP.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
    }

    @Benchmark
    public void hashmap_keyset(Blackhole blackhole) {
        for (String key : HASH_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(HASH_MAP.get(key));
        }
    }

    @Benchmark
    public void hashmap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : HASH_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    @Benchmark
    public void treemap_keyset(Blackhole blackhole) {
        for (String key : TREE_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(TREE_MAP.get(key));
        }
    }

    @Benchmark
    public void treemap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : TREE_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    @Benchmark
    public void conhashmap_keyset(Blackhole blackhole) {
        for (String key : CONCUR_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(CONCUR_MAP.get(key));
        }
    }

    @Benchmark
    public void conhashmap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : CONCUR_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    @Benchmark
    public void skiplistmap_keyset(Blackhole blackhole) {
        for (String key : CONCUR_SL_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(CONCUR_SL_MAP.get(key));
        }
    }

    @Benchmark
    public void skiplistmap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : CONCUR_SL_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    @Benchmark
    public void linkedhashmap_keyset(Blackhole blackhole) {
        for (String key : LINKED_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(LINKED_MAP.get(key));
        }
    }

    @Benchmark
    public void linkedhashmap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : LINKED_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    @Benchmark
    public void idmap_keyset(Blackhole blackhole) {
        for (String key : ID_MAP.keySet()) {
            blackhole.consume(key);
            blackhole.consume(ID_MAP.get(key));
        }
    }

    @Benchmark
    public void idmap_entryset(Blackhole blackhole) {
        for (Entry<String, String> entry : ID_MAP.entrySet()) {
            blackhole.consume(entry.getKey());
            blackhole.consume(entry.getValue());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(MapCollection.class.getSimpleName()).warmupIterations(10)
                .measurementIterations(20).forks(1).build();

        new Runner(opt).run();
    }
}
