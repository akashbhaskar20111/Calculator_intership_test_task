package com.example.intership_calcultor
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.intership_calcultor.ui.theme.Orange


//import com.example.my_calculator.CalculatorButton



@Composable
fun Calculator(
    buttonSpacing: Dp=8.dp,
    modifier: Modifier=Modifier,
){
    val context=LocalContext.current
    var expression by remember { mutableStateOf("") }
    var history by remember { mutableStateOf(mutableListOf<String>()) }
    var isVisible by remember {
        mutableStateOf(false)
    }







    Box(modifier = Modifier) {


        if (isVisible) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)) {
                // Display the history at the top
                if(history.isNotEmpty()){
//                    Button(onClick = {history.clear()}) {
//                        Text(text = "clear")
//                    }

                    Button(modifier= Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .zIndex(.1f)
                        .align(Alignment.TopEnd)
                        .padding(16.dp),
                        onClick = {
                            history = mutableListOf()
                        },

                    ) {
                        Text("Clear")
                    }

                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopStart)
                        .background(Color.Gray)
                        .padding(16.dp)
                ) {
                    item { Text(text = "history") }
                    items(history) { item ->

                        Text(text = item, color = Color.White, fontSize = 20.sp)
                    }
                }
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)

        ) {
            Text(
                text = expression,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(.9f)
                    .padding(vertical = 20.dp),
                fontWeight = FontWeight.Light,
                fontSize = 60.sp,
                color = Color.Yellow,
                maxLines = 1
            )



            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {

                CalculatorButton(symbol =
                "His", modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {isVisible=!isVisible  })

                CalculatorButton(symbol =
                "AC", modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {  expression = "" })

                CalculatorButton(symbol =
                "Del", modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        if (expression.isNotEmpty()) {
                            expression = expression.dropLast(1)
                        }
                    })


                CalculatorButton(symbol =
                "/", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {  if (endsWithOperator(expression)) expression += "/"  })

            }


            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol =
                "7", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        if(validLength(expression))
                        expression += "7"

                    })

                CalculatorButton(symbol =
                "8", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = { if(validLength(expression))  expression += "8"  })

                CalculatorButton(symbol =
                "9", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {if(validLength(expression)) expression += "9"   })


                CalculatorButton(symbol =
                "X", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {  if (endsWithOperator(expression)) expression += "*" })

            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol =
                "4", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {if(validLength(expression))  expression += "4" })

                CalculatorButton(symbol =
                "5", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {if(validLength(expression))  expression+="5" })

                CalculatorButton(symbol =
                "6", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {if(validLength(expression))  expression+="6"  })


                CalculatorButton(symbol =
                "-", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = { if (endsWithOperator(expression)) expression+="-"   })

            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol =
                "1", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = { if(validLength(expression)) expression+="1"  })

                CalculatorButton(symbol =
                "2", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {if(validLength(expression))  expression+="2"  })

                CalculatorButton(symbol =
                "3", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = { if(validLength(expression)) expression+="3"  })


                CalculatorButton(symbol =
                "+", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        if (endsWithOperator(expression))
                        expression+="+"  })

            }


            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CalculatorButton(symbol =
                "0", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(2f)
                    .weight(2f),
                    onClick = { expression+="0" })

                CalculatorButton(symbol =
                ".", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {  expression+="." })
//                val ans=0.0
                CalculatorButton(symbol =
                "=", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        val temp=expression
                        try {
                            if (!isValidMathExpression(expression)) {
                                throw IllegalArgumentException("Invalid expression")
                            }

                            expression = shrinkDecimalToThreeDigits(evaluateExpression(expression))

                            val newHistoryItem = "$temp = $expression"
                            history = history.toMutableList().apply { add(newHistoryItem) }
                        } catch (e: IllegalArgumentException) {
                            showToast(context, "Invalid expression")
                            expression = ""
                        }
                    }
                )


                }
            }

        }

}
fun shrinkDecimalToThreeDigits(value: Double): String {
    return String.format("%.2f", value)
}

fun validLength(string: String): Boolean {
    return string.length <= 9
}

fun endsWithOperator(input: String): Boolean {
    if (input.isEmpty()) {
        return false
    }

    val lastChar = input.last()
    return !(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/')
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(text = symbol, fontSize = 36.sp,
            color = MaterialTheme.colorScheme.background)
    }
}



@Composable
fun StringListLazyColumn(stringList: List<String>) {
    LazyColumn {
        items(stringList) { item ->
            Text(text = item, modifier = Modifier.padding(16.dp))
        }
    }
}


fun isValidMathExpression(expression: String): Boolean {
    val validOperators = setOf('+', '-', '*', '/')

    // Ensure that the expression is not empty
    if (expression.isEmpty()) {
        return false
    }

    // Ensure that the expression does not start or end with an operator
    if (validOperators.contains(expression.first()) || validOperators.contains(expression.last())) {
        return false
    }

    // Ensure that consecutive operators are not allowed
    for (i in 1 until expression.length) {
        if (validOperators.contains(expression[i]) && validOperators.contains(expression[i - 1])) {
            return false
        }
    }

    // Check for other custom rules based on your requirements

    return true
}

fun showToast(context: Context, message: String) {
    val duration = Toast.LENGTH_SHORT
    Toast.makeText(context, message, duration).show()
}