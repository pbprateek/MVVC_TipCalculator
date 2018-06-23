package com.prateek.acni.tipcalculator.viewmodel

import android.databinding.BaseObservable
import com.prateek.acni.tipcalculator.model.Calculator
import com.prateek.acni.tipcalculator.model.TipCalculation

//val calculator: Calculator=Calculator()  we do this to keep default values of calculator
// if in case nothing is provided
class CalculatorViewModel(val calculator: Calculator= Calculator()):BaseObservable(){

    var inputCheckAmount = ""

    var inputTipPrct =""

    var outputCheckAmount=""
    var outputTipAmount=""
    var outputTotalDollarAmount=""
    init{
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc:TipCalculation){
        outputCheckAmount=tc.checkAmount.toString()
        outputTipAmount=tc.tipAmount.toString()
        outputTotalDollarAmount=tc.grandTotal.toString()

    }

    fun calculateTip(){
        val checkAmount=inputCheckAmount.toDoubleOrNull()
        val tipPrct=inputTipPrct.toIntOrNull()

        if(checkAmount != null && tipPrct!=null){
            updateOutputs(calculator.calculateTip(checkAmount,tipPrct))
            notifyChange()
            clearInput()
        }
    }

    private fun clearInput() {
        inputCheckAmount="0.00"
        inputTipPrct="0"

    }


}