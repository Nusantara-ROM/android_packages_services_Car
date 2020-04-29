/*
 * Copyright (C) 2020 The Android Open Source Project
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
package android.car.testapi;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doAnswer;

import android.annotation.NonNull;
import android.car.Car;
import android.os.RemoteException;

/**
 * Provides common Mockito calls for Car-specific classes.
 */
public final class CarMockitoHelper {

    /**
     * Mocks a call to {@link Car#handleRemoteExceptionFromCarService(RemoteException, Object)} so
     * it returns the passed as 2nd argument.
     */
    public static void mockHandleRemoteExceptionFromCarServiceWithDefaultValue(
            @NonNull Car car) {
        doAnswer((invocation) -> {
            return invocation.getArguments()[1];
        }).when(car).handleRemoteExceptionFromCarService(isA(RemoteException.class), any());
    }

    private CarMockitoHelper() {
        throw new UnsupportedOperationException("contains only static methods");
    }
}
