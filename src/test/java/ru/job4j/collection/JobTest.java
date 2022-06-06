package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("first", 1),
                new Job("first", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAskPriorityAndDeskByName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("first", 1),
                new Job("second", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("first", 1),
                new Job("first", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("first", 1),
                new Job("second", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("first", 1),
                new Job("second", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("first", 1),
                new Job("second", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("first", 1),
                new Job("second", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}