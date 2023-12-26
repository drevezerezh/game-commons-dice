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


internal class DiceBagImpl : DiceBag {

    private val diceMap: MutableMap<Dice, Int> = HashMap()


    fun addDice(dice: Dice, count: Int = 1) {
        if (count <= 0) throw IllegalArgumentException("count argument shall be greater than 0")
        diceMap[dice] = (diceMap[dice] ?: 0) + count
    }

    fun isEmpty(): Boolean {
        return diceMap.isEmpty()
    }


    override fun content(): Set<Pair<Dice, Int>> {
        return diceMap.map { Pair(it.key, it.value) }.toSet()
    }


    override fun roll(count: Int): Int {
        if (count <= 0) throw IllegalArgumentException("count argument shall be greater than 0")
        if (diceMap.isEmpty()) throw EmptyBagException("The bag dos not contain any bag")

        var sum = 0
        for (index in 1..count) {
            sum += diceMap.map { it.key.roll(it.value) }.sum()
        }
        return sum
    }
}