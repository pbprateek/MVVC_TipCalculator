package com.prateek.acni.tipcalculator.model

import java.math.RoundingMode

class Calculator {

    fun calculateTip(checkAmt: Double, tipPct: Int): TipCalculation {


        //to round off doubles like 1.7999999999999999 to 1.8
        val tipAmount = checkAmt * (tipPct.toDouble() / 100.0).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
        val grandTotal = checkAmt + tipAmount

        return TipCalculation(
                checkAmount = checkAmt, tipPct = tipPct, tipAmount = tipAmount, grandTotal = grandTotal
        )

    }
}