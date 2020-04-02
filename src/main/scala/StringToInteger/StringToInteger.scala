package StringToInteger

object Solution {

    def myAtoi(str: String): Int = {
        var p = str.trim

        var r = BigInt(0)

        if (p.isEmpty()) 0 
        else if (p.length() == 1) {
            if (p(0) < '0' || p(0) > '9') 0 else p(0) - '0'
        }
        else {
            if ((p(0) == '-' || p(0) == '+')&& (p(1) < '0' || p(1) > '9')) 0
            else {
                var tag = 1
                if (p(0) == '-') { tag = -1; p = p.tail }
                if (p(0) == '+') {p = p.tail}

                while(p.nonEmpty && p(0) <= '9' && p(0) >= '0') {
                    r = r * 10 + p(0) - '0'
                    if (r*tag > Int.MaxValue) { r = Int.MaxValue; p = "" }
                    if (r * tag < Int.MinValue)  { r = Int.MinValue; p = ""}
                    p = p.tail
                }
                r.toInt * tag
            }
        }

    }

    def main(args: Array[String]) = {
        println(myAtoi("42"))
        println(myAtoi("-42"))
        println(myAtoi("+42fdsfdsds"))
        println(myAtoi("   -42fdsfdsds"))
        println(myAtoi("-fdsfdsds"))
        println(myAtoi("-fdsfdsds 4343"))
        println(myAtoi("45fdsfdsds 4343"))
    }
}