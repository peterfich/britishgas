package com.peterfich.britishgas;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldFindASingleElementSubArray() {
        Optional<Integer> index = new Main().indexOf(new int[]{1, 2, 3, 4}, new int[]{2});

        assertThat(index).isPresent();
        assertThat(index.get()).isEqualTo(1);
    }

    @Test
    public void shouldThrowExceptionIfArrayIsNull() {
        expectedException.expect(IllegalArgumentException.class);

        new Main().indexOf(null, new int[]{1});
    }

    @Test
    public void shouldThrowExceptionIfSubArrayIsNull() {
        expectedException.expect(IllegalArgumentException.class);

        new Main().indexOf(new int[]{1}, null);
    }

    @Test
    public void shouldReturnEmptyIfSunArrayEmpty() {
        Optional<Integer> index = new Main().indexOf(new int[]{1, 2, 3, 4}, new int[]{});

        assertThat(index).isEmpty();
    }

    @Test
    public void shouldReturnEmptyIfSubArrayIsNotInArray() {
        Optional<Integer> index = new Main().indexOf(new int[]{1, 2, 3, 4}, new int[]{4, 5});

        assertThat(index).isEmpty();
    }

    @Test
    public void shouldReturn0IfArrayAndSubArrayAreEqual() {
        Optional<Integer> index = new Main().indexOf(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});

        assertThat(index).isPresent();
        assertThat(index.get()).isEqualTo(0);
    }

    @Test
    public void shouldReturnEmptyIfSubArrayIsLongerThanArray() {
        Optional<Integer> index = new Main().indexOf(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5});

        assertThat(index).isEmpty();

    }
}
