package com.markx0823dev.helloworldreactnative;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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

    @Test
    public void sampleAssertThat() {
        // arrange
        List<Integer> expect = Arrays.asList(0, 1, 2, 3, 4);

        // assert
        assertThat(expect, CoreMatchers.everyItem(Matchers.lessThan(5)));
    }

    @Mock
    private MyMathLogger mockLogger = new MyMathLogger();

    @Test
    public void sampleLogCallOnce() {
        // arrange
        MockitoAnnotations.initMocks(this);

        // act
        MyMath myMath = new MyMath(mockLogger);
        myMath.mockAdd(-1, -2);

        // assert
        Mockito.verify(mockLogger).log(Mockito.anyString());
    }

    @Test
    public void sampleLogCallThreeTimes() {
        // arrange
        MockitoAnnotations.initMocks(this);
        int expectCallTimes = 3;
        MyMath myMath = new MyMath(mockLogger);

        // act
        myMath.mockAdd(-1, 2);
        myMath.mockAdd(1, -2);
        myMath.mockAdd(3, 100);
        myMath.mockAdd(0, -2);
        myMath.mockAdd(-999, 33);
        myMath.mockAdd(-999, 1000);

        // assert
        Mockito.verify(mockLogger, Mockito.times(expectCallTimes)).log(Mockito.anyString());
    }
}