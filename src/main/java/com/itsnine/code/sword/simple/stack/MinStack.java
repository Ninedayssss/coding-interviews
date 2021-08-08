package com.itsnine.code.sword.simple.stack;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 自己定义栈的数据结构，在该类型中实现一个能得到栈的最小元素的min函数的在该栈中，调用min/pop/push的时间复杂度都是O(1)
 *
 * <p>
 * stack继承了Vector
 * stack.pop与stack.peek的区别：
 * 1.两个函数均返回的是栈的栈顶值（出栈）
 * 2.push会将栈顶的值移除，peek不会移除栈顶值
 * <p>
 * stack.add与stack.push的区别：
 * 1.两个函数均为往栈中压值
 * 2.stack继承vector，add是实现List接口重写的方法（返回值boolean），addElement为Vector的特有方法（返回值void）。两个函数的作用完全相同
 * </p>
 *
 * @author xu.sun
 * @create 2021-08-05-10:18 下午
 */
public class MinStack {
    Stack<Integer> A, B;

    //栈初始化,A为正常栈，B为辅助栈（非严格降序，当栈顶的值小于新push的值时，不会压入栈中）
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    //A正常压栈，当B为空时或B的栈顶值小于入栈值时才会压入B栈
    public void push(int value) {
        A.add(value);
        if (B.empty() || B.peek() >= value) {
            B.add(value);
        }
    }

    //A栈正常出栈，当B栈的栈顶值与A栈出栈值相同时，B栈出栈，保持两栈元素一致性
    public void pop() {
        Integer val = A.pop();
        if (B.peek().equals(val)) {
            B.pop();
        }
    }

    //top返回A栈的栈顶值
    public int top() {
        return A.peek();
    }

    //min返回B栈的栈顶值
    public int min() {
        return B.peek();
    }

}
