fun main(args: Array<String>) {
    val arg = "1996"
    println("arg: " + arg)
    // 処理準備
    // argsをチェックして西暦から和暦への変換なのか、和暦から西暦への変更なのかモードを決定する
        // note: Kotlinには三項演算子がないらしい
    val regexForYearNumber = Regex("""¥d{4}""")
    val regexForJapanEra = Regex("""^[\u4E00-\u9FFF\u3005-\u3007]+$""")
    var isToJapanEra = true
    var isToisToYearNumber = false

    // 引数が西暦の場合、「和暦への変換」モード
    if(regexForYearNumber.containsMatchIn(arg)) {
		isToJapanEra = true
    } else if(regexForJapanEra.containsMatchIn(arg)) {
		println("西暦変換モードはサポートされていません。")
    }
    // TODO: 数字を全角から半角に統一

    // 和暦への変換の場合
    if(isToJapanEra) {
        println("実行モード: 和暦への変換")
        val yearNumber = arg.toInt()
        // 1926年より前であれば処理不能
        if(yearNumber < 1926) {
            println("大正はサポートされていません")
        } else if(1926 <= yearNumber && yearNumber <= 1989) {	// 1926年以降、1989年までは昭和
            println("昭和")
        } else if(1989 <= yearNumber && yearNumber <= 2019) {	// 1989年以降、2019年までは平成
            println("平成")
        } else if(2019 <= yearNumber) {	// 2019年以降は令和
            println("令和")
        }
    }
    	
    // 西暦への変換の場合
    	// 年号と年数を分割する
    	// 昭和1年から昭和64年まで
    	// 平成1年から平成31年まで
    	// 令和1年から
}