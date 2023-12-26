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

/**
 * A factory to build dices
 *
 * Keep the created dices into a cache to avoid several instance of the same dice
 */
internal object DiceFactory {

    private val diceCache: MutableMap<String, Dice> = HashMap()

    fun getDice(min: Int, max: Int ): Dice {
        val diceId: String = "" + max + "x" + min
        return diceCache.computeIfAbsent(diceId) {
            DiceImpl(max, min)
        }
    }
    fun getDice(max: Int): Dice = getDice(1,max)

    fun createBagBuilder(): DiceBagBuilder {
        return DiceBagBuilderImpl()
    }
}