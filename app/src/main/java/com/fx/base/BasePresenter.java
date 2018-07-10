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

/**抽象，继承，多态
 * 这个是Presenter的基础类，可要可不要，这里是提取presenter中都要用到的方法
 * 所以实现BasePresenter的都有了  void start(); 方法。就不需要再单独的每个presenter中都写void start()
 * 不要复制粘贴，手敲
 */
public interface BasePresenter {
    //这个start是为了与acivity的onstart（页面的生命周期绑定的具体看实际需要）
    //比如你需要再onresume里面做数据刷新，这里可以写 resume ，具体看实际需要
    void start();

}
