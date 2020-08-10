package chap02;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName Test
 * @Description TODO
 * @Author iematthew
 * @Date 2020/7/13 11:44
 * @Version 1.0
 **/

/*
测试类
 */
public class Test {
    public static void main(String[] args) {
        Comparable[] a = {10,1,2,8,4,3,12,3,8,9,100,56,41};
        //SelectionSort.sort(a);
        //InsertionSort.sort(a);
        //ShellSort.sort(a);
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));

    }
}

class People{
    private int age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}