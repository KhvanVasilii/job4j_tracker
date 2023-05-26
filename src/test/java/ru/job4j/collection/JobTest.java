package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenSortByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Test b", 2),
                new Job("Test c", 3),
                new Job("Test a", 1)
        );
        jobs.sort(new SortByNameJob());
        List<Job> expected = Arrays.asList(
                new Job("Test a", 1),
                new Job("Test b", 2),
                new Job("Test c", 3)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenSortByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Test c", 5),
                new Job("Test a", 9),
                new Job("Test b", 1)
        );
        jobs.sort(new SortByPriorityJob());
        List<Job> expected = Arrays.asList(
                new Job("Test b", 1),
                new Job("Test c", 5),
                new Job("Test a", 9)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenSortDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Test a", 1),
                new Job("Test b", 2),
                new Job("Test c", 3)
        );
        jobs.sort(new SortDescByNameJob());
        List<Job> expected = Arrays.asList(
                new Job("Test c", 3),
                new Job("Test b", 2),
                new Job("Test a", 1)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Test b", 2),
                new Job("Test c", 1),
                new Job("Test a", 3)
        );
        jobs.sort(new SortDescByPriorityJob());
        List<Job> expected = Arrays.asList(
                new Job("Test a", 3),
                new Job("Test b", 2),
                new Job("Test c", 1)
        );
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortDescByNameJob().thenComparing(new SortDescByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenNamesEqualsAndPriority() {
        Comparator<Job> cmpNamePriority = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new SortDescByNameJob().thenComparing(new SortDescByPriorityJob());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl).isGreaterThan(0);
    }
}