package com.example.kwicdemo.KWIC.demo3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * Alphabetizer类用于对字符串进行字母排序
 * 它实现了Observer接口，可以作为KWIC系统的一个观察者
 */
public class Alphabetizer implements Observer, Serializable {

    // 序列化版本号
    private static final long serialVersionUID = 1L;

    // 存储字符串的列表
    private ArrayList<String> kwicList;

    /**
     * 构造方法，接收一个字符串列表作为参数
     * @param kwicList 字符串列表
     */
    public Alphabetizer(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    /**
     * 获取字符串列表的方法
     * @return 字符串列表
     */
    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    /**
     * 实现观察者接口的方法，用于执行字母排序的操作
     */
    @Override
    public void toDo() {
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    /**
     * 重写equals方法，用于判断两个Alphabetizer对象是否相等
     * @param o 另一个对象
     * @return 布尔值，表示是否相等
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alphabetizer that = (Alphabetizer) o;
        return Objects.equals(kwicList, that.kwicList);
    }

    /**
     * 重写hashCode方法，用于生成对象的哈希值
     * @return 整数，表示对象的哈希值
     */
    @Override
    public int hashCode() {
        return Objects.hash(kwicList);
    }

    /**
     * 内部类，用于实现Comparator接口，定义字符串的比较规则
     */
    private static class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
            compareValue = o1c - o2c;
            return compareValue;

        }

    }

}
