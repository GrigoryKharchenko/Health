package com.health.domain.repository

interface DataStoreRepository {

    suspend fun setGender(gender: Int)

    suspend fun getGender(): Int

    suspend fun setActivityCoefficient(activityCoefficient: Double)

    suspend fun getActivityCoefficient(): Double

    suspend fun setAge(age: Int)

    suspend fun getAge(): Int

    suspend fun setHeight(height: Int)

    suspend fun getHeight(): Int

    suspend fun setWeight(weight: Int)

    suspend fun getWeight(): Int

    suspend fun setPurpose(purpose: String)

    suspend fun getPurpose(): String

    suspend fun setCalories(calories: Int)

    suspend fun getCalories(): Int

    suspend fun setProtein(protein: Int)

    suspend fun getProtein(): Int

    suspend fun setFats(fats: Int)

    suspend fun getFats(): Int

    suspend fun setCrabs(crabs: Int)

    suspend fun getCrabs(): Int

    suspend fun setIndexMass(indexMass: Double)

    suspend fun getIndexMass(): Double

    suspend fun setDailyCalories(calories: Int)

    suspend fun getDailyCalories(): Int

    suspend fun setDailyProtein(protein: Int)

    suspend fun getDailyProtein(): Int

    suspend fun setDailyFats(fats: Int)

    suspend fun getDailyFats(): Int

    suspend fun setDailyCrabs(crabs: Int)

    suspend fun getDailyCrabs(): Int

    suspend fun setAuthorized(isAuthorized: Boolean)

    suspend fun isAuthorized(): Boolean

    suspend fun setDate(date: String)

    suspend fun getDate(): String
}
