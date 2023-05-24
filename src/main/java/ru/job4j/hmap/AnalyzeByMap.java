package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int scores = 0;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
                counter++;
            }
        }
        return (double) scores / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scores = 0;
            int counter = 0;
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
                counter++;
            }
            rsl.add(new Label(pupil.name(), (double) scores / counter));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(),
                        subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
            counter++;
        }
        for (String subject : subjectScores.keySet()) {
            int score = subjectScores.get(subject);
            rsl.add(new Label(subject, (double) score / counter));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> totalScores = new LinkedList<>();
        for (Pupil pupil : pupils) {
            int scores = 0;
            for (Subject subject : pupil.subjects()) {
                scores += subject.score();
            }
            totalScores.add(new Label(pupil.name(), scores));
        }
        totalScores.sort(Comparator.naturalOrder());
        return totalScores.get(totalScores.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        List<Label> totalScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer score = subjectScores.putIfAbsent(subject.name(), subject.score());
                if (score != null) {
                    subjectScores.put(subject.name(), subject.score() + score);
                }
            }
        }
        for (String subject : subjectScores.keySet()) {
            int score = subjectScores.get(subject);
            totalScores.add(new Label(subject, score));
        }
        totalScores.sort(Comparator.naturalOrder());
        return totalScores.get(totalScores.size() - 1);
    }
}
