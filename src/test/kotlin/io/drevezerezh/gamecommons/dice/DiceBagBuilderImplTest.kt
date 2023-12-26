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

import io.drevezerezh.gamecommons.dice.Dices.D10
import io.drevezerezh.gamecommons.dice.Dices.D6
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DiceBagBuilderImplTest {


    private var bagBuilder = DiceBagBuilderImpl()

    @BeforeEach
    fun setUp() {
        bagBuilder = DiceBagBuilderImpl()
    }

    @Test
    fun `add(Dice,Int) shall accept a dice once`() {
        bagBuilder.add(D6)

        assertThat(bagBuilder.build().roll())
            .isBetween(1, 6)
    }

    @Test
    fun `add(Dice,Int) shall accept a dice several times`() {
        bagBuilder.add(D6, 3)

        assertThat(bagBuilder.build().roll())
            .isBetween(3, 18)
    }

    @Test
    fun `dice(Dice,Int) shall not accept a count argument lower than 1`() {
        assertThatThrownBy {
            bagBuilder.add(D6, 0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    fun `build() shall accept single dice type once`() {
        val bag = bagBuilder.add(D6).build()

        assertThat(bag.roll())
            .isBetween(1, 6)
    }

    @Test
    fun `build() shall accept single dice type several times`() {
        val bag = bagBuilder.add(D6, 4).build()

        assertThat(bag.roll())
            .isBetween(4, 24)
    }

    @Test
    fun `build() shall accept several dice types once`() {
        val bag = bagBuilder.add(D6).add(D10).build()

        assertThat(bag.roll())
            .isBetween(2, 16)
    }

    @Test
    fun `build() shall accept several dice types once several times`() {
        val bag = bagBuilder.add(D6, 2).add(D10, 2).build()

        assertThat(bag.roll())
            .isBetween(4, 32)
    }
}