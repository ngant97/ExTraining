package com.example.myapplication.ExTraining.db;

import com.google.gson.annotations.SerializedName;

public class LoanResponseJson {
    @SerializedName("loanPeriodInMonths")
    private int loanPeriodInMonths;
    @SerializedName("loanAmount")
    private int loanAmount;
    @SerializedName("formattedAnnualInterestRateInPercent")
    private String formattedAnnualInterestRateInPercent;
    @SerializedName("totalPayments")
    private float totalPayments;
    @SerializedName("currencySymbol")
    private String currencySymbol;
    @SerializedName("annualInterestRateInPercent")
    private float annualInterestRateInPercent;
    @SerializedName("monthlyPayment")
    private float monthlyPayment;
    @SerializedName("formattedMonthlyPayment")
    private String formattedMonthlyPayment;
    @SerializedName("formattedLoanPeriodInMonths")
    private int formattedLoanPeriodInMonths;
    @SerializedName("formattedTotalPayments")
    private String formattedTotalPayments;


    public int getLoanPeriodInMonths() {
        return loanPeriodInMonths;
    }

    public void setLoanPeriodInMonths(int loanPeriodInMonths) {
        this.loanPeriodInMonths = loanPeriodInMonths;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getFormattedAnnualInterestRateInPercent() {
        return formattedAnnualInterestRateInPercent;
    }

    public void setFormattedAnnualInterestRateInPercent(String formattedAnnualInterestRateInPercent) {
        this.formattedAnnualInterestRateInPercent = formattedAnnualInterestRateInPercent;
    }

    public float getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(float totalPayments) {
        this.totalPayments = totalPayments;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public float getAnnualInterestRateInPercent() {
        return annualInterestRateInPercent;
    }

    public void setAnnualInterestRateInPercent(float annualInterestRateInPercent) {
        this.annualInterestRateInPercent = annualInterestRateInPercent;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getFormattedMonthlyPayment() {
        return formattedMonthlyPayment;
    }

    public void setFormattedMonthlyPayment(String formattedMonthlyPayment) {
        this.formattedMonthlyPayment = formattedMonthlyPayment;
    }

    public int getFormattedLoanPeriodInMonths() {
        return formattedLoanPeriodInMonths;
    }

    public void setFormattedLoanPeriodInMonths(int formattedLoanPeriodInMonths) {
        this.formattedLoanPeriodInMonths = formattedLoanPeriodInMonths;
    }

    public String getFormattedTotalPayments() {
        return formattedTotalPayments;
    }

    public void setFormattedTotalPayments(String formattedTotalPayments) {
        this.formattedTotalPayments = formattedTotalPayments;
    }
}
