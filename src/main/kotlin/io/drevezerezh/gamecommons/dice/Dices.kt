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
 * Common dices for
 */
object Dices {

    val D2: Dice = DiceFactory.getDice(2)
    val D3: Dice = DiceFactory.getDice(3)
    val D4: Dice = DiceFactory.getDice(4)
    val D6: Dice = DiceFactory.getDice(6)
    val D8: Dice = DiceFactory.getDice(8)
    val D09: Dice = DiceFactory.getDice(0,9)
    val D10: Dice = DiceFactory.getDice(10)
    val D12: Dice = DiceFactory.getDice(12)
    val D20: Dice = DiceFactory.getDice(20)
    val D100: Dice = DiceFactory.getDice(100)

}