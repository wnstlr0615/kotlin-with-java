package chapter02.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

//== 1. try catch finally 구문 ==//
fun parseIntOrThrow(str: String): Int{
    try {
            return str.toInt()
        }catch (e : NumberFormatException){
            throw IllegalArgumentException("주어진 문자열 ${str}은 숫자가 아닙니다.")
        }
}

// null 반환
// return 은 한번 만 사용할 수 있다.
fun parseIntOrNull(str: String): Int?{
    return try{
        str.toInt()
    }catch(e: NumberFormatException){
        null
    }
}

//== 2. Checked Exception 과 UncheckedException ==//
// 코틀린에서는 Checked Exception과 Unchecked Exception을 구분 하지 않는다.
// 모두 Unchecked Exception 으로 구분
fun readFile(){
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

//== 3. try with resources ==//
// 코틀린에서는 try with resources 구문이 없다
// 다음 처럼 사용 시 사용 후 자원 반납
fun readFile(path: String){
    BufferedReader(FileReader(path)).use{ reader ->
        println(reader.readLine())
    }
}