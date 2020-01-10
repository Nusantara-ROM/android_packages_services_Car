/*
 * Copyright (C) 2019 The Android Open Source Project
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

package com.android.experimentalcar;

import java.util.TimerTask;

/**
 * Fake implementation for {@link ITimer}.
 */
public class FakeTimer implements ITimer {

    private TimerTask mPendingTask;

    @Override
    public void reset() {
        mPendingTask = null;
    }

    @Override
    public void schedule(TimerTask task, long delay) {
        mPendingTask = task;
    }

    /**
     * Immediately execute the scheduled task.
     */
    void executePendingTask() {
        mPendingTask.run();
    }
}