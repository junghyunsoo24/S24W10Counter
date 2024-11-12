package kr.ac.kumoh.s20191091.s24w10counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20191091.s24w10counter.ui.theme.S24W10CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S24W10CounterTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//        Column(
//            modifier = Modifier.padding(innerPadding).fillMaxSize(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//        ){
//            Counter()
//            Counter()
//        }
//        Clicker(Modifier.padding(innerPadding))
        Counter(Modifier.padding(innerPadding))

    }
}

@Composable
fun Counter(modifier: Modifier = Modifier){
//    var count = 0;
    val (count, setCount) = rememberSaveable { mutableIntStateOf(0) }
    val (expanded, setExpanded) = rememberSaveable{mutableStateOf(false)}
    //data는 뷰모델로 따로 빼는게 좋기 때문에 rememberable은 안쓰는게 좋음

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            fontSize = 100.sp
        )

        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = {
                //count++
                setCount(count + 1)
                setExpanded(false)
            }
        ) {
            Text(
                "증가",
                fontSize = 30.sp
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = {
                setExpanded(true)
            }
        ) {
            Text(
                "더보기",
                fontSize = 30.sp
            )
        }

        AnimatedVisibility (expanded) {
            Row {
                Button(
                    modifier = Modifier.padding(16.dp).weight(1F),
                    onClick = {
                        if (count > 0) {
                            setCount(count - 1)
                        }
                        setExpanded(false)
                    }
                ) {
                    Text(
                        "감소",
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier.padding(16.dp).weight(1F),
                    onClick = {
                        setCount(0)
                        setExpanded(false)
                    }
                ) {
                    Text(
                        "초기화",
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
    //list를 만들때 jetpackCompose가 바인딩보다 훨신 편함
}

@Composable
fun Clicker(modifier: Modifier = Modifier) {
//    var txtString = "눌러주세요";
//    var txtString by remember { mutableStateOf("눌러주세요") }
//    val txtString = remember { mutableStateOf("눌러주세요") }//잘 안씀
    val (txtString, setTxtString) = remember { mutableStateOf("눌러주세요") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = txtString,
//            text = txtString.value,
            fontSize = 60.sp,
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
//                txtString = "눌렸습니다"
//                txtString.value = "눌렸습니다"
                setTxtString("눌렸습니다")
            }
        ) {
            Text("눌러봐")
        }
    }
}