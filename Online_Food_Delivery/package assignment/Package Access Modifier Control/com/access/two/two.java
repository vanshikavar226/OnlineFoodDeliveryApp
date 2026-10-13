package com.access.two;
import com.access.one.Base;

public class Derived extends Base {
    public void test() {
        pub();
        pro();
        // def(); ❌
        // pri(); ❌
    }
}
