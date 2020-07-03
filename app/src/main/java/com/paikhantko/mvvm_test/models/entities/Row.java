
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

    @NonNull
    public String getCountry() {
        return country;
    }

    public void setCountry(@NonNull String country) {
        this.country = country;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getCasesPerMillPop() {
        return casesPerMillPop;
    }

    public void setCasesPerMillPop(String casesPerMillPop) {
        this.casesPerMillPop = casesPerMillPop;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getSeriousCritical() {
        return seriousCritical;
    }

    public void setSeriousCritical(String seriousCritical) {
        this.seriousCritical = seriousCritical;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}
