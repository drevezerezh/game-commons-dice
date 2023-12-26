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


internal class DiceImpl(override val max: Int, override val min: Int = 1) : Dice {

    init {
        if (min >= max) throw IllegalArgumentException("max argument shall be greater than min argument")
    }

    private val delta = max - min


    private fun rollSingleDice(): Int {
        return (StrictMath.random() * delta).toInt() + min
    }


    override fun roll(count: Int): Int {
        if (count <= 0) throw IllegalArgumentException("count argument shall be greater than 1")

        if (count == 1)
            return rollSingleDice()

        return IntRange(1, count).sumOf { rollSingleDice() }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DiceImpl) return false

        if (max != other.max) return false
        if (min != other.min) return false

        return true
    }

    override fun hashCode(): Int {
        var result = max
        result = 31 * result + min
        return result
    }


}