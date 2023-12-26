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

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.*

internal class DiceBagImplTest {

    var bag = DiceBagImpl()

    val D6 = DiceFactory.getDice(6)
    val D10 = DiceFactory.getDice(10)

    @BeforeEach
    fun setUp() {
        bag = DiceBagImpl()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `addDice shall Not accept dice count lower than 1`() {
        assertThatThrownBy { bag.addDice(D6, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy { bag.addDice(D6, -2) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    fun `addDice shall accept a single dice with count 1`() {
        bag.addDice(D6)

        assertThat(bag.content()).containsOnly(Pair(D6, 1))
    }


    @Test
    fun `addDice shall accept a several dices with counts greater than 1`() {
        bag.addDice(D6, 3)
        bag.addDice(D10, 5)

        assertThat(bag.content()).containsOnly(
            Pair(D6, 3),
            Pair(D10, 5)
        )
    }


    @Test
    fun `content() shall return empty set when no dice in bag`() {
        assertThat(bag.content())
            .isEmpty()
    }

    @RepeatedTest(10)
    fun `roll shall roll a bag with single dice once`() {
        bag.addDice(D6)

        assertThat(bag.roll())
            .isIn(IntRange(1, 6))
    }


    @RepeatedTest(10)
    fun `roll shall roll a bag with single dice several times`() {
        bag.addDice(D6)

        assertThat(bag.roll(10))
            .isIn(IntRange(10, 60))
    }


    @RepeatedTest(10)
    fun `roll shall roll a bag several times`() {
        bag.addDice(D6, 5)
        bag.addDice(D10, 2)

        assertThat(bag.roll(10))
            .isIn(IntRange(70, 500))
    }


    @Test
    fun `roll shall not accept to roll empty bag`() {
        assertThatThrownBy {
            bag.roll()
        }.isInstanceOf(EmptyBagException::class.java)
    }
}