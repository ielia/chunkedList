package com.olenick.programmingCourse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ChunkedListTest {
    @Test
    void testChunkedListEmptyConstructorDoesNotFail() {
        new ChunkedList<Integer>();
    }

    @Disabled
    @Test
    void testChunkedListChunkSizeFailsOnZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChunkedList<Integer>(0);
        });
    }

    @Disabled
    @Test
    void testChunkedListChunkSizeFailsOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChunkedList<Integer>(-16);
        });
    }

    @Test
    void testChunkedListChunkSizeSucceedsOnPositive() {
        new ChunkedList<Integer>(128);
    }

    @Disabled
    @Test
    void testChunkedListFinalChunkMaxOccupancyFailsOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChunkedList<Integer>(-.5);
        });
    }

    @Disabled
    @Test
    void testChunkedListFinalChunkMaxOccupancyFailsOnGreaterThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ChunkedList<Integer>(1.1);
        });
    }

    @Test
    void testChunkedListFinalChunkMaxOccupancySucceedsOnZeroOneOpenRange() {
        new ChunkedList<Integer>(0.5);
    }

    @Test
    void testChunkedListFinalChunkMaxOccupancySucceedsOnOne() {
        new ChunkedList<Integer>(1.0);
    }

    @Disabled
    @Test
    void testRecentlyCreatedChunkedListIsEmpty() {
        assertTrue(new ChunkedList<Integer>().isEmpty());
    }

    @Disabled
    @Test
    void testChunkedListCanReceiveElements() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>();
        chunkedList.add(1);
        assertTrue(chunkedList.contains(1));
    }

    @Disabled
    @Test
    void testChunkedListWithElementsReturnsCorrectSize() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.add(0);
        chunkedList.add(1);
        chunkedList.add(2);
        chunkedList.add(3);
        chunkedList.add(4);
        chunkedList.add(5);
        chunkedList.add(6);
        chunkedList.add(7);
        assertEquals(8, chunkedList.size());
    }

    @Disabled
    @Test
    void testChunkedListCanReceiveCollection() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(8, chunkedList.size());
    }

    @Disabled
    @Test
    void testChunkedListContainsInitialElements() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>(Arrays.asList(0, 2));
        assertTrue(chunkedList.contains(0));
        assertFalse(chunkedList.contains(1));
        assertTrue(chunkedList.contains(2));
        assertFalse(chunkedList.contains(3));
    }

    @Disabled
    @Test
    void testChunkedListContainsOnlyAddedElements() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.add(0);
        chunkedList.add(2);
        assertTrue(chunkedList.contains(0));
        assertFalse(chunkedList.contains(1));
        assertTrue(chunkedList.contains(2));
        assertFalse(chunkedList.contains(3));
    }

    @Disabled
    @Test
    void testChunkedListContainsAllAddedElements() {
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.addAll(Arrays.asList(0, 2));
        assertTrue(chunkedList.contains(0));
        assertFalse(chunkedList.contains(1));
        assertTrue(chunkedList.contains(2));
        assertFalse(chunkedList.contains(3));
    }

    @Disabled
    @Test
    void testCanInsertElementsIntoChunkedList() {
        List<Integer> collection = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.addAll(collection);
        List<Integer> expectedResult = Arrays.asList(0, 1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 6, 7, 8, 9, 10);
        chunkedList.addAll(6, Arrays.asList(11, 12, 13, 14, 15));
        int i = 0;
        for (Integer expected : expectedResult) {
            assertEquals(expected, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testCanInsertAnElementIntoChunkedList() {
        List<Integer> collection = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ChunkedList<Integer> chunkedList = new ChunkedList<>(4, 0.5);
        chunkedList.addAll(collection);
        List<Integer> expectedResult = Arrays.asList(0, 1, 2, 3, 4, 5, 11, 6, 7, 8, 9, 10);
        chunkedList.add(6, 11);
        int i = 0;
        for (Integer expected : expectedResult) {
            assertEquals(expected, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testChunkedListCanBeIterated() {
        ChunkedList<String> chunkedList = new ChunkedList<>(4, 0.5);
        List<String> collection = Arrays.asList("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta");
        chunkedList.addAll(collection);
        Iterator<String> iterator = chunkedList.iterator();

        for (String expected : collection) {
            assertTrue(iterator.hasNext());
            assertEquals(expected, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Disabled
    @Test
    void testChunkedListCanBeConvertedToArrayOfObjects() {
        ChunkedList<String> chunkedList = new ChunkedList<>(4, 0.5);
        List<String> collection = Arrays.asList("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta");
        chunkedList.addAll(collection);
        Object[] array = chunkedList.toArray();
        assertEquals(collection.size(), array.length);
        int i = 0;
        for (String expected : collection) {
            assertEquals(expected, array[i++]);
        }
    }

    @Disabled
    @Test
    void testChunkedListCanBeConvertedToArrayOfType() {
        ChunkedList<String> chunkedList = new ChunkedList<>(4, 0.5);
        List<String> collection = Arrays.asList("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta");
        chunkedList.addAll(collection);
        String[] array = chunkedList.toArray(new String[0]);
        assertEquals(collection.size(), array.length);
        int i = 0;
        for (String expected : collection) {
            assertEquals(expected, array[i++]);
        }
    }

    @Disabled
    @Test
    void testChunkedListCanBeConvertedToSameArrayOfType() {
        ChunkedList<String> chunkedList = new ChunkedList<>(4, 0.5);
        List<String> collection = Arrays.asList("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta");
        chunkedList.addAll(collection);
        String[] targetArray = new String[16];
        String[] array = chunkedList.toArray(new String[16]);
        assertEquals(collection.size(), array.length);
        assertEquals(targetArray, array);
        int i = 0;
        for (String expected : collection) {
            assertEquals(expected, array[i++]);
        }
        for (; i < 16; ++i) {
            assertNull(array[i++]);
        }
    }

    @Disabled
    @Test
    void testElementCanBeRemovedFromChunkedList() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b"));
        assertTrue(chunkedList.contains("a"));
        assertTrue(chunkedList.remove("a"));
        assertFalse(chunkedList.contains("a"));
        assertTrue(chunkedList.contains("b"));
    }

    @Test
    void testRemovingElementFromEmptyChunkedListReturnsFalse() {
        ChunkedList<String> chunkedList = new ChunkedList<>();
        assertFalse(chunkedList.contains("a"));
        assertFalse(chunkedList.remove("a"));
    }

    @Disabled
    @Test
    void testRemovingElementMultipleTimesFromChunkedList() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b"));
        assertTrue(chunkedList.contains("a"));
        assertTrue(chunkedList.remove("a"));
        assertFalse(chunkedList.remove("a"));
        assertFalse(chunkedList.remove("a"));
        assertFalse(chunkedList.contains("a"));
        assertTrue(chunkedList.contains("b"));
    }

    @Disabled
    @Test
    void testElementAtIndexCanBeRemovedFromChunkedList() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b"));
        assertTrue(chunkedList.contains("b"));
        chunkedList.remove(1);
        assertFalse(chunkedList.contains("b"));
        assertTrue(chunkedList.contains("a"));
    }

    @Disabled
    @Test
    void testChunkedListContainsAllItsElements() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertTrue(chunkedList.containsAll(Arrays.asList("a", "c", "e")));
        assertTrue(chunkedList.containsAll(collection));
    }

    @Test
    void testChunkedListReturnsFalseOnContainsAllWithMixedElements() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertFalse(chunkedList.containsAll(Arrays.asList("a", "c", "f")));
    }

    @Disabled
    @Test
    void testMultipleElementsCanBeRemovedFromChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRemove = Arrays.asList("a", "c", "e");
        assertTrue(chunkedList.containsAll(collectionToRemove));
        assertTrue(chunkedList.removeAll(collectionToRemove));
        for (String element : collectionToRemove) {
            assertFalse(chunkedList.contains(element));
        }
    }

    @Disabled
    @Test
    void testMixedElementsReturnTrueWhenRemovedAllFromChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRemove = Arrays.asList("a", "c", "f");
        assertFalse(chunkedList.containsAll(collectionToRemove));
        assertTrue(chunkedList.removeAll(collectionToRemove));
        for (String element : collectionToRemove) {
            assertFalse(chunkedList.contains(element));
        }
    }

    @Test
    void testNonElementsReturnFalseWhenRemovedAllFromChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRemove = Arrays.asList("f", "g", "h");
        assertFalse(chunkedList.containsAll(collectionToRemove));
        assertFalse(chunkedList.removeAll(collectionToRemove));
    }

    @Disabled
    @Test
    void testElementsAreRetainedInChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRetain = Arrays.asList("a", "c", "e");
        assertTrue(chunkedList.retainAll(collectionToRetain));
        for (String element : collection) {
            assertEquals(collectionToRetain.contains(element), chunkedList.contains(element));
        }
    }

    @Disabled
    @Test
    void testMultipleEqualElementsAreRetainedInChunkedList() {
        List<String> collection = Arrays.asList("a", "a", "b", "c", "a", "d");
        List<String> expectedResult = Arrays.asList("a", "a", "c", "a");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRetain = Arrays.asList("a", "c", "e");
        assertTrue(chunkedList.retainAll(collectionToRetain));
        assertEquals(expectedResult.size(), chunkedList.size());
        int i = 0;
        for (String element : expectedResult) {
            assertEquals(element, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testRetainingAllElementsResultInFalse() {
        List<String> collection = Arrays.asList("a", "a", "b", "c", "a", "d");
        List<String> expectedResult = new LinkedList<>(collection);
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> collectionToRetain = Arrays.asList("a", "b", "c", "d");
        assertFalse(chunkedList.retainAll(collectionToRetain));
        assertEquals(expectedResult.size(), chunkedList.size());
        int i = 0;
        for (String element : expectedResult) {
            assertEquals(element, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testClearingChunkedList() {
        List<String> collection = Arrays.asList("a", "a", "b", "c", "a", "d");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        chunkedList.clear();
        assertTrue(chunkedList.isEmpty());
    }

    @Disabled
    @Test
    void testGettingWithNegativeIndexFromChunkedListThrowsException() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            chunkedList.get(-1);
        });
    }

    @Disabled
    @Test
    void testGettingWithIndexTooHighFromChunkedListThrowsException() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            chunkedList.get(1000);
        });
    }

    @Disabled
    @Test
    void testElementsCanBeGotFromChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        int i = 0;
        for (String expected : collection) {
            assertEquals(expected, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testSettingWithNegativeIndexIntoChunkedListThrowsException() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            chunkedList.set(-1, "x");
        });
    }

    @Disabled
    @Test
    void testSettingWithIndexTooHighIntoChunkedListThrowsException() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            chunkedList.set(1000, "x");
        });
    }

    @Disabled
    @Test
    void testElementsCanBeSetIntoChunkedList() {
        List<String> collection = Arrays.asList("a", "b", "c", "d", "e");
        ChunkedList<String> chunkedList = new ChunkedList<>(collection);
        List<String> expectedResult = Arrays.asList("f", "g", "h", "i", "j");
        int i = 0;
        for (String expected : expectedResult) {
            assertEquals(collection.get(i), chunkedList.set(i++, expected));
        }
        i = 0;
        for (String expected : expectedResult) {
            assertEquals(expected, chunkedList.get(i++));
        }
    }

    @Disabled
    @Test
    void testIndexOfOnAnEmptyChunkedListReturnsMinusOne() {
        ChunkedList<String> chunkedList = new ChunkedList<>();
        assertEquals(-1, chunkedList.indexOf(""));
    }

    @Disabled
    @Test
    void testIndexOfOnAnElementNotInChunkedListReturnsMinusOne() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b", "c"));
        assertEquals(-1, chunkedList.indexOf("d"));
    }

    @Disabled
    @Test
    void testIndexOfOnAnElementInChunkedListReturnsItsFirstOccurrence() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b", "c", "b", "d"));
        assertEquals(1, chunkedList.indexOf("b"));
    }

    @Disabled
    @Test
    void testLastIndexOfOnAnEmptyChunkedListReturnsMinusOne() {
        ChunkedList<String> chunkedList = new ChunkedList<>();
        assertEquals(-1, chunkedList.lastIndexOf(""));
    }

    @Disabled
    @Test
    void testLastIndexOfOnAnElementNotInChunkedListReturnsMinusOne() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b", "c"));
        assertEquals(-1, chunkedList.lastIndexOf("d"));
    }

    @Disabled
    @Test
    void testLastIndexOfOnAnElementInChunkedListReturnsItsLastOccurrence() {
        ChunkedList<String> chunkedList = new ChunkedList<>(Arrays.asList("a", "b", "c", "b", "d"));
        assertEquals(3, chunkedList.indexOf("b"));
    }
}
