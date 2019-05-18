package com.photo.common.tools;

public class Hello {
    private String str;
    public Hello (String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Hello h = new Hello("aaa");
        Hello b = h;
        h.setStr("bbb");
        System.out.println(b.getStr());
    }
}
