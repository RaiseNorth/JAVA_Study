package io.github.raisenorth.studentsort;

public class Student implements Comparable<Student> {

    private String name;
    private Integer score;
    private Integer id;
    private Integer rank;

    public Student(String name, Integer id, Integer score) {
        this.name = name;
        this.id = id;
        this.score = score;
        this.rank = (score + 1) * 1000 - id;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String returnstr = String.format(" %03d  %s", id, name);
        for (int i = 0; i < (15 - name.length()); i++)
            returnstr = String.format("%s  ", returnstr);
        returnstr = String.format("%s %3d", returnstr, score);
        return returnstr;
    }

    @Override
    public int compareTo(Student a) {
        return a.getRank().compareTo(this.rank);
    }

}