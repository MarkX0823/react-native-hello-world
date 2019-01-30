package com.markx0823dev.helloworldreactnative;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MyMathAndroidTest {

    @Test
    public void add() {
        // arrange
        int first = 1;
        int second = 2;
        int expect = 3;
        MyMath myMath = new MyMath();

        // act
        int actual = myMath.add(first, second);

        // assert
        assertEquals(expect, actual);
    }

    @Test
    public void multiple() {
        // arrange
        int first = 3;
        int second = 5;
        int expect =15;
        MyMath myMath = new MyMath();

        // act
        int actual = myMath.multiple(first, second);

        // assert
        assertEquals(expect, actual);
    }

    @Test
    public void sampleAssertSame() {
        // arrange
        Object expect = new Object();
        Object expectNotSame = new Object();
        Object actual = expect;

        // assert
        assertSame(expect, actual);
        assertNotSame(expectNotSame, actual);
    }

    @Test
    public void sampleAssertNull() {
        // arrange
        Object expectNull = null;
        Object expectNotNull = new Object();

        // assert
        assertNull(expectNull);
        assertNotNull(expectNotNull);
    }

    @Test
    public void sampleAssertArrayEquals() {
        // arrange
        int[] expect = new int[]{1, 2, 3};
        int[] actual = new int[]{1, 2, 3};

        // assert
        assertArrayEquals(expect, actual);
    }

    @Test
    public void sampleAssertCollection() {
        // arrange
        List<Integer> expect = Arrays.asList(1, 2, 3);
        List<Integer> actual = Arrays.asList(1, 2, 3);

        // assert
        assertEquals(expect, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void sampleAssertException() {
        // arrange
        int[] sampleArr = new int[]{1, 2, 3};

        // assert
        int indexOutOfBoundNumber = sampleArr[3];
    }
}