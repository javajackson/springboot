package com.example.springboot.java8shizhanpdf;

import com.example.springboot.java8shizhanpdf.domain.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/28  19:29
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test1 {
    public static void main(String[] args) {
        Apple apple1 = new Apple("green",90);
        Apple apple2 = new Apple("red",100);
        Apple apple3 = new Apple("green",140);
        Apple apple4 = new Apple("red",150);
        Apple apple5 = new Apple("green",190);
        Apple apple6 = new Apple("red",200);

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
        inventory.add(apple6);

//        List<Apple> result = filterGreenApple(inventory); 需求一
//        List<Apple> result =  filterAppleByColor(inventory, "green"); 需求二
//        List<Apple> result = filterApple(inventory, new AppleGreenColorPredicate()); //绿色苹果
//        List<Apple> result = filterApple(inventory, new AppleHeavyWeightPredicate());  //重量大于等于140的苹果
        //重量大于等于140且颜色是红色的苹果
//        List<Apple> result = filterApple(inventory, new AppleRedAndHeavyPredicate());
        //第六次尝试
//        List<Apple> result = filterApple(inventory, apple -> "green".equals(apple.getColor()));

        List<Apple> redApple = filter(inventory, apple -> apple.getColor().equals("red"));

//        System.out.println(result);

        System.out.println(redApple);

    }

    /**
     * 需求一：筛选出绿色的苹果
     * @param inventory
     * @return
     */
    private static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :inventory) {
            if (apple.getColor().equals("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 需求二：根据颜色筛选出苹果
     * @param inventory
     * @return
     */
    private static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 需求三：根据重量筛选苹果
     * @param inventory
     * @param weight
     * @return
     */
    private static List<Apple> filterAppleByWeight(List<Apple> inventory, Integer weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :inventory) {
            if (apple.getWeight() >= weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 第四次尝试：根据抽象条件筛选
     * @param inventory
     * @param p
     * @return
     */
    private static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 第七次尝试：
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
