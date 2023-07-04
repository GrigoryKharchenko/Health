package com.health.data.interactor

import android.content.Context
import com.health.domain.interactor.PurposeInteractor
import com.health.domain.repository.DataStoreRepository
import com.health.presentation.screen.onboarding.gender.GenderSex
import com.health.presentation.screen.onboarding.purpose.Purposes
import javax.inject.Inject
import kotlin.math.pow

class PurposeInteractorImpl @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val context: Context
) : PurposeInteractor {

    override suspend fun calculatePfc(purpose: String) {
        with(dataStoreRepository) {
            val amountCalories =
                if (getGender() == GenderSex.MAN.sex) {
                    (COEFFICIENT_WEIGHT * getWeight() + COEFFICIENT_HEIGHT * getHeight() -
                            COEFFICIENT_AGE * getAge() + COEFFICIENT_MAN) * getActivityCoefficient()
                } else {
                    (COEFFICIENT_WEIGHT * getWeight() + COEFFICIENT_HEIGHT * getHeight() -
                            COEFFICIENT_AGE * getAge() - COEFFICIENT_WOMAN) * getActivityCoefficient()
                }
            val calories = selectedPurpose(amountCalories, purpose)
            setCalories(calories)

            val amountProtein =
                (calories * COEFFICIENT_PROTEIN / AMOUNT_CALORIES_IN_PROTEIN).toInt()
            setProtein(amountProtein)

            val amountFats = (calories * COEFFICIENT_FATS / AMOUNT_CALORIES_IN_FATS).toInt()
            setFats(amountFats)

            val amountCrabs =
                (calories * COEFFICIENT_CRABS / AMOUNT_CALORIES_IN_CRABS).toInt()
            setCrabs(amountCrabs)

            val heightInMeter = getHeight().toDouble() / METER
            val indexMass =
                (getWeight() / heightInMeter.pow(2))
            setIndexMass(indexMass)
        }
    }

    private suspend fun selectedPurpose(pfc: Double, purpose: String): Int {
        dataStoreRepository.setPurpose(purpose)
        return when (dataStoreRepository.getPurpose()) {
            context.getString(Purposes.WEIGHT_LOSS.purpose) -> (pfc * COEFFICIENT_LOSS_WEIGHT).toInt()
            context.getString(Purposes.WEIGHT_SAVE.purpose) -> pfc.toInt()
            else -> (pfc * COEFFICIENT_GAIN_WEIGHT).toInt()
        }
    }

    companion object {
        private const val COEFFICIENT_AGE = 5
        private const val COEFFICIENT_WEIGHT = 10
        private const val COEFFICIENT_HEIGHT = 6.25
        private const val COEFFICIENT_MAN = 5
        private const val COEFFICIENT_WOMAN = 161
        private const val COEFFICIENT_PROTEIN = 0.3
        private const val COEFFICIENT_FATS = 0.3
        private const val COEFFICIENT_CRABS = 0.4
        private const val AMOUNT_CALORIES_IN_PROTEIN = 4
        private const val AMOUNT_CALORIES_IN_FATS = 9
        private const val AMOUNT_CALORIES_IN_CRABS = 4
        private const val COEFFICIENT_LOSS_WEIGHT = 0.8
        private const val COEFFICIENT_GAIN_WEIGHT = 1.2
        private const val METER = 100
    }
}
