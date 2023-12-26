/*
 * Copyright (c) 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.drevezerezh.gamecommons.dice

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*


internal class DiceImplTest {

    @RepeatedTest(10)
    fun `roll() roll single dice`() {
        assertThat(DiceImpl(6).roll())
            .isIn(IntRange(1, 6))
    }


    @RepeatedTest(10)
    fun `roll() roll several dices`() {
        assertThat(DiceImpl(6).roll(10))
            .isIn(IntRange(10, 60))
    }


    @Test
    @DisplayName("fun max shall be equal to max argument")
    fun `min() max() shall return expected max`() {
        assertThat(DiceImpl(3))
            .extracting("min", "max")
            .containsExactly(1, 3)
    }


    @Test
    fun `min() max() shall return expected min`() {
        assertThat(DiceImpl(8, 2))
            .extracting("min", "max")
            .containsExactly(2, 8)
    }


    @Test
    @DisplayName("fun min shall be equal to 1 when min not defined")
    fun `min() max() shall return default min`() {
        assertThat(DiceImpl(8))
            .extracting("min", "max")
            .containsExactly(1, 8)
    }
}