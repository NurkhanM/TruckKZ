package product.truckkz.models.createProducts.newProducts

import com.google.gson.annotations.SerializedName

data class FieldValue(
    @SerializedName("VIN код")
    val vin_kod: String,
    @SerializedName("Коробка передач")
    val korobka_peredach: String,
    @SerializedName("Кузов")
    val kuzov: String,
    @SerializedName("Модель")
    val model: String,
    @SerializedName("Объем двигателя")
    val obem_dvigatelya: String,
    @SerializedName("Привод")
    val privod: String,
    @SerializedName("Пробег (км.)")
    val probeg: String,
    @SerializedName("Растаможка")
    val rastamojka: String,
    @SerializedName("Руль")
    val rul: String,
    @SerializedName("Техническое состояние")
    val teh_sost: String,
    @SerializedName("Топливо")
    val toplivo: String
)