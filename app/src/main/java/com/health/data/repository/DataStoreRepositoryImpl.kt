package com.health.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.health.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "dataStore")

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {

    private val genderKey = intPreferencesKey("gender_key")
    private val gender = context.dataStore.data.map { pref ->
        pref[genderKey] ?: 0
    }

    private val activityCoefficientKey = doublePreferencesKey("activity_coefficient")
    private val activityCoefficient = context.dataStore.data.map { pref ->
        pref[activityCoefficientKey] ?: 1.0
    }

    private val ageKey = intPreferencesKey("age_key")
    private val age = context.dataStore.data.map { pref ->
        pref[ageKey] ?: 0
    }

    private val heightKey = intPreferencesKey("height_key")
    private val height = context.dataStore.data.map { pref ->
        pref[heightKey] ?: 0
    }

    private val weightKey = intPreferencesKey("weight_key")
    private val weight = context.dataStore.data.map { pref ->
        pref[weightKey] ?: 0
    }

    private val purposeKey = stringPreferencesKey("purpose_key")
    private val purpose = context.dataStore.data.map { pref ->
        pref[purposeKey] ?: ""
    }

    private val dailyCaloriesKey = intPreferencesKey("daily_calories_key")
    private val dailyCalories = context.dataStore.data.map { pref ->
        pref[dailyCaloriesKey] ?: 0
    }

    private val dailyProteinKey = intPreferencesKey("daily_protein_key")
    private val dailProtein = context.dataStore.data.map { pref ->
        pref[dailyProteinKey] ?: 0
    }

    private val dailyFatsKey = intPreferencesKey("daily_fats_key")
    private val dailyFats = context.dataStore.data.map { pref ->
        pref[dailyFatsKey] ?: 0
    }

    private val dailyCrabsKey = intPreferencesKey("daily_crabs_key")
    private val dailyCrabs = context.dataStore.data.map { pref ->
        pref[dailyCrabsKey] ?: 0
    }

    private val indexMassKey = doublePreferencesKey("index_mass_key")
    private val indexMass = context.dataStore.data.map { pref ->
        pref[indexMassKey] ?: 0.0
    }

    private val caloriesKey = intPreferencesKey("calories_key")
    private val calories = context.dataStore.data.map { pref ->
        pref[caloriesKey] ?: 0
    }

    private val proteinKey = intPreferencesKey("protein_key")
    private val protein = context.dataStore.data.map { pref ->
        pref[proteinKey] ?: 0
    }

    private val fatsKey = intPreferencesKey("fats_key")
    private val fats = context.dataStore.data.map { pref ->
        pref[fatsKey] ?: 0
    }

    private val crabsKey = intPreferencesKey("crabs_key")
    private val crabs = context.dataStore.data.map { pref ->
        pref[crabsKey] ?: 0
    }

    private val isAuthorizedKey = booleanPreferencesKey("is_authorized_key")
    private val isAuthorized = context.dataStore.data.map { pref ->
        pref[isAuthorizedKey] ?: false
    }

    private val dateKey = stringPreferencesKey("date_key")
    private val date = context.dataStore.data.map { pref ->
        pref[dateKey] ?: ""
    }

    override suspend fun setGender(gender: Int) {
        context.dataStore.edit { pref ->
            pref[genderKey] = gender
        }
    }

    override suspend fun getGender(): Int = gender.first()

    override suspend fun setActivityCoefficient(activityCoefficient: Double) {
        context.dataStore.edit { pref ->
            pref[activityCoefficientKey] = activityCoefficient
        }
    }

    override suspend fun getActivityCoefficient(): Double = activityCoefficient.first()

    override suspend fun setAge(age: Int) {
        context.dataStore.edit { pref ->
            pref[ageKey] = age
        }
    }

    override suspend fun getAge(): Int = age.first()

    override suspend fun setHeight(height: Int) {
        context.dataStore.edit { pref ->
            pref[heightKey] = height
        }
    }

    override suspend fun getHeight(): Int = height.first()

    override suspend fun setWeight(weight: Int) {
        context.dataStore.edit { pref ->
            pref[weightKey] = weight
        }
    }

    override suspend fun getWeight(): Int = weight.first()

    override suspend fun setPurpose(purpose: String) {
        context.dataStore.edit { pref ->
            pref[purposeKey] = purpose
        }
    }

    override suspend fun getPurpose(): String = purpose.first()

    override suspend fun setCalories(calories: Int) {
        context.dataStore.edit { pref ->
            pref[caloriesKey] = calories
        }
    }

    override suspend fun getCalories(): Int = calories.first()

    override suspend fun setProtein(protein: Int) {
        context.dataStore.edit { pref ->
            pref[proteinKey] = protein
        }
    }

    override suspend fun getProtein(): Int = protein.first()

    override suspend fun setFats(fats: Int) {
        context.dataStore.edit { pref ->
            pref[fatsKey] = fats
        }
    }

    override suspend fun getFats(): Int = fats.first()

    override suspend fun setCrabs(crabs: Int) {
        context.dataStore.edit { pref ->
            pref[crabsKey] = crabs
        }
    }

    override suspend fun getCrabs(): Int = crabs.first()

    override suspend fun setIndexMass(indexMass: Double) {
        context.dataStore.edit { pref ->
            pref[indexMassKey] = indexMass
        }
    }

    override suspend fun getIndexMass(): Double = indexMass.first()

    override suspend fun setDailyCalories(calories: Int) {
        context.dataStore.edit { pref ->
            pref[dailyCaloriesKey] = calories
        }
    }

    override suspend fun getDailyCalories(): Int = dailyCalories.first()

    override suspend fun setDailyProtein(protein: Int) {
        context.dataStore.edit { pref ->
            pref[dailyProteinKey] = protein
        }
    }

    override suspend fun getDailyProtein(): Int = dailProtein.first()

    override suspend fun setDailyFats(fats: Int) {
        context.dataStore.edit { pref ->
            pref[dailyFatsKey] = fats
        }
    }

    override suspend fun getDailyFats(): Int = dailyFats.first()

    override suspend fun setDailyCrabs(crabs: Int) {
        context.dataStore.edit { pref ->
            pref[dailyCrabsKey] = crabs
        }
    }

    override suspend fun getDailyCrabs(): Int = dailyCrabs.first()

    override suspend fun setAuthorized(isAuthorized: Boolean) {
        context.dataStore.edit { pref ->
            pref[isAuthorizedKey] = isAuthorized
        }
    }

    override suspend fun isAuthorized(): Boolean = isAuthorized.first()

    override suspend fun setDate(date: String) {
        context.dataStore.edit { pref ->
            pref[dateKey] = date
        }
    }

    override suspend fun getDate(): String = date.first()
}
