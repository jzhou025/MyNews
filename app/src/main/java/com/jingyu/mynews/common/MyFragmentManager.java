package com.jingyu.mynews.common;

import android.os.Bundle;

public interface MyFragmentManager {

    void doFragmentTransaction(MyBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);
}

