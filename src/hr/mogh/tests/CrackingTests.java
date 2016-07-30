package hr.mogh.tests;

import hr.mogh.crackingthecodinginterview.ch1.*;
import hr.mogh.crackingthecodinginterview.ch2.*;
import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains tests that ensure that all solution to problems from Cracking the Coding Interview work properly.<br/>
 * Created by vlado on 6.1.2016.
 */
public class CrackingTests {

    @Test
    public void uniqueCharacterTest_uniqueCharacters() {
        String input = "s0dleog7��]��23bm<";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharacters(input);
        Assert.assertTrue(allCharactersUnique);
    }

    @Test
    public void uniqueCharacterTest_nonUniqueCharacters() {
        String input = "sodkfirjauu29103p.cbn";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharacters(input);
        Assert.assertFalse(allCharactersUnique);
    }

    @Test
    public void uniqueCharactersNoExtraDataStructuresTest_uniqueCharacters() {
        String input = "s0dleog7��]��23bm<";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharactersNoExtraDataStructures(input);
        Assert.assertTrue(allCharactersUnique);
    }

    @Test
    public void uniqueCharactersNoExtraDataStructuresTest_nonUniqueCharacters() {
        String input = "sodkfirjauu29103p.cbn";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharactersNoExtraDataStructures(input);
        Assert.assertFalse(allCharactersUnique);
    }

    @Test
    public void isPermutationCheckTest_true() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirv";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertTrue(isPermutation);
    }

    @Test
    public void isPermutationCheckTest_false() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirr";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }

    @Test
    public void isPermutationCheckTest_differentLength() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweir";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }

    @Test
    public void insertSpaceSymbolsTest() {
        char[] input = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        char[] expectedOutput = {'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'};
        char[] output = SpaceReplacer.replaceSpaces(input);
        Assert.assertTrue(areEqual(expectedOutput, output));
    }

    @Test
    public void insertSpaceSymbolsTest_spaceInFront() {
        char[] input = {' ', 'a', ' ', ' '};
        char[] expectedOutput = {'%', '2', '0', 'a'};
        char[] output = SpaceReplacer.replaceSpaces(input);
        Assert.assertTrue(areEqual(expectedOutput, output));
    }

    public boolean areEqual(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        boolean areEqual = true;

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }

    @Test
    public void compressStringTest() {
        String input = "aabcccccaaa";
        String expectedOutput = "a2b1c5a3";
        String output = StringCompressor.compressString(input);
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void compressStringTest_producesLongerString() {
        String input = "abcd";
        String output = StringCompressor.compressString(input);
        Assert.assertEquals(input, output);
    }

    @Test
    public void rotateImageTest_3x3Matrix() {
        short[][] image = new short[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        short[][] rotatedImage = new short[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        ImageRotator.rotateImage(image);
        Assert.assertTrue(areMatricesEqual(rotatedImage, image));
    }

    @Test
    public void rotateImageTest_4x4Matrix() {
        short[][] image = new short[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        short[][] rotatedImage = new short[][]{{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        ImageRotator.rotateImage(image);
        Assert.assertTrue(areMatricesEqual(rotatedImage, image));
    }

    @Test
    public void zeroOutMatrix() {
        short[][] matrix = new short[][]{{1, 2, 0, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        short[][] expectedResult = new short[][]{{0, 0, 0, 0}, {5, 6, 0, 8}, {9, 10, 0, 12}};
        MatrixZeroing.zeroOut(matrix);
        Assert.assertTrue(areMatricesEqual(expectedResult, matrix));
    }

    @Test
    public void zeroOutMatrix_overlappingZeroes() {
        short[][] matrix = new short[][]{{1, 2, 0, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        short[][] expectedResult = new short[][]{{0, 0, 0, 0}, {5, 6, 0, 0}, {9, 10, 0, 0}};
        MatrixZeroing.zeroOut(matrix);
        Assert.assertTrue(areMatricesEqual(expectedResult, matrix));
    }

    @Test
    public void rotatedStringDetector_isRotated() {
        String original = "waterbottle";
        String rotated = "erbottlewat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertTrue(isRotated);
    }

    @Test
    public void rotatedStringDetector_isNotRotated() {
        String original = "waterbottle";
        String rotated = "rbottlewat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertFalse(isRotated);
    }

    @Test
    public void rotatedStringDetector_rotatedStringTooSmall() {
        String original = "waterbottle";
        String rotated = "wat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertFalse(isRotated);
    }

    @Test
    public void pruneLinkedList_withBuffer() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListPruner.pruneLinkedListWithBuffer(listRoot);

        Assert.assertEquals(4, listRoot.size());
    }

    @Test
    public void pruneLinkedList_withoutBuffer() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListPruner.pruneLinkedList(listRoot);

        Assert.assertEquals(4, listRoot.size());
    }

    @Test
    public void findKthToLastNode() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListNode foundNode = ListNodeFinder.findKthToLastElement(4, listRoot);
        Assert.assertEquals("C", foundNode.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKthToLastNode_tooFewElements() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListNodeFinder.findKthToLastElement(4, listRoot);
    }

    @Test
    public void removeNodeFromList() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "D", "E"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listNode = list.getFirstNode();
        listNode = listNode.getNodeAfter();
        ListNodeRemover.removeNode(listNode);
        assertNoValueInList("B", list);
    }

    @Test
    public void removeNodeFromListCorrectly() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "D", "E"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listNode = list.getFirstNode();
        listNode = listNode.getNodeAfter();
        ListNodeRemover.removeNode(listNode);
        assertNoValueInList("B", list);
    }

    @Test
    public void partitionLinkedListAroundValue() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 1, 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 5;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        DoublyLinkedList partitionedList = LinkedListPartitioner.partitionList(list, value);

        assertListPartitionedCorrectly(partitionedList, value);
    }

    @Test
    public void partitionLinkedListAroundValue_allValuesGreater() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 2;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        DoublyLinkedList partitionedList = LinkedListPartitioner.partitionList(list, value);

        assertListPartitionedCorrectly(partitionedList, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void partitionLinkedListAroundValue_pivotDoesntExist() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 22;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        LinkedListPartitioner.partitionList(list, value);
    }

    @Test
    public void sumReverseLists() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 7, 1, 6));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 5, 9, 2));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 2, 1, 9));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumReverseLists_extraCarryOverNode() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 5, 6, 7));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 4, 6, 7, 1));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumReverseLists_oneShorterList() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 6, 7));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 5, 7, 0, 1));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 6, 1, 7));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 2, 9, 5));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 9, 1, 2));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists_extraCarryOverNode() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 7, 6, 5));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 1, 7, 6, 4));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists_oneShorterList() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 7, 6));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 1, 0, 7, 5));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    private void assertListPartitionedCorrectly(DoublyLinkedList partitionedList, int pivotValue) {
        ListNode node = partitionedList.getFirstNode();
        ListNode pivotNode = node;
        while (pivotNode.getNodeAfter() != null && (int) pivotNode.getNodeAfter().getValue() <= pivotValue) {
            pivotNode = pivotNode.getNodeAfter();
        }

        boolean hasPassedPivot = false;
        do {
            if (!hasPassedPivot) {
                Assert.assertTrue(pivotValue >= (int) node.getValue());
            } else {
                Assert.assertTrue(pivotValue < (int) node.getValue());
            }
            if (node == pivotNode) {
                hasPassedPivot = true;
            }
            node = node.getNodeAfter();
        } while (node != null);
    }

    private void assertNoValueInList(String value, DoublyLinkedList list) {
        ListNode node = list.getFirstNode();
        do {
            Assert.assertNotSame(value, node.getValue());
            node = node.getNodeAfter();
        } while (node.getNodeAfter() != null);
    }

    private boolean areMatricesEqual(short[][] expected, short[][] actual) {
        if (expected.length != actual.length || expected[0].length != actual[0].length) {
            return false;
        }
        boolean areEqual = true;
        int rows = expected[0].length;
        int columns = expected.length;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (expected[i][j] != actual[i][j]) {
                    areEqual = false;
                    break;
                }
            }
            if (!areEqual) {
                break;
            }
        }
        return areEqual;
    }
}
