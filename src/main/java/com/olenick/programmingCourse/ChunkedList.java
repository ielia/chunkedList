package com.olenick.programmingCourse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ChunkedList: List of arrays of "chunkSize" {@link #ChunkedList(int)}. It consists of a linked list of primitive
 * arrays, which when recently created at the end of the list, will only get filled up to the configured occupancy
 * percentage. Later modifications of non-final chunks will not respect maximum occupancy.
 *
 * @param <E> Type of elements.
 */
public class ChunkedList<E> implements List<E> {
    static final int DEFAULT_CHUNK_SIZE = 32;
    static final double DEFAULT_FINAL_CHUNK_MAX_OCCUPANCY = 0.75;

    /**
     * Constructs an empty list with the default chunk size and final chunk max occupancy.
     */
    public ChunkedList() {
    }

    /**
     * Constructs an empty list with the specified chunk size and default final chunk max occupancy.
     *
     * @param chunkSize Chunk size.
     * @throws IllegalArgumentException if chunkSize is less than or equal to 0.
     */
    public ChunkedList(int chunkSize) {
    }

    /**
     * Constructs an empty list with the specified final chunk max occupancy and default chunk size.
     *
     * @param finalChunkMaxOccupancy Maximum occupancy of the final chunk.
     * @throws IllegalArgumentException if finalChunkMaxOccupancy is less than or equal to 0 or if greater than 1.
     */
    public ChunkedList(double finalChunkMaxOccupancy) {
    }

    /**
     * Constructs an empty list with the specified chunk size and final chunk max occupancy.
     *
     * @param chunkSize Chunk size.
     * @param finalChunkMaxOccupancy Maximum occupancy of the final chunk.
     * @throws IllegalArgumentException if chunkSize is less than or equal to 0,
     *         or if finalChunkMaxOccupancy is less than or equal to 0 or greater than 1.
     */
    public ChunkedList(int chunkSize, double finalChunkMaxOccupancy) {
    }

    /**
     * Constructs a list containing the elements of the specified collection, in the order they are returned by the
     * collection's iterator.
     *
     * @param collection The collection which elements are to be placed into this list.
     * @throws NullPointerException if the specified collection is null
     */
    public ChunkedList(Collection<? extends E> collection) {
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
     * specified collection's Iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).  The new elements will appear
     * in the list in the order that they are returned by the
     * specified collection's iterator.
     *
     * @param index Insertion index.
     * @param collection Collection to be inserted.
     * @return <tt>true</tt> if this list changed as a result of the call.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.  In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     *
     * @param collection Collection of elements to retain.
     * @return {@code true} if this list changed as a result of the call.
     * @throws ClassCastException if the class of an element of this list
     *         is incompatible with the specified collection.
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     *         specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see Collection#contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public void add(int index, E element) {
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * DO NOT IMPLEMENT.
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * DO NOT IMPLEMENT.
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * DO NOT IMPLEMENT.
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
