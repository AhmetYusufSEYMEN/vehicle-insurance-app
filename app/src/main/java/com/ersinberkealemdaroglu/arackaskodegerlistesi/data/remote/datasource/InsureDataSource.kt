package com.ersinberkealemdaroglu.arackaskodegerlistesi.data.remote.datasource

import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.model.CheckUpdateResponseModel
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.model.VehicleInsuranceResponse
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.model.blog.VehicleBlogResponse
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.model.cardatamodel.CarDataResponseModel
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.model.vehicleInsuranceCreditRates.VehicleInsuranceCreditRates
import com.ersinberkealemdaroglu.arackaskodegerlistesi.data.remote.service.InsureService
import retrofit2.Response
import javax.inject.Inject

class InsureDataSource @Inject constructor(private val insureService: InsureService) {

    suspend fun getVehicleInsurance(): Response<VehicleInsuranceResponse> =
        insureService.getVehicleInsurance()

    suspend fun getLowVehicles(): Response<CarDataResponseModel> =
        insureService.getLowVehicles()

    suspend fun checkUpdate(): Response<CheckUpdateResponseModel> =
        insureService.checkUpdate()

    suspend fun getVehicleBlog(): Response<VehicleBlogResponse> =
        insureService.getVehicleBlog()

    suspend fun getVehicleInsuranceCreditRates(): Response<VehicleInsuranceCreditRates> =
        insureService.getVehicleInsuranceCreditRates()
}