package ru.job4j.collection.treesort;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenAscJobWithEqualPriorityButDifferentName() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 25),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 25),
                        new Job("Petr", 26),
                        new Job("Ivan", 27),
                        new Job("Ivan", 29),
                        new Job("Ivan", 31),
                        new Job("Petr", 35)
                )
        );
        Collections.sort(jobs, new SortByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenAscForJobWithEqualNameButDifferentPriority() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 25),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Ivan", 31),
                        new Job("Ivan", 29),
                        new Job("Ivan", 27),
                        new Job("Petr", 35),
                        new Job("Petr", 25),
                        new Job("Petr", 26)
                )
        );
        Collections.sort(jobs, new SortByNameJob());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenDescForJobWithEqualNameButDifferentPriority() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 25),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Petr", 25),
                        new Job("Petr", 26),
                        new Job("Ivan", 31),
                        new Job("Ivan", 29),
                        new Job("Ivan", 27)
                )
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenDescJobWithEqualPriorityButDifferentName() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 25),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Ivan", 29),
                        new Job("Ivan", 27),
                        new Job("Petr", 26),
                        new Job("Petr", 25)
                )
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobWithEqualDescPriorityButAscName() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 31),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 31),
                        new Job("Ivan", 29),
                        new Job("Ivan", 27),
                        new Job("Petr", 26)
                )
        );
        Collections.sort(jobs, new JobDescByPriority().thenComparing(new SortByNameJob()));
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobWithEqualAscNameButAscPriority() {
        List<Job> jobs = new ArrayList<>(
                Arrays.asList(
                        new Job("Petr", 35),
                        new Job("Ivan", 31),
                        new Job("Petr", 31),
                        new Job("Ivan", 29),
                        new Job("Petr", 26),
                        new Job("Ivan", 27)
                )
        );
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Ivan", 27),
                        new Job("Ivan", 29),
                        new Job("Ivan", 31),
                        new Job("Petr", 26),
                        new Job("Petr", 31),
                        new Job("Petr", 35)
                )
        );
        Collections.sort(jobs, new SortByNameJob().thenComparing(new SortByPriority()));
        assertThat(jobs).isEqualTo(expected);
    }
}