/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fx.base;

/**
 * view的基础类
 * @param <T>presenter 给view注入presenter对象，
 *           目的是能在view中通过presenter来处理具体业务，达到业务，界面分离
 *
 * T代表Object ，意思就是所有的对象都可以当做参数setPresenter 传进来，这个能懂？嗯
 *  这个是多态的一个体现，
 */
public interface BaseView<T> {
    //注入presenter
    void setPresenter(T presenter);

}
