package com.HunterHarlan.Collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LinkedHashMap<K, Product> implements Map<K, Product> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    @Override
    public Product get(Object o) {
        return null;
    }

    @Override
    public Product put(K k, Product product) {
        return null;
    }

    @Override
    public Product remove(Object o) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends Product> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<Product> values() {
        return null;
    }

    @Override
    public Set<Entry<K, Product>> entrySet() {
        return null;
    }

    @Override
    public Product getOrDefault(Object key, Product defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super Product> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super Product, ? extends Product> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public Product putIfAbsent(K key, Product value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(K key, Product oldValue, Product newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public Product replace(K key, Product value) {
        return Map.super.replace(key, value);
    }

    @Override
    public Product computeIfAbsent(K key, Function<? super K, ? extends Product> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Product computeIfPresent(K key, BiFunction<? super K, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Product compute(K key, BiFunction<? super K, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public Product merge(K key, Product value, BiFunction<? super Product, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}
