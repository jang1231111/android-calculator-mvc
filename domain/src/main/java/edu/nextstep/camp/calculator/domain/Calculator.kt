package edu.nextstep.camp.calculator.domain

class Calculator {

    fun calculator(input : String?) : Double{
        require(!input.isNullOrEmpty())
        val inputs = input.split(" ");
        return excuteFuction(inputs)
    }

    private fun excuteFuction(inputs: List<String>) : Double {
        var acc =  inputs.first().toDouble()
        var index = 1
        while (index < inputs.size){
            val opratorSymbol = inputs[index++]
            val operator = opratorSymbol.findOperatorBySymbol()
            val newValue = inputs[index++].toDouble()
            acc = operator.execute(acc, newValue)
        }
        return acc
    }

    private fun String.findOperatorBySymbol(): Operator = Operator.findBySymbol(this)
}