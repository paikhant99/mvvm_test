
package com.paikhantko.mvvm_test.models.entities;

import lombok.Data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.paikhantko.mvvm_test.utils.AppConstants;

@Data
@Entity(tableName = AppConstants.ROW_TABLE_NAME)
@SuppressWarnings("unused")
public class Row {

    public Row() {
        super();
    }

    @PrimaryKey
    @NonNull
    private String country;

    @SerializedName("active_cases")
    private String activeCases;

    @SerializedName("cases_per_mill_pop")
    private String casesPerMillPop;

    @SerializedName("country_abbreviation")
    private String countryAbbreviation;

    private String flag;

    @SerializedName("new_cases")
    private String newCases;

    @SerializedName("new_deaths")
    private String newDeaths;

    @SerializedName("serious_critical")
    private String seriousCritical;

    @SerializedName("total_case")
    private String totalCases;

    @SerializedName("total_deaths")
    private String totalDeaths;

    @SerializedName("total_recovered")
    private String totalRecovered;

}
