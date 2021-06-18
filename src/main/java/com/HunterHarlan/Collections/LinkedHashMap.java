package com.HunterHarlan.Collections;

import com.HunterHarlan.HashFunction.Hashing;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * LinkedHashMap implementation which is used to cache Product objects.
 * @param <K>
 * @param <Product>
 * @author Hunter Shaw
 * @version 0.1
 */
public class LinkedHashMap<K, Product> extends Hashing implements Map<K, Product>, Serializable {
    private int size;
    private Object[] entries;


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public boolean containsKey(Object o) {
        return false;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product get(Object o) {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product put(K k, Product product) {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product remove(Object o) {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public void putAll(Map<? extends K, ? extends Product> map) {

    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public void clear() {

    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Set<K> keySet() {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Collection<Product> values() {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Set<Entry<K, Product>> entrySet() {
        return null;
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product getOrDefault(Object key, Product defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public void forEach(BiConsumer<? super K, ? super Product> action) {
        Map.super.forEach(action);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public void replaceAll(BiFunction<? super K, ? super Product, ? extends Product> function) {
        Map.super.replaceAll(function);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product putIfAbsent(K key, Product value) {
        return Map.super.putIfAbsent(key, value);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public boolean replace(K key, Product oldValue, Product newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product replace(K key, Product value) {
        return Map.super.replace(key, value);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product computeIfAbsent(K key, Function<? super K, ? extends Product> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product computeIfPresent(K key, BiFunction<? super K, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product compute(K key, BiFunction<? super K, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    /*
    TODO: Finish method implementation
     */
    @Override
    public Product merge(K key, Product value, BiFunction<? super Product, ? super Product, ? extends Product> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}
