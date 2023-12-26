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
 * Builder of dice bag
 */
interface DiceBagBuilder {

    /**
     * Add a dice to the bag
     * @param dice the type of dice to add
     * @param count the count of dices to add, shall be greater than 0
     * @return the builder instance
     */
    fun add(dice: Dice, count: Int = 1): DiceBagBuilder

    /**
     * Create the bag
     * @return a bag with all dices
     * @throws EmptyBagException when no dice declared in builder
     */
    fun build(): DiceBag

}